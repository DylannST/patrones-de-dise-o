package entity.database;

import interfaces.Database;
import entity.employee.Empleado;

import java.sql.*;

public class MySql implements Database {
    PreparedStatement ps;

    @Override
    public Connection getConnection() {
        try {
            String hostname = "containers-us-west-206.railway.app";
            String port = "7418";
            String pass = "mCn3K9a32VRrcDSaOB65";
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
            ps.setString(3, empleado.funciones());
            ps.execute();
            System.out.println("Query ejecutado exitosamente");
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
