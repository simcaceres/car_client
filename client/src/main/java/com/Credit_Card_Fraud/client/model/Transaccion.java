package com.Credit_Card_Fraud.client.model;

public class Transaccion {

    private String id;
    private String first;
    private String last;
    private String dob;
    private String gender;
    private String job;
    private String street;
    private String city;
    private String state;
    private int zip;
    private int city_pop;
    private double lat;
    private double lng;

    //2. Detalles de la Transacion
    private String trans_num;
    private String trans_date_trans_time;
    private long unix_time;
    private double amt;
    private String cc_num;

    // 3. Informacion del comercio
    private String merchant;
    private String category;
    private double merch_lat;
    private double merch_long;

    //4. Variable Objectivo
    private int is_fraud;

    //Constructor vacio
    public Transaccion(){}

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public int getIs_fraud() {
        return is_fraud;
    }

    public void setIs_fraud(int is_fraud) {
        this.is_fraud = is_fraud;
    }
}
