package com.Credit_Card_Fraud.client.repository;

import com.Credit_Card_Fraud.client.model.Transaccion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransaccionRepository {

    @Autowired
    private ITransaccionRepository iTransaccionRepository;

    public void ingestaDesdeCSV(String ruta){
        System.out.println("🚀 Iniciando Pipeline - Buscando el archivo en la ruta: " + ruta);

        int registrosCargados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea;
            boolean esPrimeraLinea = true;

            while ((linea = br.readLine()) != null){

                if (esPrimeraLinea){
                    esPrimeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",");

                if (datos.length >= 23) {
                    Transaccion nueva = new Transaccion();

                    // 1. MAPEO DE LOS DATOS DEL CSV AL OBJETO
                    nueva.setId(datos[0].trim());
                    nueva.setFirst(datos[1].trim());
                    nueva.setLast(datos[2].trim());
                    nueva.setDob(datos[3].trim());
                    nueva.setGender(datos[4].trim());
                    nueva.setJob(datos[5].trim());
                    nueva.setStreet(datos[6].trim());
                    nueva.setCity(datos[7].trim());
                    nueva.setState(datos[8].trim());
                    nueva.setZip(Integer.parseInt(datos[9].trim()));
                    nueva.setCity_pop(Integer.parseInt(datos[10].trim()));
                    nueva.setLat(Double.parseDouble(datos[11].trim()));
                    nueva.setLng(Double.parseDouble(datos[12].trim()));

                    // Detalles de la transacción
                    nueva.setTrans_num(datos[13].trim());
                    nueva.setTrans_date_trans_time(datos[14].trim());
                    nueva.setUnix_time(Long.parseLong(datos[15].trim()));
                    nueva.setAmt(Double.parseDouble(datos[16].trim()));
                    nueva.setCc_num(datos[17].trim());

                    // Información del comercio
                    nueva.setMerchant(datos[18].trim());
                    nueva.setCategory(datos[19].trim());
                    nueva.setMerch_lat(Double.parseDouble(datos[20].trim()));
                    nueva.setMerch_long(Double.parseDouble(datos[21].trim()));

                    // Variable Objetivo
                    nueva.setIs_fraud(Integer.parseInt(datos[22].trim()));

                    // 2. Guardamos en PostgreSQL de Render
                    iTransaccionRepository.save(nueva);

                    registrosCargados++;
                }
            }

            System.out.println("✅ Ingesta completada con éxito en PostgreSQL. Registros insertados: " + registrosCargados);

        } catch (IOException e){
            System.err.println("ERROR al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("ERROR de formato numérico: " + e.getMessage());
        } catch (Exception e){
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}