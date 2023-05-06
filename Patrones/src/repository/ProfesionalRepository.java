package repository;

import Interface.Database;
import Interface.Profesion;
import database.DatabaseFactory;
import entity.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
