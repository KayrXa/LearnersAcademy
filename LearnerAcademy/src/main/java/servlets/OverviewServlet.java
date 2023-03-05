package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Classes;
import com.bean.ClassesSubjectsTeacherLink;
import com.bean.Students;
import com.bean.Subjects;
import com.bean.Teachers;
import com.hibernate.DBconn;

/**
 * Servlet implementation class Overview
 */
@WebServlet("/overview")
public class OverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbc = new DBconn();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			List<Classes> classList = dbc.getAllClasses();
			List<Students> studentList = dbc.getAllStudents();
			List<Teachers> teacherList = dbc.getAllTeachers();
			List<Subjects> subjectList = dbc.getAllSubjects();
			List<ClassesSubjectsTeacherLink> relList = dbc.getAllRelations();
			request.setAttribute("classList", classList);	
			request.setAttribute("studentList", studentList);
			request.setAttribute("teacherList", teacherList);	
			request.setAttribute("subjectList", subjectList);
			request.setAttribute("relList", relList);	
			RequestDispatcher dispatcher = request.getRequestDispatcher("overview.jsp");
			dispatcher.forward(request, response);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
