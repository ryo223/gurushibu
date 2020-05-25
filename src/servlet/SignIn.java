package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignIn() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user_id);

		UserDao userDao = new UserDao();
		if(userDao.regUser(user_id, password) == true) {
			//ログイン成功時
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchForm/search.html");
			dispatcher.forward(request, response);
		}else {
		//ログイン失敗時
		response.sendRedirect("TopPage");
		}
	}
}