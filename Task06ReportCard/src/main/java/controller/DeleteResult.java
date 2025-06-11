package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.DeleteDao;
import model.ReportCard;

/**
 * Servlet implementation class DeleteResult
 */
@WebServlet("/deleteresult")
public class DeleteResult extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        ReportCard reportCard = (ReportCard) session.getAttribute("reportCard");

        if (reportCard == null) {
            request.setAttribute("error", "時間が経過したため、最初からやり直してください。");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        Boolean success = false;

        if ("削除する".equals(action)) {
            DeleteDao deleteDao = new DeleteDao();
            try {
                success = deleteDao.deleteStudent(reportCard);
            } catch (SQLException e) {
                request.setAttribute("error", "データベースエラーが発生しました");
                e.printStackTrace();
            }
            request.setAttribute("success", success);
            request.getRequestDispatcher("/WEB-INF/view/delete_result.jsp").forward(request, response);

        } else if ("キャンセル".equals(action)) {
            request.getRequestDispatcher("/WEB-INF/view/delete_cancel.jsp").forward(request, response);

        } else {
            request.setAttribute("error", "不正な操作が行われました。");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }
}
