package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class PurchaseOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Date submittedDate;

    @ManyToOne
    @JoinColumn(name="created_by")
    Employees employees;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    Suppliers suppliers;

}
