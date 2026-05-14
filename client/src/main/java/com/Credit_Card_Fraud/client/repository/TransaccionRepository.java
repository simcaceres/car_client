package com.Credit_Card_Fraud.client.repository;

import com.Credit_Card_Fraud.client.model.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class TransaccionRepository {
    private List<Transaccion> listaTransacciones = new ArrayList<>();

    public void ingestaDesdeCSV(String ruta){

        Transaccion nueva = new Transaccion();
        nueva.setAmt(150.50);

        listaTransacciones.add(nueva);
    }


}
