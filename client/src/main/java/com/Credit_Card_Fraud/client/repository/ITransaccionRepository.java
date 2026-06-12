package com.Credit_Card_Fraud.client.repository;

import com.Credit_Card_Fraud.client.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, String> {
    // Queda vacío. No metas ninguna clase ni método aquí adentro.
}