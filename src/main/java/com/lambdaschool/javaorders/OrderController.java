package com.lambdaschool.javaorders;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Orders;
import com.lambdaschool.javaorders.repository.AgentsRepository;
import com.lambdaschool.javaorders.repository.CustomerRepository;
import com.lambdaschool.javaorders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    AgentsRepository agentRepo;

    @Autowired
    CustomerRepository custRepo;

    @Autowired
    OrdersRepository orderRepo;

    @GetMapping("/customer/order")
    public List<Object[]> allCustomersWithOrders() {
        return orderRepo.customersWithOrders();
    }

    @GetMapping("/customer/name/{custname}")
    public List<Orders> getOrdersByCustName(@PathVariable String custname) {
        return orderRepo.findByCustomer_CustnameIgnoreCase(custname);
    }

    @GetMapping("/customer/order/{custcode}")
    public List<Orders> getOrdersByCustCode(@PathVariable long custcode) {
        return orderRepo.findByCustomer_Custcode(custcode);
    }

    @GetMapping("/agents")
    public List<Object[]> allAgents() {
        return agentRepo.agentsWithCustomers();
    }

    @GetMapping("/agents/orders")
    public List<Object[]> ordersWithAgents() {
        return orderRepo.ordersWithAgents();
    }

    @DeleteMapping("/customer/{custcode}")
    public void deleteCustomer(@PathVariable long custcode) {
        custRepo.deleteById(custcode);
    }

/*    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return custRepo.findAll();
    }

    @GetMapping("orders")
    public List<Orders> allOrders() {
       return orderRepo.findAll();
    }*/
}
