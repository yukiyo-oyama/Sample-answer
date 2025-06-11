package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
    
    public boolean deleteStudent(ReportCard reportCard) throws SQLException {
        String sql = "DELETE FROM reportcard WHERE member_id = ?";

        try (Connection connection = ConnectionManager.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, reportCard.getId());
            int rows = statement.executeUpdate();
            
            if (rows != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }

}
