package finki.emt.ordermanagement.services;

import finki.emt.ordermanagement.domain.models.BookInOrderId;
import finki.emt.ordermanagement.domain.models.Order;
import finki.emt.ordermanagement.domain.models.OrderId;
import finki.emt.ordermanagement.forms.BookInOrderForm;
import finki.emt.ordermanagement.forms.OrderForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderId createOrder(OrderForm orderForm);

    List<Order> getAll();

    Optional<Order> findById(OrderId orderId) throws Exception;

    void addBook(OrderId orderId, BookInOrderForm bookInOrderForm) throws Exception;

    void deleteItem(OrderId orderId, BookInOrderId bookInOrderId) throws Exception;

}
