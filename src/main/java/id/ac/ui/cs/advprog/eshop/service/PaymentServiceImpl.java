package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    public Payment create(Payment payment) {
        if (paymentRepository.findById(payment.getId()) == null) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public void update(String paymentId, String status) {
        if (!isValidPaymentStatus(status)) {
            throw new IllegalArgumentException(status);
        }

        Payment payment = paymentRepository.findById(paymentId);
        if (payment != null) {
            payment.setStatus(status);
            paymentRepository.save(payment);
        } else {
            throw new IllegalArgumentException("Payment with ID " + paymentId + " not found.");
        }
    }

    private boolean isValidPaymentStatus(String status) {
        return status != null && (status.equals("SUCCESS") || status.equals("REJECTED"));
    }

    @Override
    public Optional<Payment> findById(String paymentId) {
        return Optional.ofNullable(paymentRepository.findById(paymentId));
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public String validateVoucherCode(String voucherCode) {
        if (isValidVoucherCode(voucherCode)) {
            return "SUCCESS";
        } else {
            return "REJECTED";
        }
    }

    private boolean isValidVoucherCode(String voucherCode) {
        // Your voucher code validation logic here
        return voucherCode != null && voucherCode.length() == 16 && voucherCode.startsWith("ESHOP");
    }
}
