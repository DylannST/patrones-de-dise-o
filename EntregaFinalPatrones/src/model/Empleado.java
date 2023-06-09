package model;

public class Empleado {
    public String nombre;
    public String cedula;
    public String area;
    public String funciones;

    public Empleado(String nombre, String cedula,String area, String funciones) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.funciones = funciones;
        this.area = area;
    }
    public Empleado(){

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

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre=" + nombre + ", \n" +
                "cedula=" + cedula + ", \n" +
                "area=" + area + ", \n" +
                "funciones=" + funciones + ", \n" +
                '}';
    }
}
