package id.ac.ui.cs.advprog.eshop.service;

import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnotherPaymentServiceImplTest {

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    List<Payment> payments;

    @BeforeEach
    void setUp() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("Voucher", "ESHOP87654321CBA");

        payments = new ArrayList<>();
        Payment payment1 = new Payment("12345678-aaaa-4321-bbbb-87654321cbaa", "Voucher", paymentData, PaymentStatus.SUCCESS);
        payments.add(payment1);
        Payment payment2 = new Payment("87654321-bbbb-4321-aaaa-12345678cccc", "Credit Card", null, PaymentStatus.WAITING_PAYMENT);
        payments.add(payment2);
    }

    @Test
    void createPaymentTest() {
        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.create(payment);
        doReturn(payment).when(paymentRepository).save(payment);
        Payment result1 = paymentService.create(payment);
        verify(paymentRepository, times(2)).save(payment);
        assertEquals(payment.getId(), result1.getId());
    }

    @Test
    void createPaymentIfAlreadyExistTest() {
        Payment payment1 = payments.get(0);
        doReturn(payment1).when(paymentRepository).findById(payment1.getId());
        assertNull(paymentService.create(payment1));
        verify(paymentRepository, times(0)).save(payment1);
    }
}
