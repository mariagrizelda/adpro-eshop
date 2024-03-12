package enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    REJECTED("REJECTED"),
    SUCCESS("SUCCESS"),
    PENDING("PENDING"),
    CASH_ON_DELIVERY("CASH_ON_DELIVERY"),
    BANK_TRANSFER("Bank Transfer"),

    VOUCHER("Voucher");

    private final String value;

    private PaymentStatus(String value) {
        this.value = value;
    }

    public static boolean contains(String param) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.name().equals(param)) {
                return true;
            }
        }
        return false;
    }
}
