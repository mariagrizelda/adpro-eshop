package id.ac.ui.cs.advprog.eshop.repository;

import enums.PaymentStatus;
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
        paymentData.put(PaymentStatus.VOUCHER.getValue(), "ESHOP12345678CAB");

        payments = new ArrayList<>();
        Payment payment1 = new Payment("29f8db42-2c60-41ca-a8fd-abc8bfd947f1", PaymentStatus.VOUCHER.getValue(), paymentData, "SUCCESS");
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
        Payment payment1 = payments.get(0);
        paymentRepository.save(payment1);

        Payment newPayment = new Payment(payment1.getId(), payment1.getMethod(), payment1.getPaymentData(), payment1.getStatus());
        Payment result = paymentRepository.save(newPayment);

        Payment findResult = paymentRepository.findById(payments.get(0).getId());
        assertPaymentEquals(payment1, result);
        assertPaymentEquals(payment1, findResult);
    }

    @Test
    void testSaveCreate() {
        Payment payment1 = payments.get(0);
        Payment result = paymentRepository.save(payment1);

        Payment findResult = paymentRepository.findById(payments.get(0).getId());
        assertPaymentEquals(payment1, result);
        assertPaymentEquals(payment1, findResult);
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("none");
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
