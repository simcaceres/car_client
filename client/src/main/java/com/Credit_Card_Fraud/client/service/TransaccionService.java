package com.Credit_Card_Fraud.client.service;

import com.Credit_Card_Fraud.client.model.Transaccion;
import com.Credit_Card_Fraud.client.repository.ITransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private ITransaccionRepository iTransaccionRepository;

    // ==========================================
    // TUS METODOS DE ANALÍTICA ORIGINALES
    // ==========================================
    public long contarRegistros() {
        return iTransaccionRepository.count();
    }

    public double calcularPromedioAmt() {
        return iTransaccionRepository.findAll().stream()
                .mapToDouble(Transaccion::getAmt)
                .average()
                .orElse(0.0);
    }

    public long contarFraudes() {
        return iTransaccionRepository.findByIsFraud(1).size();
    }

    // ==========================================
    // MÉTODOS CRUD E INTEGRACIÓN DE APIS
    // ==========================================

    public Transaccion guardarTransaccion(Transaccion transaccion) {
        transaccion = evaluarFraudeInternacional(transaccion);
        return iTransaccionRepository.save(transaccion);
    }

    public List<Transaccion> obtenerPorTarjeta(String ccNum) {
        return iTransaccionRepository.findByCcNum(ccNum);
    }

    public void eliminarTransaccion(String id) {
        iTransaccionRepository.deleteById(id);
    }

    public void bloquearTarjetaEmergencia(String ccNum) {
        List<Transaccion> transacciones = iTransaccionRepository.findByCcNum(ccNum);
        for (Transaccion t : transacciones) {
            t.setCategory("BLOQUEADA_VIAJE");
        }
        iTransaccionRepository.saveAll(transacciones);
    }

    private Transaccion evaluarFraudeInternacional(Transaccion t) {
        if (t.getAmt() > 5000.0 && !t.getState().equals("CL")) {
            t.setIs_fraud(1);
        } else {
            t.setIs_fraud(0);
        }
        return t;
    }
}