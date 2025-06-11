package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.EditDao;
import model.ReportCard;

/**
 * Servlet implementation class EditResult
 */
@WebServlet("/editresult")
public class EditResult extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // サーブレットでフォームの値を取得
        int id = Integer.parseInt(request.getParameter("id"));
        int classNumber = Integer.parseInt(request.getParameter("class_number"));
        String name = request.getParameter("name");
        int englishScore = Integer.parseInt(request.getParameter("english_score"));
        int mathScore = Integer.parseInt(request.getParameter("math_score"));

        // ReportCardにセット
        ReportCard reportCard = new ReportCard();
        reportCard.setId(id);
        reportCard.setClassNumber(classNumber);
        reportCard.setName(name);
        reportCard.setEnglishScore(englishScore);
        reportCard.setMathScore(mathScore);

        // データベースを更新
        EditDao editDao = new EditDao();
        try {
            boolean success = editDao.editStudent(reportCard);
            request.setAttribute("success", success);
        } catch (SQLException e) {
            request.setAttribute("error", "データベースエラーが発生しました");
            e.printStackTrace();
        }
        request.setAttribute("reportCard", reportCard);
        request.getRequestDispatcher("/WEB-INF/view/edit_result.jsp").forward(request, response);

    }

}
