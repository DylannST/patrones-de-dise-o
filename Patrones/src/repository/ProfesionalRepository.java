package repository;

import interfaces.Database;
import factory.database.DatabaseFactory;
import entity.employee.Empleado;

import java.sql.Connection;

public class ProfesionalRepository {


    private String typeDb;
    private Database db;
    Connection con;

    public ProfesionalRepository(String typeDb) {
        this.typeDb = typeDb;
        this.db = DatabaseFactory.getDatabase(typeDb);
        con = db.getConnection();
    }

    public Empleado createProfesional(Empleado empleado) {
        return db.registrar(con, empleado);
    }

}
