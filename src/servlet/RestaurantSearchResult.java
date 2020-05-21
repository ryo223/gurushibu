package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantSearchResult")
public class RestaurantSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RestaurantSearchResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search_word = request.getParameter("search_word");

		request.setAttribute("search_word", search_word);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchForm/searchResult.jsp");
		dispatcher.forward(request, response);
	}
}
