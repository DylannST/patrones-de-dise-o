package entity;

import java.util.Arrays;

public class Empleado {
    protected String nombre;
    protected String cedula;

    String[] funciones;


    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }



    public String funciones() {
        return Arrays.toString(this.funciones);
    }
}
