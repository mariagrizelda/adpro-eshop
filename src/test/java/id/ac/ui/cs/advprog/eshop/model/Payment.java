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
        this.payment = new Payment("123456", "Voucher", new HashMap<>(), "SUCCESS");
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        this.payment.setPaymentData(paymentData);
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
        assertEquals(enums.PaymentStatus.SUCCESS.getValue(), this.payment.getStatus());
    }

    @Test
    void testGetPaymentData() {
        assertEquals("ESHOP1234ABC5678", this.payment.getPaymentData().get("voucherCode"));
    }

    @Test
    void testSetId() {
        this.payment.setId("654321");
        assertEquals("654321", this.payment.getId());
    }

    @Test
    void testSetMethod() {
        this.payment.setMethod("Cash On Delivery");
        assertEquals("Cash On Delivery", this.payment.getMethod());
    }

    @Test
    void testSetStatus() {
        this.payment.setStatus("REJECTED");
        assertEquals(enums.PaymentStatus.REJECTED.getValue(), this.payment.getStatus());
    }

    @Test
    void testSetPaymentData() {
        Map<String, String> newPaymentData = new HashMap<>();
        newPaymentData.put("voucherCode", "NEWVOUCHERCODE");
        this.payment.setPaymentData(newPaymentData);
        assertEquals("NEWVOUCHERCODE", this.payment.getPaymentData().get("voucherCode"));
    }
}
