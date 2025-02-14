package manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Event;
import dao.EventDAO;

@WebServlet(urlPatterns = { "/manage/calendar-edit" })
public class CalendarEdit extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		try {
			EventDAO dao = new EventDAO();

			int year = Integer.parseInt(req.getParameter("year"));
			int month = Integer.parseInt(req.getParameter("month"));
			int day = Integer.parseInt(req.getParameter("day"));

			List<Event> list  = dao.oneDay(year,month,day);
			req.setAttribute("list", list);

			req.setAttribute("year", year);
			req.setAttribute("month", month);
			req.setAttribute("day", day);


			req.getRequestDispatcher("calendar-edit.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		try {
			List<Event> list = new ArrayList<Event>();

			int year = Integer.parseInt(req.getParameter("year"));
			int month = Integer.parseInt(req.getParameter("month"));
			int day = Integer.parseInt(req.getParameter("day"));

			Date searchDate =new Date(year-1900, month-1, day) ;

			String[] ids = req.getParameterValues("id");
			String[] names = req.getParameterValues("name");
			String[] contents = req.getParameterValues("content");

			// DAOをインスタンス化
			EventDAO dao = new EventDAO();

			for (int i = 0; i < ids.length; i++) {
				Event e = new Event();
				e.setId(ids[i]);
				e.setDate(searchDate);
				e.setName(names[i]);
				e.setContent(contents[i]);

				list.add(e);
			}

			int a = dao.updateAndInsert(list);

			resp.sendRedirect("calendar");

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
}