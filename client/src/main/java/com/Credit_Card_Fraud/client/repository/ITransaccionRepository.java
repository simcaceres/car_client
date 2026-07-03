package com.Credit_Card_Fraud.client.repository;

import com.Credit_Card_Fraud.client.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, String> {
    // Buscar transacciones por número de tarjeta (Para la app móvil)
    List<Transaccion> findByCcNum(String ccNum);

    // Buscar fraudes (Para el Dashboard)
    List<Transaccion> findByIsFraud(int isFraud);
}