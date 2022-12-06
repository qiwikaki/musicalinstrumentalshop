package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.InstrumentType;
import ivan.projects.myshop.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDaoImpl implements InstrumentDao{

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public List<Instrument> findAll() {

        List<Instrument> entity = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM public.instrument_data";
            ResultSet rst = stmt.executeQuery(query);

            while (rst.next()) {
                Instrument instrument = new Instrument();

                instrument.setId(rst.getInt("id"));
                instrument.setInstrumentType(InstrumentType.valueOf(rst.getString("type")));
                instrument.setBrand(rst.getString("brand"));
                instrument.setModel(rst.getString("model"));
                instrument.setPrice(rst.getInt("price"));

                entity.add(instrument);
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println("instrument_data not found in database");
            throw new RuntimeException(e);
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("Can't close!");
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void createEntity(Instrument instrument) throws SQLException {

    }

    @Override
    public void deleteEntityById(Long id) throws SQLException {

    }

    @Override
    public void update(Instrument instrument) throws SQLException {

    }

    @Override
    public Instrument findEntityById(Long id) throws SQLException {
        return null;
    }

    public static void main(String[] args) {

        InstrumentDaoImpl instrumentDaoImpl = new InstrumentDaoImpl();

        System.out.println(instrumentDaoImpl.findAll());

//        Instrument yamahaGuitar = new Instrument(4, InstrumentType.GUITAR, "Yamaha", "F310" ,13990);
//        System.out.println(yamahaGuitar.getInstrumentType().getInstrumentTypeString());

    }

}
