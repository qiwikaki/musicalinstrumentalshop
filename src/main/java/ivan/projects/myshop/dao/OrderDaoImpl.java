package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.Order;
import ivan.projects.myshop.entity.enums.InstrumentType;
import ivan.projects.myshop.entity.enums.OrderStatusType;
import ivan.projects.myshop.util.DatabaseConnection;

import java.time.LocalDateTime;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    private static int AUKey;
    private static final Connection con = DatabaseConnection.getConnection();

    @Override
    public List<Order> findAll() {

        List<Order> entity = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM public.order_data";
            ResultSet rst = stmt.executeQuery(query);

            while (rst.next()) {
                Order order = new Order();

                order.setId(rst.getInt("id"));
                order.setLocalDateTime(rst.getObject("order_date", LocalDateTime.class));
                order.setIdClient(rst.getInt("client_id"));
                order.setIdInstrument(rst.getInt("instrument_id"));
                order.setOrderStatusType(OrderStatusType.valueOf(rst.getString("status")));

                entity.add(order);
            }
        } catch (SQLException e) {
            System.err.println("order_data not found in database");
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void createEntity(Order order) {

        String query = "INSERT INTO public.order_data (order_date, client_id, instrument_id, status)" +
                " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setObject(1, order.getLocalDateTime());
            ps.setInt(2, order.getIdClient());
            ps.setInt(3, order.getIdInstrument());
            ps.setString(4, String.valueOf(order.getOrderStatusType()));

            ps.executeUpdate();

            //get id on create
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int key = resultSet.getInt("id");
                System.out.println("Creating new Order:" + ", its id:" + key);
            }

        } catch (SQLException e) {
            System.err.println("Not create order");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEntityById(Long id) {
        String query = "DELETE FROM public.order_data WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order order) {
        String query = "UPDATE public.order_data SET instrument_id = ?, status = ? WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, order.getIdInstrument());
            ps.setString(2, String.valueOf(order.getOrderStatusType()));
            ps.setInt(3, order.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findEntityById(Long id){
        Order order = null;

        try {
            PreparedStatement preparedStatement =
                    con.prepareStatement("SELECT * FROM public.order_data where id = ?");
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            order = new Order();
            order.setId(rs.getInt("id"));
            order.setLocalDateTime(rs.getObject("order_date", LocalDateTime.class));
            order.setIdClient(rs.getInt("client_id"));
            order.setIdInstrument(rs.getInt("instrument_id"));
            order.setOrderStatusType(OrderStatusType.valueOf(rs.getString("status")));

        } catch (SQLException e) {
            System.err.println(id +" not create");
            throw new RuntimeException(e);
        }
        return order;
    }

    public static void main(String[] args) {

        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();


//        orderDaoImpl.createEntity(new Order(AUKey,  LocalDateTime.now(),
//                10, 6, OrderStatusType.isPayment));

//        orderDaoImpl.deleteEntityById(7L);

//        orderDaoImpl.findEntityById(8L);

        System.out.println(orderDaoImpl.findAll());

//        Order orderTest = orderDaoImpl.findEntityById(8L);
//        orderTest.setOrderStatusType(OrderStatusType.isDelivered);
//        orderDaoImpl.update(orderTest);

    }

}
