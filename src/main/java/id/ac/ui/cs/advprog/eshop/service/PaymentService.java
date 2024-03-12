package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import java.util.Optional;
import java.util.List;

public interface PaymentService {

    void update(String paymentId, String status);

    Optional<Payment> findById(String paymentId);

    List<Payment> findAll();
}
