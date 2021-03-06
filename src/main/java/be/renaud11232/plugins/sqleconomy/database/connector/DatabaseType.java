package be.renaud11232.plugins.sqleconomy.database.connector;

import be.renaud11232.plugins.sqleconomy.database.exceptions.DatabaseException;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;

public enum DatabaseType implements DatabaseConnector {

    MYSQL(new MySQLConnector()),
    SQLITE(new SQLiteConnector());

    private final DatabaseConnector connector;

    DatabaseType(DatabaseConnector connector) {
        this.connector = connector;
    }

    @Override
    public Connection getConnection(FileConfiguration configuration) throws DatabaseException {
        return connector.getConnection(configuration);
    }

}
