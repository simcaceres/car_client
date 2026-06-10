package com.Credit_Card_Fraud.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "transacciones") // Crea automáticamente la tabla 'transacciones' en PostgreSQL
public class Transaccion {

    @Id // Define esta variable como la Llave Primaria en Postgres
    @Column(name = "id")
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

    @Column(name = "city_pop") // Mapeo explícito para nombres con guion bajo
    private int city_pop;

    private double lat;
    private double lng;

    // 2. Detalles de la Transacción
    @Column(name = "trans_num")
    private String trans_num;

    @Column(name = "trans_date_trans_time")
    private String trans_date_trans_time;

    @Column(name = "unix_time")
    private long unix_time;

    private double amt;

    @Column(name = "cc_num")
    private String cc_num;

    // 3. Información del comercio
    private String merchant;
    private String category;

    @Column(name = "merch_lat")
    private double merch_lat;

    @Column(name = "merch_long")
    private double merch_long;

    // 4. Variable Objetivo
    @Column(name = "is_fraud")
    private int is_fraud;

    // Constructor vacío obligatorio para JPA
    public Transaccion(){}

    // ==========================================
    // GETTERS Y SETTERS COMPLETOS
    // ==========================================

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirst() { return first; }
    public void setFirst(String first) { this.first = first; }

    public String getLast() { return last; }
    public void setLast(String last) { this.last = last; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public int getZip() { return zip; }
    public void setZip(int zip) { this.zip = zip; }

    public int getCity_pop() { return city_pop; }
    public void setCity_pop(int city_pop) { this.city_pop = city_pop; }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public double getLng() { return lng; }
    public void setLng(double lng) { this.lng = lng; }

    public String getTrans_num() { return trans_num; }
    public void setTrans_num(String trans_num) { this.trans_num = trans_num; }

    public String getTrans_date_trans_time() { return trans_date_trans_time; }
    public void setTrans_date_trans_time(String trans_date_trans_time) { this.trans_date_trans_time = trans_date_trans_time; }

    public long getUnix_time() { return unix_time; }
    public void setUnix_time(long unix_time) { this.unix_time = unix_time; }

    public double getAmt() { return amt; }
    public void setAmt(double amt) { this.amt = amt; }

    public String getCc_num() { return cc_num; }
    public void setCc_num(String cc_num) { this.cc_num = cc_num; }

    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getMerch_lat() { return merch_lat; }
    public void setMerch_lat(double merch_lat) { this.merch_lat = merch_lat; }

    public double getMerch_long() { return merch_long; }
    public void setMerch_long(double merch_long) { this.merch_long = merch_long; }

    public int getIs_fraud() { return is_fraud; }
    public void setIs_fraud(int is_fraud) { this.is_fraud = is_fraud; }
}