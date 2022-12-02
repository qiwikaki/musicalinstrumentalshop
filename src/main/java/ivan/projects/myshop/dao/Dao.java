package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface Dao {

    //clientDao
    List<Client> getAllClients() throws SQLException;

     void addClient(Client client) throws SQLException;

     void deleteClient(int id) throws SQLException;

     void updateClient(Client client) throws SQLException;

    Client finderById(int id) throws SQLException;

}
