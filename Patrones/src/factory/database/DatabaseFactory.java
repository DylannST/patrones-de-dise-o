package factory.database;

import entity.database.MySql;
import entity.database.Postgres;
import interfaces.Database;

public class DatabaseFactory {
    public static Database getDatabase(String type) {
        return switch (type) {
            case "PostgresSQL" -> new Postgres();
            case "MySQL" -> new MySql();
            default -> throw new IllegalArgumentException("Tipo de base de datos no válido: " + type);
        };
    }
}
