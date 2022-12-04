package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  ClientDao implements DaoClient {

    private static int AUKey;
    static Connection con = DatabaseConnection.getConnection();

    @Override
    public List<Client> getAllClients() {

        List<Client> people = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM public.client_data";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Client client = new Client();

                client.setId(rs.getInt("id"));
                client.setFirstName(rs.getString("firstName"));
                client.setLastName(rs.getString("lastName"));
                client.setEmail(rs.getString("email"));
                client.setPassword(rs.getString("password"));
                client.setPhone(rs.getString("phone"));
                client.setAddress(rs.getString("address"));
                client.setAge(rs.getInt("age"));

                people.add(client);
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
    public void addClient(Client client) {

        String query = "INSERT INTO public.client_data (\"firstName\", \"lastName\", email, password, phone, address, age)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getPassword());
            ps.setString(5, client.getPhone());
            ps.setString(6, client.getAddress());
            ps.setInt(7, client.getAge());

            ps.executeUpdate();
            System.out.println("Create access client");

        } catch (SQLException e) {
            System.err.println("Not create");
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteClient(int id) {

        String query = "DELETE FROM public.client_data WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Client finderById(int id) {

        Client client = null;

        try {
            PreparedStatement preparedStatement =
                    con.prepareStatement("SELECT * FROM public.client_data where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            client = new Client();
            client.setId(rs.getInt("id"));
            client.setFirstName(rs.getString("firstName"));
            client.setLastName(rs.getString("lastName"));
            client.setEmail(rs.getString("email"));
            client.setPassword(rs.getString("password"));
            client.setPhone(rs.getString("phone"));
            client.setAddress(rs.getString("address"));
            client.setAge(rs.getInt("age"));

        } catch (SQLException e) {
            System.err.println(id +" not create");
            throw new RuntimeException(e);
        }
        return client;
    }

    @Override
    public void updateClient(Client client) {
        String query = "UPDATE public.client_data SET phone = ?, address = ? where id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,client.getPhone());
            ps.setString(2,client.getAddress());
            ps.setInt(3,client.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        ClientDao clientDao = new ClientDao();

//        CREATE
//        clientDao.addClient(new Client(AUKey, "Sezha",
//                "Polovtsev","daun@","1234",
//                "88005553535","bugri", 42));

        //DELETE
//            clientDao.deleteClient(9);

        //UPDATE
//        Client clientTest = clientDao.finderById(6);
//        clientTest.setAddress("murmansk");
//        clientDao.updateClient(clientTest);
//        System.out.println(clientTest);

        //READ
//        System.out.println(clientDao.getAllClients());
    }

}
