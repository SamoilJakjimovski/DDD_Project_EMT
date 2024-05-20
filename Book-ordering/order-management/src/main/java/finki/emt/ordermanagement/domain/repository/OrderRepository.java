package finki.emt.ordermanagement.domain.repository;

import finki.emt.ordermanagement.domain.models.Order;
import finki.emt.ordermanagement.domain.models.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
