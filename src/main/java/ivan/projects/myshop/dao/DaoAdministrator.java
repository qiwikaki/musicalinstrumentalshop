package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Administrator;
import ivan.projects.myshop.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface DaoAdministrator {

    List<Administrator> getAllAdmins() throws SQLException;

     void addAdmin(Administrator administrator);

}
