package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddDao {

    public ReportCard addStudentAndReturnWithId(ReportCard reportCard) throws SQLException {
        String sql = "INSERT INTO reportcard (class_number, member_name, english_score, math_score) VALUES (?,?,?,?)";
        int generatedId = 0;
        try (Connection connection = ConnectionManager.createConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reportCard.getClassNumber());
            statement.setString(2, reportCard.getName());
            statement.setInt(3, reportCard.getEnglishScore());
            statement.setInt(4, reportCard.getMathScore());
            int rows = statement.executeUpdate();
            if(rows != 0) {
                ResultSet result = statement.getGeneratedKeys();
                if(result.next()) {
                    generatedId = result.getInt(1);
                    reportCard.setId(generatedId);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return reportCard;
    }

}
