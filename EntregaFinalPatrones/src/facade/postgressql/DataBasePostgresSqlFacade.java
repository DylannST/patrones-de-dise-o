package facade.postgressql;

import model.Empleado;

public class DataBasePostgresSqlFacade {

    public Empleado registrarEmpleado(Empleado empleado){
        DataBasePostgresSql dataBasePostgresSql = new DataBasePostgresSql();
        dataBasePostgresSql.connect("containers-us-west-103.railway.app","8066","VK75DG9CqKhXMAkjgIjo");
        Empleado empleadoResponse = dataBasePostgresSql.registrar(empleado);
        dataBasePostgresSql.disconnect();
        return empleadoResponse;
    }

}
