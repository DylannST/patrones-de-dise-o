package interfaces;

import entity.employee.Empleado;

import java.sql.Connection;

public interface Database {
    Connection getConnection();

    Empleado registrar(Connection con, Empleado empleado);

    void createTable(Connection con);
}
