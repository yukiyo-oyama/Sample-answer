package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDao {

    public boolean editStudent(ReportCard reportCard) throws SQLException {
        String sql = "UPDATE reportcard SET class_number = ?, member_name = ?, english_score = ?, math_score = ? WHERE member_id = ?";

        try (Connection connection = ConnectionManager.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, reportCard.getClassNumber());
            statement.setString(2, reportCard.getName());
            statement.setInt(3, reportCard.getEnglishScore());
            statement.setInt(4, reportCard.getMathScore());
            statement.setInt(5, reportCard.getId());
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
