package finki.emt.ordermanagement.services.impl;

import finki.emt.ordermanagement.domain.models.BookInOrderId;
import finki.emt.ordermanagement.domain.models.Order;
import finki.emt.ordermanagement.domain.models.OrderId;
import finki.emt.ordermanagement.domain.repository.OrderRepository;
import finki.emt.ordermanagement.forms.BookInOrderForm;
import finki.emt.ordermanagement.forms.OrderForm;
import finki.emt.ordermanagement.services.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final Validator validator;


    @Override
    public OrderId createOrder(OrderForm orderForm) {
       var formViolations = validator.validate(orderForm);
       if (formViolations.size() > 0)
           throw new ConstraintViolationException("Order from not valid", formViolations);

       Order newOrder = orderRepository.save(createObject(orderForm));
       return newOrder.getId();
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId orderId) throws Exception {
        return orderRepository.findById(orderId);
    }

    @Override
    public void addBook(OrderId orderId, BookInOrderForm bookInOrderForm) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(Exception::new);
        order.addBookToOder(bookInOrderForm.getBook(), bookInOrderForm.getQuantity());
        orderRepository.save(order);
    }

    @Override
    public void deleteItem(OrderId orderId, BookInOrderId bookInOrderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(Exception::new);
        order.removeBookInOrder(bookInOrderId);
        orderRepository.saveAndFlush(order);
    }

    private Order createObject(OrderForm orderForm){
        Order order = new Order(Instant.now(),orderForm.getCurrency());
        orderForm.getItems().forEach(item -> order.addBookToOder(item.getBook(), item.getQuantity()));
        return order;
    }
}
