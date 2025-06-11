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

import model.AddDao;
import model.ReportCard;

/**
 * Servlet implementation class Add
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/add.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // フォームデータの取得
        String classNumberStr = request.getParameter("class_number");
        String name = request.getParameter("name");
        String englishScoreStr = request.getParameter("english_score");
        String mathScoreStr = request.getParameter("math_score");

        // 入力データの検証（必須項目チェック）
        if (classNumberStr == null || name == null || englishScoreStr == null || mathScoreStr == null ||
            classNumberStr.isEmpty() || name.isEmpty() || englishScoreStr.isEmpty() || mathScoreStr.isEmpty()) {
            request.setAttribute("error", "すべての項目を入力してください。");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        // 数値入力の検証
        int classNumber = 0;
        int englishScore = 0;
        int mathScore = 0;

        try {
            classNumber = Integer.parseInt(classNumberStr);
            englishScore = Integer.parseInt(englishScoreStr);
            mathScore = Integer.parseInt(mathScoreStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "数値の入力に誤りがあります。");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        // ReportCardオブジェクトの作成
        ReportCard reportCard = new ReportCard(0, classNumber, name, englishScore, mathScore);

        // データベースにデータを追加
        AddDao addDao = new AddDao();
        try {
            reportCard = addDao.addStudentAndReturnWithId(reportCard);
            if (reportCard == null) {
                request.setAttribute("message", "追加できませんでした");
            } else {
                request.setAttribute("reportCard", reportCard);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "データベースエラーが発生しました。");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        // セッションスコープに格納
        HttpSession session = request.getSession();
        session.setAttribute("reportCard", reportCard);

        response.sendRedirect("addresult");
    }

}