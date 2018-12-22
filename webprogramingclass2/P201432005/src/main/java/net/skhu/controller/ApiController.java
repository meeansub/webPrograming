package net.skhu.controller;

import net.skhu.domain.Customers;
import net.skhu.domain.OrderDetails;
import net.skhu.domain.Orders;
import net.skhu.domain.Products;
import net.skhu.repository.CustomersRepository;
import net.skhu.repository.OrderDetailsRepository;
import net.skhu.repository.OrdersRepository;
import net.skhu.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
public class ApiController {

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping("api/customers")
    public List<Customers> customers() {
        return customersRepository.findAll();
    }


    @RequestMapping("api/order/{id}/products")
    public List<Products> products(@PathVariable("id") int id){

        List<Products> list =new ArrayList<>();
        List<OrderDetails> orderDetail =orderDetailsRepository.findByOrdersId(id);
        for(OrderDetails o : orderDetail){
            list.add(o.getProducts());

        }
        return list;



    }




}
