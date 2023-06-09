package facade.postgressql;

import model.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBasePostgresSql {
    private Connection connection;
    private PreparedStatement ps;

    public void connect(String host, String port, String pass) {
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/railway", "postgres", pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void disconnect(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void createTable(Connection con) {
        try {
            ps = con.prepareStatement("create table IF NOT EXISTS empleado (\n" +
                    "   id VARCHAR (50) primary key,\n" +
                    "   nombre VARCHAR (50) not null,\n" +
                    "   area VARCHAR (50) not null,\n" +
                    "   typeFunction VARCHAR (500) not null\n" +
                    ")");
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Empleado registrar(Empleado empleado) {
        createTable(connection);
        try {
            ps = connection.prepareStatement("INSERT INTO empleado(id, nombre, area, typefunction) VALUES (?, ?, ?, ?)");
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getArea());
            ps.setString(4, empleado.getFunciones());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empleado;
    }
}
