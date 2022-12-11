package ivan.projects.myshop.service;

import ivan.projects.myshop.dao.ClientDaoImpl;
import ivan.projects.myshop.dao.InstrumentDaoImpl;
import ivan.projects.myshop.dao.OrderDaoImpl;
import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.Order;

import java.time.LocalDateTime;

public class OrderService {

    private OrderDaoImpl orderDaoimpl;
    private ClientDaoImpl clientDaoimpl;
    private InstrumentDaoImpl instrumentDaoIpl;

    public void createOrder() {

    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.createOrder();
    }

}
