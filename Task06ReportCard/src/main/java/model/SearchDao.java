package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchDao {
    
    public ArrayList<ReportCard> searchStudent(String name) throws SQLException{
        ArrayList<ReportCard> found = new ArrayList<>();
        String sql = "SELECT * FROM reportcard WHERE member_name LIKE ?";
        try(Connection connection = ConnectionManager.createConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ReportCard reportCard = new ReportCard();
                reportCard.setId(rs.getInt("member_id"));
                reportCard.setClassNumber(rs.getInt("class_number"));
                reportCard.setName(rs.getString("member_name"));
                reportCard.setEnglishScore(rs.getInt("english_score"));
                reportCard.setMathScore(rs.getInt("math_score"));
                found.add(reportCard);
            }
        }catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return found;
    }

}
