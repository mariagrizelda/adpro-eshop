package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private Payment payment;

    @BeforeEach
    void setUp() {
        // setting up a payment with initial values
        this.payment = createSamplePayment();
    }

    @Test
    void testGetId() {
        assertEquals("123456", this.payment.getId());
    }

    @Test
    void testGetMethod() {
        assertEquals("Voucher", this.payment.getMethod());
    }

    @Test
    void testGetStatus() {
        assertEquals("SUCCESS", this.payment.getStatus());
    }

    @Test
    void testGetPaymentData() {
        assertEquals("ESHOP1234ABC5678", this.payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testSetId() {
        // change the ID and assert the new value
        this.payment.setId("654321");
        assertEquals("654321", this.payment.getId());
    }

    @Test
    void testSetMethod() {
        // change the payment method and assert the new value
        this.payment.setMethod("Bank Transfer");
        assertEquals("Bank Transfer", this.payment.getMethod());
    }

    @Test
    void testSetStatus() {
        // change the payment status and assert the new value
        this.payment.setStatus("REJECTED");
        assertEquals("REJECTED", this.payment.getStatus());
    }

    @Test
    void testSetPaymentData() {
        // change the payment data and assert the new value
        Map<String, String> newPaymentData = new HashMap<>();
        newPaymentData.put("voucherCode", "NEWVOUCHERCODE");
        this.payment.setPaymentData(newPaymentData);
        assertEquals("NEWVOUCHERCODE", this.payment.getPaymentData().get("voucherCode"));
    }

    private Payment createSamplePayment() {
        Payment payment = new Payment();
        payment.setId("123456");
        payment.setMethod("Voucher");
        payment.setStatus("SUCCESS");

        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        payment.setPaymentData(paymentData);

        return payment;
    }
}
