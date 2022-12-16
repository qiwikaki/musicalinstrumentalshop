package ivan.projects.myshop.service;

import ivan.projects.myshop.dao.*;
import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.Order;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderService {

//    private OrderDao orderDao;
//    private ClientDao clientDao;
//    private InstrumentDao instrumentDao;
    private static int AUKey;

    public void createOrder() {
        ClientDaoImpl clientDao = new ClientDaoImpl();
        InstrumentDaoImpl instrumentDao = new InstrumentDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();

        clientDao.createEntity(new Client());
        instrumentDao.createEntity(new Instrument());
        orderDao.createEntity(new Order(AUKey++, LocalDateTime.now(), ));

    }

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        orderService.createOrder();
    }

}
