package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Event;
import dao.EventDAO;

@WebServlet(urlPatterns = { "/teacher/calendar" })
public class Calendar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			String day = req.getParameter("day");

			EventDAO dao = new EventDAO();

			Date date = new Date();
			LocalDate today = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			int currentYear = today.getYear();
			int currentMonth = today.getMonthValue();

			if (year != null) {
				currentYear = Integer.parseInt(year);
				currentMonth = Integer.parseInt(month);
			}

			req.setAttribute("year", currentYear);
			req.setAttribute("month", currentMonth);
			req.setAttribute("day", day);

			List<Integer> eventList = dao.oneMonth(currentYear, currentMonth);
			req.setAttribute("eventList", eventList);

			if (day != null) {
				int currentDay = Integer.parseInt(day);
				List<Event> list  = dao.oneDay(currentYear,currentMonth,currentDay);
				req.setAttribute("list", list);
			}

			req.getRequestDispatcher("calendar.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
}