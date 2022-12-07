package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Client;
import ivan.projects.myshop.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientDaoImpl implements ClientDao {

    private static int AUKey;
    static Connection con = DatabaseConnection.getConnection();

    @Override
    public List<Client> findAll() {

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
            System.err.println("client_data not found in database");
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
    public void createEntity(Client client) {

        String query = "INSERT INTO public.client_data (\"firstName\", \"lastName\", email, password, phone, address, age)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getPassword());
            ps.setString(5, client.getPhone());
            ps.setString(6, client.getAddress());
            ps.setInt(7, client.getAge());
            ps.executeUpdate();

            //get id on create
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int key = resultSet.getInt("id");
                System.out.println("Creating new client:"+ client.getFirstName() + ", its id:"+key);
            }

        } catch (SQLException e) {
            System.err.println("Not create");
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteEntityById(Long id) {

        String query = "DELETE FROM public.client_data WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Client findEntityById(Long id) {

        Client client = null;

        try {
            PreparedStatement preparedStatement =
                    con.prepareStatement("SELECT * FROM public.client_data where id = ?");
            preparedStatement.setLong(1, id);

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
    public void update(Client client) {

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

        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();

//        CREATE
//        clientDaoImpl.createEntity(new Client(AUKey, "Wayne",
//                "Rooney","mu@","9",
//                "xxx","England", 47));

        //DELETE
//            clientDaoImpl.deleteEntityById(16L);

//        UPDATE
        Client clientTest = clientDaoImpl.findEntityById(1L);
//        clientTest.setAddress("Zapolyarniy");
//        clientDaoImpl.update(clientTest);
//        System.out.println(clientTest);

        //READ
        System.out.println(clientDaoImpl.findAll());

//        Client clientTest = clientDaoImpl.findEntityById(1L);
//        System.out.println(clientTest);
    }

}
