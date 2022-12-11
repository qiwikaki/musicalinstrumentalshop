package ivan.projects.myshop.entity;

import ivan.projects.myshop.dao.ClientDaoImpl;
import ivan.projects.myshop.dao.InstrumentDaoImpl;
import ivan.projects.myshop.entity.enums.OrderStatusType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {

    private int id;
    private LocalDateTime localDateTime;


    private int idClient;
    private int idInstrument;
    private OrderStatusType orderStatusType;

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(int idInstrument) {
        this.idInstrument = idInstrument;
    }

    public OrderStatusType getOrderStatusType() {
        return orderStatusType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", idClient=" + idClient +
                ", idInstrument=" + idInstrument +
                ", orderStatusType=" + orderStatusType +
                '}' + "\r\n";
    }

    public void setOrderStatusType(OrderStatusType orderStatusType) {
        this.orderStatusType = orderStatusType;
    }

    public Order(int id, LocalDateTime localDateTime, int idClient, int idInstrument, OrderStatusType orderStatusType) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.idClient = idClient;
        this.idInstrument = idInstrument;
        this.orderStatusType = orderStatusType;
    }

    public static void main(String[] args) {

        ClientDaoImpl clientDao = new ClientDaoImpl();
        InstrumentDaoImpl instrumentDaoImpl = new InstrumentDaoImpl();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

//        Order order = new Order(1, , clientDao.findEntityById(8L).getId(),
//                instrumentDaoImpl.findEntityById(4L).getId() ,OrderStatusType.isProcessing);
//        System.out.println(order);

    }

}
