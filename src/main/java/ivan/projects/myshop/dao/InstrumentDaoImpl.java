package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Instrument;
import ivan.projects.myshop.entity.enums.InstrumentType;
import ivan.projects.myshop.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDaoImpl implements InstrumentDao {

   private static final Connection con = DatabaseConnection.getConnection();
    private static int AUKey;

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
    public void createEntity(Instrument instrument) {

        String query = "INSERT INTO public.instrument_data (type, brand, model, price)" +
                " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, String.valueOf(instrument.getInstrumentType()));
            ps.setString(2, instrument.getBrand());
            ps.setString(3, instrument.getModel());
            ps.setInt(4, instrument.getPrice());

            ps.executeUpdate();

            //get id on create
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int key = resultSet.getInt("id");
                System.out.println("Creating new instrument:" + ", its id:" + key);
            }

        } catch (SQLException e) {
            System.err.println("Not create instrument");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntityById(Long id) {

        String query = "DELETE FROM public.instrument_data where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Instrument instrument) {

        String query = "UPDATE public.instrument_data SET price = ? where id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, instrument.getPrice());
            ps.setInt(2, instrument.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Instrument findEntityById(Long id) {

        Instrument instrument = null;

        try {
            PreparedStatement preparedStatement =
                    con.prepareStatement("SELECT * FROM public.instrument_data where id = ?");
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            instrument = new Instrument();
            instrument.setId(rs.getInt("id"));
            instrument.setInstrumentType(InstrumentType.valueOf(rs.getString("type")));
            instrument.setBrand(rs.getString("brand"));
            instrument.setModel(rs.getString("model"));
            instrument.setPrice(rs.getInt("price"));

        } catch (SQLException e) {
            System.err.println(id +" not create");
            throw new RuntimeException(e);
        }
        return instrument;
    }

    public static void main(String[] args) {

        InstrumentDaoImpl instrumentDaoImpl = new InstrumentDaoImpl();



//        Instrument yamahaGuitar = new Instrument(4, InstrumentType.GUITAR, "Yamaha", "F310" ,13990);

//        System.out.println(yamahaGuitar.getInstrumentType().getInstrumentTypeString());

//        CREATE
//        instrumentDaoImpl.createEntity(new Instrument(AUKey, InstrumentType.DRUM,
//                "Brahner", "MD-120/MRD" ,32874));

//        DELETE
//        instrumentDaoImpl.deleteEntityById(5L);

//        READ
        System.out.println(instrumentDaoImpl.findAll());

//        UPDATE
//        Instrument ins = instrumentDaoImpl.findEntityById(5L);
//        ins.setPrice(39_995);
//        instrumentDaoImpl.update(ins);

    }

}
