package clerk;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClerkDAO;

@WebServlet("/clerkName")
public class ClerkServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClerkDAO dao = new ClerkDAO();
		List<String> clerkNames = dao.getAllClerkNames();

		req.setAttribute("clerkNames", clerkNames);

		req.getRequestDispatcher("main2.jsp").forward(req, resp);
	}
}
