package manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentClass2;
import bean.StudentJoinClass;
import bean.Teacher;
import dao.StudentJoinClassDAO;
import dao.Student_ClassDAO2;
import dao.TeacherDAO;

@WebServlet(urlPatterns = { "/manage/class-organize" })
public class ClassOrganize extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// DAOをインスタンス化
			StudentJoinClassDAO sdao = new StudentJoinClassDAO();
			TeacherDAO tdao = new TeacherDAO();

			int grade = Integer.parseInt(req.getParameter("grade"));
			int number = Integer.parseInt(req.getParameter("number"));

			List<StudentJoinClass> slist=sdao.gradeAll(grade);
			List<Teacher> tlist=tdao.all();


			req.setAttribute("grade", grade);
			req.setAttribute("number", number);
			req.setAttribute("slist", slist);
			req.setAttribute("tlist", tlist);

			req.getRequestDispatcher("class-organize.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		try {
			TeacherDAO tdao = new TeacherDAO();

			int grade = Integer.parseInt(req.getParameter("grade"));
			int number = Integer.parseInt(req. getParameter("number"));
			String[] teachers = req. getParameterValues("teacher");

			List<Teacher> tlist = new ArrayList<Teacher>();
			for (int i = 0; i < number; i++) {
				Teacher t= new Teacher();
				t.setId(teachers[i]);
				t.setGrade(grade);
				t.setClass_no(i+1);
				tlist.add(t);
			}
			int s = tdao.updateClassNo(tlist);


			Student_ClassDAO2 cdao = new Student_ClassDAO2();
			String[] students = req. getParameterValues("student");

			List<StudentClass2> slist = new ArrayList<StudentClass2>();
			for (int i = 0; i < students.length; i++) {
				StudentClass2 p= new StudentClass2();
				p.setId(students[i]);

				String class_no = req. getParameter("class_no["+i+"]");
				p.setClass_no(Integer.parseInt(class_no));

				slist.add(p);
			}
			s = cdao.inserts(slist);


			StudentJoinClassDAO sdao = new StudentJoinClassDAO();
			for (int i = 1; i <= cdao.maxClassNo(grade); i++) {
				List<String> ClassAll = sdao.classAllNameASC(grade, i);
				cdao.setNumber(ClassAll);
			}
			s = cdao.delNumber();

			resp.sendRedirect("class-list");

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
}