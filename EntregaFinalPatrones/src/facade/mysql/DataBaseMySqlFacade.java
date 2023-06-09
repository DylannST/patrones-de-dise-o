package facade.mysql;

import model.Empleado;

public class DataBaseMySqlFacade {

    public Empleado registrarEmpleado(Empleado empleado){
        DataBaseMySql dataBaseMySql = new DataBaseMySql();
        dataBaseMySql.connect("containers-us-west-55.railway.app","7911","6eTti8Slh1HapslIIcFO");
        Empleado empleadoResponse = dataBaseMySql.registrar(empleado);
        dataBaseMySql.disconnect();
        return empleadoResponse;
    }

}
