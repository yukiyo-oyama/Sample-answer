package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.FindStudentDao;
import model.ReportCard;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/delete.jsp");
        dispatcher.forward(request, response);
        
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //フォームデータの取得
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            // idが送信されていない場合の処理
            request.setAttribute("error", "IDが指定されていません");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            return; // 処理を中断
        }
        
        int id = 0;
        try {
            id = Integer.parseInt(idStr); // idStrが数字でない場合にNumberFormatExceptionが発生
        } catch (NumberFormatException e) {
            // idが数字ではない場合の処理
            request.setAttribute("error", "IDが無効です");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            return; // 処理を中断
        }
        FindStudentDao find = new FindStudentDao();
        ReportCard reportCard = null;

        try {
            reportCard = find.findStudentById(id);
            if (reportCard != null) {
                HttpSession session = request.getSession(false);
                session.setAttribute("reportCard", reportCard);
                request.getRequestDispatcher("/WEB-INF/view/delete_confirm.jsp").forward(request, response);
                return; // 処理をここで終了
            } else {
                request.setAttribute("error", "指定されたIDの学生が見つかりませんでした");
            }
        } catch (SQLException e) {
            request.setAttribute("error", "データベースエラーが発生しました");
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        
    }
}
