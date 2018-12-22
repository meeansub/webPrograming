package net.skhu.controller;

import net.skhu.domain.Customers;
import net.skhu.domain.Employees;
import net.skhu.domain.Orders;
import net.skhu.domain.PurchaseOrderDetails;
import net.skhu.model.Pagination;
import net.skhu.repository.CustomersRepository;
import net.skhu.repository.EmployeesRepository;
import net.skhu.repository.OrdersRepository;
import net.skhu.repository.PurchaseOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    PurchaseOrderDetailsRepository purchaseOrderDetailsRepository;



    @RequestMapping("exam/list5")
    public String list5(Model model) {

        List<Customers> list = customersRepository.findAll();
        model.addAttribute("list", list);
        return "exam/list5";
    }

    @RequestMapping("exam/list6")
    public String list6(Model model) {

        List<PurchaseOrderDetails> list = purchaseOrderDetailsRepository.findAll();
        model.addAttribute("list", list);
        return "exam/list6";
    }


    @RequestMapping("exam/list7")
    public String list7(Pagination pagination,Model model) {

        List<Customers> list = customersRepository.findAll(pagination);
        model.addAttribute("list", list);
        model.addAttribute("orderBy", CustomersRepository.orderBy);
        model.addAttribute("searchBy", CustomersRepository.searchBy);
        return "exam/list7";
    }

}
