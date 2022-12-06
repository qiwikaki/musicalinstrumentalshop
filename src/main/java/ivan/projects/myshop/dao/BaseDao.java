package ivan.projects.myshop.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<K, T> {

    List<T> findAll() throws SQLException;

     void createEntity(T t) throws SQLException;

     void deleteEntityById(K id) throws SQLException;

     void update(T t) throws SQLException;

    T findEntityById(K id) throws SQLException;

}
