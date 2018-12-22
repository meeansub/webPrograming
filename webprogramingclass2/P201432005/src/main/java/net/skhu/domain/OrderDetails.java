package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;

    String quantity;
    String unitPrice;

}
