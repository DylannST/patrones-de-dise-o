package database;

import Interface.Database;
import Interface.Profesion;
import entity.Empleado;

import java.sql.*;
import java.util.Arrays;

public class MySql implements Database {
    PreparedStatement ps;

    @Override
    public Connection getConnection() {
        try {
            String hostname = "containers-us-west-130.railway.app";
            String port = "7191";
            String pass = "wxILYojoKoWG8w4aSApK";
            return DriverManager.getConnection("jdbc:mysql://"+ hostname+":"+port+"/railway", "root", pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empleado registrar(Connection con, Empleado empleado) {
        createTable(con);
        try {
            ps = con.prepareStatement("INSERT INTO empleado (id, nombre, typeFunction)\n" +
                    "VALUES (?, ?, ?)");
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getFunciones());
            if (ps.executeUpdate() > 0) {
                System.out.print("Exitoso");
            }
            return empleado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTable(Connection con) {
        try {
            ps = con.prepareStatement("CREATE TABLE  IF NOT EXISTS empleado(\n" +
                    "                        id varchar(255),\n" +
                    "                        nombre varchar(255),\n" +
                    "                        typeFunction varchar(255),PRIMARY KEY(id))");
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
