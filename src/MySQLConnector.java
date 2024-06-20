import javax.xml.transform.Result;
import java.sql.*;

public class MySQLConnector {
    String url = "jdbc:mysql://localhost:3306/TEST";
    String username = "root";
    String password = "CBl9#mysql";
    Connection con;
    public MySQLConnector() {
        try {
            con = DriverManager.getConnection( url, username, password );
            Statement stm = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String query = "SELECT * FROM Product;";
            ResultSet rs = stm.executeQuery( query );
            rs.moveToInsertRow();

            while( rs.next()) {
                System.out.println("Id" + rs.getInt("id"));
                System.out.println("Name" + rs.getString("name"));
                System.out.println("Price per unit" + rs.getFloat("price_per_unit"));
                System.out.println("Active for sell" + rs.getInt("active_for_sell"));
            }

        } catch ( Exception err ) {
            System.out.println( err.getMessage());
        }
    }
}
