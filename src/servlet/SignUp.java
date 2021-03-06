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

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		UserDao userDao = new UserDao();
		//苗字と名前を取得
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String user_name = first_name + last_name;
		String mail_address = request.getParameter("mail_address");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		//確認用パスワード
		String retype_password = request.getParameter("retype_password");

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user_id);
		// パスワードと確認用パスワードが一致していて、アカウントが登録済みでないかをチェック
		if(!password.equals(retype_password) || userDao.findUser(user_id) == true){
			response.sendRedirect("TopPage");
		}else {

		userDao.addUser(user_id, user_name, mail_address, password);

		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchForm/search.html");
		dispatcher.forward(request, response);

		}
	}
}
