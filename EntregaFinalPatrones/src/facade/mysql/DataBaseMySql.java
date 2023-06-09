package facade.mysql;

import model.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseMySql {
    private Connection connection;
    private PreparedStatement ps;
    public void connect(String host, String port, String pass){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/railway", "root", pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void disconnect(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private void createTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE  IF NOT EXISTS empleado(\n" +
                    "                        id varchar(255),\n" +
                    "                        nombre varchar(255),\n" +
                    "                        area varchar(255),\n" +
                    "                        typeFunction varchar(255),PRIMARY KEY(id))");
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Empleado registrar(Empleado empleado) {
        createTable();
        try {
            ps = connection.prepareStatement("INSERT INTO empleado (id, nombre, area, typeFunction)\n" +
                    "VALUES (?, ?, ?, ?)");
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
