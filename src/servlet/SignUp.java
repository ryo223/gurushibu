package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String mail_address = request.getParameter("mail_address");
		//苗字と名前を取得
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String user_name = request.getParameter("user_name");
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		//確認用パスワード
		String user_password2 = request.getParameter("user_password2");


		/* 入力値がnullもしくは登録済み出ないかをチェック
		if(!(user_password.equals(user_password2)) ||
			(mail_address.equals("") || user_name.equals("") || user_id.equals("") || user_password.equals("") || user_password2.equals("") || account.userIdFind(user_id) != null)) {

			response.sendRedirect("SampleWeb/SignUp.html");
		}else {

		account.accountInsert(user_id, user_name, user_password, mail_address);

 */
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("SampleWeb/MyPage.jsp");
		dispatcher.forward(request, response);

		}

	}
//}
