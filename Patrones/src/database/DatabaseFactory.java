package database;

import Interface.Database;

public class DatabaseFactory {
    public static Database getDatabase(String type) {
        return switch (type) {
            case "postgres" -> new Postgres();
            case "mysql" -> new MySql();
            default -> throw new IllegalArgumentException("Tipo de base de datos no válido: " + type);
        };
    }
}
