package net.threader.lib.sql.acessor;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class MySQLDBAcessor extends DatabaseAcessor {

    public MySQLDBAcessor(String url) {
        super(url);
    }

    @Override
    public void connect() {
        try {
            plugin.getLogger().log(Level.INFO, "Connecting to the database...");
            connection = DriverManager.getConnection(url);
            plugin.getLogger().log(Level.INFO, "Connection established successfully!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            plugin.getLogger().log(Level.SEVERE, "Error while establishing database connection: ");
            plugin.getPluginLoader().disablePlugin(plugin);
        }
    }
}
