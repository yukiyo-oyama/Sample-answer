package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindStudentDao {
    
    public ReportCard findStudentById(int id) throws SQLException {
        String sql = "SELECT * FROM reportcard WHERE member_id = ?";
        ReportCard reportCard = null;
        try (Connection connection = ConnectionManager.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reportCard = new ReportCard();
                reportCard.setId(resultSet.getInt("member_id"));
                reportCard.setClassNumber(resultSet.getInt("class_number"));
                reportCard.setName(resultSet.getString("member_name"));
                reportCard.setEnglishScore(resultSet.getInt("english_score"));
                reportCard.setMathScore(resultSet.getInt("math_score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return reportCard;
    }

}
