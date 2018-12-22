package net.skhu.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class PurchaseOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    Double quantity;

    Double unitCost;


    @ManyToOne
    @JoinColumn(name="product_id")
    Products products;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    PurchaseOrders purchaseOrders;




}
