package net.skhu.repository;

import net.skhu.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    public List<OrderDetails> findByOrdersId(int id);
}
