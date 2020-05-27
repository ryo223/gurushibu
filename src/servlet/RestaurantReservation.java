package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Course_menuDao;
import dao.ReservationDao;
import dao.Reservation_courseDao;

@WebServlet("/RestaurantReservation")
public class RestaurantReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RestaurantReservation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restaurant_name = request.getParameter("restaurant_name");
		RequestDispatcher dispatcher = request.getRequestDispatcher("SampleWeb/Restaurant.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReservationDao reservation = new ReservationDao();
		Course_menuDao course_menu = new Course_menuDao();
		Reservation_courseDao res_course = new Reservation_courseDao();

		request.setCharacterEncoding("utf-8");
		String restaurant_name = request.getParameter("restaurant_name");
		String persons = request.getParameter("persons");
		String course_name = request.getParameter("course_name");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");

		if(date != "" || time != "") {
		reservation.addReservation(date, time, restaurant_name, persons, loginUser);
		int course_id = course_menu.getCourseMenu(restaurant_name,course_name);
		res_course.addReservationCourse(date, time, restaurant_name, course_id);
		}else {
			System.out.println("err");
		}
		//Reservationテーブルに予約内容を保存する処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("Sign-In-Up/index.html");
		dispatcher.forward(request, response);
		}
}
