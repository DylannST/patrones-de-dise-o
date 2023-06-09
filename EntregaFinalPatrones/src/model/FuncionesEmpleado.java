package model;

public enum FuncionesEmpleado {

    SERVICIO("{Lavar platos,\n Barrer,\n Lavar Baños}"),
    CAFETERIA("{Venta de almuerzos,\n Venta refrigerios,\n Venta de café}"),
    LAVANDERIA("Lavar ropa,\n Secar ropa");

    private String value;
    FuncionesEmpleado(String value) {
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }
}
