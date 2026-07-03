package com.Credit_Card_Fraud.client.service;

import com.Credit_Card_Fraud.client.model.Transaccion;
import com.Credit_Card_Fraud.client.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    // ==========================================
    // TUS METODOS DE ANALÍTICA ORIGINALES
    // ==========================================
    public long contarRegistros() {
        return transaccionRepository.count();
    }

    public double calcularPromedioAmt() {
        return transaccionRepository.findAll().stream()
                .mapToDouble(Transaccion::getAmt)
                .average()
                .orElse(0.0);
    }

    public long contarFraudes() {
        return transaccionRepository.findByIsFraud(1).size();
    }

    // ==========================================
    // MÉTODOS CRUD E INTEGRACIÓN DE APIS
    // ==========================================

    public Transaccion guardarTransaccion(Transaccion transaccion) {
        transaccion = evaluarFraudeInternacional(transaccion);
        return transaccionRepository.save(transaccion);
    }

    public List<Transaccion> obtenerPorTarjeta(String ccNum) {
        return transaccionRepository.findByCcNum(ccNum);
    }

    public void eliminarTransaccion(String id) {
        transaccionRepository.deleteById(id);
    }

    public void bloquearTarjetaEmergencia(String ccNum) {
        List<Transaccion> transacciones = transaccionRepository.findByCcNum(ccNum);
        for (Transaccion t : transacciones) {
            t.setCategory("BLOQUEADA_VIAJE");
        }
        transaccionRepository.saveAll(transacciones);
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