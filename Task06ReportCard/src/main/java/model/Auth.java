package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Auth {

    public boolean isAuth(String id,String pw) {
        if(id == null || pw == null) return false;
        
        boolean isAuth = false;
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection =
            DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;database=TestDB;"
            + "encrypt=true;trustServerCertificate=true;"
            + "integratedSecurity=false;user=sa;password=sa");
            
            String sql = "SELECT * FROM members WHERE member_name = ? AND member_pw = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, pw);
            
            ResultSet resultSet = statement.executeQuery();
            
            isAuth = resultSet.next();
            
            connection.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return isAuth;
    }
}