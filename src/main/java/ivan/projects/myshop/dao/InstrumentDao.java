package ivan.projects.myshop.dao;

import ivan.projects.myshop.entity.Instrument;

import java.sql.SQLException;
import java.util.List;

public interface InstrumentDao extends BaseDao<Long, Instrument> {
    List<Instrument> findAll() throws SQLException;

    void createEntity(Instrument instrument) throws SQLException;

    void deleteEntityById(Long id) throws SQLException;

    void update(Instrument instrument) throws SQLException;

    Instrument findEntityById(Long id) throws SQLException;

}
