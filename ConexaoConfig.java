package jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoConfig {

    private static final String DB_URL = "jdbc:sqlite:C:\Users\55859\Downloads\trabalho final\mercado.db";

    public static Connection criarConexao () {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
