package com.Credit_Card_Fraud.client.repository;

import com.Credit_Card_Fraud.client.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, String> {
    // Este archivo queda completamente vacío aquí adentro. Spring hace la magia solo.
}