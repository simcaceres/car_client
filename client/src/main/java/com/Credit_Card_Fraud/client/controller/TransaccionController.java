package com.Credit_Card_Fraud.client.controller;

import com.Credit_Card_Fraud.client.model.Transaccion;
import com.Credit_Card_Fraud.client.repository.TransaccionRepository;
import com.Credit_Card_Fraud.client.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
@CrossOrigin(origins = "*") // Permite conexiones externas (Celular / Dashboard)
public class TransaccionController implements CommandLineRunner {

    @Autowired
    private TransaccionRepository transaccionRepository; // Para tu ingesta original del CSV

    @Autowired
    private TransaccionService transaccionService; // Para las nuevas APIs del informe

    // ==========================================
    // 1. TU FUNCIÓN ORIGINAL: INGESTA AUTOMÁTICA AL INICIAR
    // ==========================================
    @Override
    public void run(String... args) throws Exception {
        // Mantiene tu lógica exacta: lee el CSV e inyecta la data en la base de datos de Render
        String rutaCSV = "C:\\Users\\tobia\\OneDrive\\Escritorio\\datos_limpios_100k.csv";
        transaccionRepository.ingestaDesdeCSV(rutaCSV);
    }

    // ==========================================
    // 2. NUEVOS ENDPOINTS HTTP (ACTIVIDAD 3.4)
    // ==========================================

    // Endpoint para ver estadísticas en el Dashboard Bancario
    @GetMapping("/estadisticas")
    public ResponseEntity<String> obtenerEstadisticas() {
        long total = transaccionService.contarRegistros();
        long fraudes = transaccionService.contarFraudes();
        return ResponseEntity.ok("{\"total_procesados\":" + total + ",\"total_fraudes\":" + fraudes + "}");
    }

    // Endpoint para que el Celular registre una nueva compra (POST)
    @PostMapping("/procesar")
    public ResponseEntity<Transaccion> procesarCompra(@RequestBody Transaccion transaccion) {
        return ResponseEntity.ok(transaccionService.guardarTransaccion(transaccion));
    }

    // Endpoint para que el Celular consulte sus movimientos (GET)
    @GetMapping("/tarjeta/{ccNum}")
    public ResponseEntity<List<Transaccion>> verHistorialCelular(@PathVariable String ccNum) {
        return ResponseEntity.ok(transaccionService.obtenerPorTarjeta(ccNum));
    }

    // Endpoint de emergencia: Bloqueo inmediato por pérdida o robo en el extranjero
    @PostMapping("/bloqueo-emergencia/{ccNum}")
    public ResponseEntity<String> bloqueoEmergencia(@PathVariable String ccNum) {
        transaccionService.bloquearTarjetaEmergencia(ccNum);
        return ResponseEntity.ok("{\"status\":\"Tarjeta " + ccNum + " bloqueada exitosamente en la nube\"}");
    }
}