package entity;

import Interface.Profesion;

import java.util.Arrays;

public class Desarrollador extends Empleado implements Profesion {
    private String[] funciones = new String[]{"Desarrollo de software", "Soporte", "Manejo de Infraestructura AWS", "Manejo de Infraestructura de AzureDevops"};

    public Desarrollador(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public String funciones() {
        return Arrays.toString(funciones);
    }




    @Override
    public String datosEmpleado() {
        return "Desarrollador{\n    nombre = "+ nombre + "\n    cédula = " + cedula + "\n" +
                "    funciones = " + Arrays.toString(funciones) +"\n}";
    }

    @Override
    public String getFunciones() {
        return Arrays.toString(this.funciones);
    }
}
