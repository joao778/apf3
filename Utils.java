package jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

    public static void finalizeQuery (Connection con, PreparedStatement pst) {
        try {
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Método sobrecarregado
    public static void finalizeQuery (Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
