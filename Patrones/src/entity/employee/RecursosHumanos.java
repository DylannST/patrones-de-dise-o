package entity.employee;

import interfaces.Profesional;

import java.util.Arrays;

public class RecursosHumanos  extends Empleado implements Profesional {
    private static RecursosHumanos instanceRH = null;

    private String[] funciones = new String[]{"Reclutamiento", "\n        Administración de personal", "\n        " +
            "Evaluación de desempeño"};

    private RecursosHumanos(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(this.funciones);
    }


    @Override
    public String datosDelProfesional() {
        return "Recursos Humanos{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones=\n        " + Arrays.toString(this.funciones) +"\n}";
    }

    public static RecursosHumanos getInstance(String nombre, String cedula) {
        if (instanceRH == null) {
            instanceRH = new RecursosHumanos(nombre, cedula);
        }else{
            instanceRH.nombre = nombre;
            instanceRH.cedula = cedula;
        }
        return instanceRH;
    }
}