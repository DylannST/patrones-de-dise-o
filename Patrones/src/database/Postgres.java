package database;

import Interface.Database;
import Interface.Profesion;
import entity.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class Postgres implements Database {
    PreparedStatement ps;

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://containers-us-west-20.railway.app:5777/railway", "postgres", "nUDw1y209U5QQDAs9t2i");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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
            ps.setString(3, empleado.getFunciones());
            if (ps.executeUpdate() > 0) {
                System.out.printf("Exitoso");
            }
            return empleado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}