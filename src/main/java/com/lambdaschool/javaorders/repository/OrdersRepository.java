package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomer_CustnameIgnoreCase(String name);

    List<Orders> findByCustomer_Custcode(long custcode);

    @Query(value = "SELECT c.custname as Name , o.ordnum as Number, o.ordamount, o.advanceamount, o.agentcode, o.orddescription as Description FROM customer c, orders o WHERE c.custcode=o.custcode ORDER BY c.custname", nativeQuery = true)
    List<Object[]> customersWithOrders();

    @Query(value = "SELECT a.agentname, o.ordnum, o.orddescription FROM agents a, orders o WHERE a.agentcode=o.agentcode ORDER BY a.agentname", nativeQuery = true)
    List<Object[]> ordersWithAgents();
}
