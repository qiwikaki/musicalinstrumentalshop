package ivan.projects.myshop.service;

import ivan.projects.myshop.dao.*;
import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.Order;
import ivan.projects.myshop.entity.enums.InstrumentType;
import ivan.projects.myshop.entity.enums.OrderStatusType;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    private static int AUCount;

    public OrderService( ) {

    }

    public void createOrder(Long client_id, Long instrument_id) {

        ClientDao clientDao = new ClientDaoImpl();
        InstrumentDaoImpl instrumentDao = new InstrumentDaoImpl();

        Order order = null;
        try {
            order = new Order(AUCount, LocalDateTime.now(), clientDao.findEntityById(client_id).getId(),
                    instrumentDao.findEntityById(instrument_id).getId(), OrderStatusType.isProcessing);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            orderDao.createEntity(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


        OrderService orderService = new OrderService();
        orderService.createOrder(18L, 4L);

//        OrderDaoImpl orderDao = new OrderDaoImpl();
//        Order orderT = new Order(AUCount, LocalDateTime.now(), 28,
//                23, OrderStatusType.isProcessing);
//        orderDao.createEntity(orderT);

    }

}
