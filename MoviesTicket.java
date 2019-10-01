//  MoviesTickect.java:  Query an mSQL database using JDBC.

import java.sql.*;

/**
 * A JDBC SELECT (JDBC query) example program.
 */
class MoviesTickect {

    public static void main (String[] args) {
        try {
            String url = "jdbc:msql://200.210.220.1:1114/Demo";
            Connection conn = DriverManager.getConnection(url,"","");
            Statement stmt = conn.createStatement();
            ResultSet rs;
            int snum = 2001;
            rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = "+snum);

            while ( rs.next() ) {
                String lastName = rs.getString("Lname");
                System.out.println(lastName);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
