package net.skhu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Products
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productCode;
    String productName;

    String standardCost;
    String listPrice;
    String category;
    int reorderLevel;
    int targetLevel;

    String quantityPerUnit;

    @JsonIgnore
    @OneToMany(mappedBy = "products")
    List<OrderDetails> orderDetails;
}
