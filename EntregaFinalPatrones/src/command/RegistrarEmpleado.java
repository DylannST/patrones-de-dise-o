package command;

import facade.postgressql.DataBasePostgresSqlFacade;
import model.Empleado;

public class RegistrarEmpleado implements Command{
    Empleado empleado;

    public RegistrarEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public Empleado execute() {
        DataBasePostgresSqlFacade dataBasePostgres = new DataBasePostgresSqlFacade();
        Empleado empleadoResponse = dataBasePostgres.registrarEmpleado(empleado);
        return empleadoResponse;
    }
}
