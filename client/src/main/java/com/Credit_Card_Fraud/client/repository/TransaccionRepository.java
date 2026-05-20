package com.Credit_Card_Fraud.client.repository;

import com.Credit_Card_Fraud.client.model.Transaccion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransaccionRepository {
    private List<Transaccion> listaTransacciones = new ArrayList<>();



    public void ingestaDesdeCSV(String ruta){
         System.out.println("Buscando el archivo en la ruta:"+ ruta);

         try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
             String linea;
             boolean esPrimeraLinea = true;

             while ((linea = br.readLine()) != null){

                 if (esPrimeraLinea){
                     esPrimeraLinea = false;
                     continue;
                 }
                 String[] datos = linea.split(",");

                 if (datos.length > 0){
                     Transaccion nueva = new Transaccion();


                     nueva.setAmt(150.50);
                     listaTransacciones.add(nueva);
                 }

             }
             System.out.println("Ingesta completada con exito. Registros cargados:"+ listaTransacciones.size());

         }catch (IOException e){
             System.err.println("ERROR al leer el archivo CSV en la ruta especifica: "+ e.getMessage());
         }catch (Exception e){
             System.out.println("Ocurrio un error inesperado procesando los datos:" + e.getMessage());
         }


    }


}
