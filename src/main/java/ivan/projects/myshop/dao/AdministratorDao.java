package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Administrator;
import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDao implements DaoAdministrator{

    private static int AUKey;
    static Connection con = DatabaseConnection.getConnection();

    @Override
    public List<Administrator> getAllAdmins() {

        List<Administrator> people = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM public.admin_data";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Administrator administrator = new Administrator();

                administrator.setId(rs.getInt("id"));
                administrator.setFirstName(rs.getString("firstName"));
                administrator.setLastName(rs.getString("lastName"));
                administrator.setLogin(rs.getString("login"));
                administrator.setPassword(rs.getString("password"));

                people.add(administrator);
            }
        } catch (SQLException e) {
            System.err.println("admin_data not found in database");
            throw new RuntimeException(e);
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("Can't close!");
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public void addAdmin(Administrator administrator) {
        String query = "INSERT INTO public.admin_data (\"firstName\", \"lastName\", login," +
                " password)" +
                " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, administrator.getFirstName());
            ps.setString(2, administrator.getLastName());
            ps.setString(3, administrator.getLogin());
            ps.setString(4, administrator.getPassword());

            ps.executeUpdate();
            System.out.println("Create admin access" + con.createStatement().getGeneratedKeys());

        } catch (SQLException e) {
            System.err.println("Not create");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        AdministratorDao administratorDao = new AdministratorDao();

//        administratorDao.addAdmin(new Administrator(1,"leo",
//                "messi","arg@","barca"));
        ClientDao clientDao = new ClientDao();
        System.out.println(administratorDao.getAllAdmins());

    }

}
