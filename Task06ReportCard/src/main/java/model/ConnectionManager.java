package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    
    public static Connection createConnection() throws SQLException{
        return DriverManager
                .getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;database=ReportCard;"
                        + "encrypt=true;trustServerCertificate=true;"
                        + "integratedSecurity=false;user=sa;password=sa");
    }
    
}
