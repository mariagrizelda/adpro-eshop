package id.ac.ui.cs.advprog.eshop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class Order {
    String id;
    List<Product> products;
    Long orderTime;
    String author;
    @Setter
    String status;

    // Original constructor without status
    public Order(String id, List<Product> products, Long orderTime, String author) {
        // Your implementation here
    }

    // New constructor with status
    @Builder
    public Order(String id, List<Product> products, Long orderTime, String author, String status) {
        this.id = id;
        this.products = products;
        this.orderTime = orderTime;
        this.author = author;
        this.status = status;
    }
}
