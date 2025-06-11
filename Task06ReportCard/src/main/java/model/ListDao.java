package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListDao {

    public ArrayList<ReportCard> selectAll() throws SQLException {
        ArrayList<ReportCard> list = new ArrayList<>();
        String sql = "SELECT * FROM reportcard";
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                ReportCard reportCard = new ReportCard();
                reportCard.setId(resultSet.getInt("member_id"));
                reportCard.setClassNumber(resultSet.getInt("class_number"));
                reportCard.setName(resultSet.getString("member_name"));
                reportCard.setEnglishScore(resultSet.getInt("english_score"));
                reportCard.setMathScore(resultSet.getInt("math_score"));
                list.add(reportCard);
            }
        }catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }
 
}
