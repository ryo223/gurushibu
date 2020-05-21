package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String restaurant_name = request.getParameter("restaurant_name");
		RequestDispatcher dispatcher = request.getRequestDispatcher("SampleWeb/Restaurant.jsp");
		dispatcher.forward(request, response);


	}
}
