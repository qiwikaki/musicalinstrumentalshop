package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    List<Order> findAll() throws SQLException;

    void createEntity(Order order) throws SQLException;

    void deleteEntityById(Long id) throws SQLException;

    void update(Order order) throws SQLException;

    Order findEntityById(Long id) throws SQLException;

}
