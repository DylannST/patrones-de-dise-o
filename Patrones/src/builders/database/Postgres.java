package builders.database;

import interfaces.Database;
import entity.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Postgres implements Database {
    PreparedStatement ps;

    @Override
    public Connection getConnection() {
        try {
            String hostname = "containers-us-west-50.railway.app";
            String port = "6984";
            String pass = "xUfNCBjqHd1sdtUvJ3VZ";
            return DriverManager.getConnection("jdbc:postgresql://"+hostname+":"+port+"/railway", "postgres", pass);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTable(Connection con) {
        try {
            ps = con.prepareStatement("create table IF NOT EXISTS empleado (\n" +
                    "   id VARCHAR (50) primary key,\n" +
                    "   nombre VARCHAR (50) not null,\n" +
                    "   typeFunction VARCHAR (500) not null\n" +
                    ")");
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empleado registrar(Connection con, Empleado empleado) {
        createTable(con);
        try {
            ps = con.prepareStatement("INSERT INTO empleado(id, nombre, typefunction) VALUES (?, ?, ?)");
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.funciones());
            ps.execute();
            System.out.println("Query ejecutado exitosamente");
            return empleado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
