import java.sql.*;

public class databaseManager {

    static final String DB_URL = "jdbc:oracle:thin:@log660ora12c.logti.etsmtl.ca:1521:LOG660";
    static final String USER = "EQUIPE105";
    static final String PASS = "jZA9kMJb";
    static final String QUERY = "SELECT * FROM v$version";

    public static void main(String[] args) {
        // Open a connection
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(QUERY);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (Exception e) { }
            }
        }
    }
}
