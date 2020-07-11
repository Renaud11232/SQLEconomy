package be.renaud11232.plugins.sqleconomy.database.connector;

import be.renaud11232.plugins.sqleconomy.database.exceptions.DatabaseException;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public enum DatabaseType implements DatabaseConnector {

    MYSQL(new MySQLConnector()),
    SQLITE(new SQLiteConnector());

    private final DatabaseConnector connector;

    DatabaseType(DatabaseConnector connector) {
        this.connector = connector;
    }

    @Override
    public Connection getConnection(FileConfiguration configuration) throws DatabaseException {
        Connection connection = connector.getConnection(configuration);
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DatabaseException("Unable to disable auto-commit", e);
        }
        return connection;
    }

}
