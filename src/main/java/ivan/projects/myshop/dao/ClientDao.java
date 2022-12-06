package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao extends BaseDao<Long, Client> {

    List<Client> findAll() throws SQLException;

    void createEntity(Client client) throws SQLException;

    void deleteEntityById(Long id) throws SQLException;

    void update(Client client) throws SQLException;

    Client findEntityById(Long id) throws SQLException;

}
