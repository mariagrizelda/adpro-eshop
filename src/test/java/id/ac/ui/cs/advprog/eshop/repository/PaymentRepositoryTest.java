package id.ac.ui.cs.advprog.eshop.repository;

import enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PaymentRepositoryTest {
    private PaymentRepository paymentRepository;
    private List<Payment> payments;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put(PaymentMethod.VOUCHER.getValue(), "ESHOP12345678CAB");

        payments = new ArrayList<>();
        Payment payment1 = new Payment("29f8db42-2c60-41ca-a8fd-abc8bfd947f1", PaymentMethod.VOUCHER.getValue(), paymentData, "SUCCESS");
        payments.add(payment1);
    }

    @Test
    void testFindByIdIfIdFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(0).getId());
        assertPaymentEquals(payments.get(0), findResult);
    }

    @Test
    void testSaveUpdate() {
        Payment payment = payments.get(0);
        paymentRepository.save(payment);

        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getPaymentData(), payment.getStatus());
        Payment result = paymentRepository.save(newPayment);

        Payment findResult = paymentRepository.findById(payments.get(0).getId());
        assertPaymentEquals(payment, result);
        assertPaymentEquals(payment, findResult);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(0);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payments.get(0).getId());
        assertPaymentEquals(payment, result);
        assertPaymentEquals(payment, findResult);
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("29f8db42-2c60-41ca-a8fd-abc8bfd947f1");
        assertNull(findResult);
    }

    @Test
    void testFindAll() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        List<Payment> paymentList = paymentRepository.findAll();
        assertEquals(1, paymentList.size());
        assertPaymentEquals(payments.get(0), paymentList.get(0));
    }

    private void assertPaymentEquals(Payment expected, Payment actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getMethod(), actual.getMethod());
        assertEquals(expected.getPaymentData(), actual.getPaymentData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }
}
