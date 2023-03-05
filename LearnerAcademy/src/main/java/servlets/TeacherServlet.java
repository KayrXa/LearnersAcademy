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
import com.bean.Teachers;
import com.hibernate.DBconn;





/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/teachers")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbc = new DBconn(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
    	System.out.println("Classes Servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		try {
			List<Teachers> teacherList = dbc.getAllTeachers();
			request.setAttribute("teacherList", teacherList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			dispatcher.forward(request, response);
							
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brthno = request.getParameter("brthno");
		String name = request.getParameter("name");
		String sur = request.getParameter("sur");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		System.out.println(name);
		System.out.println(sur);
		System.out.println(brthno);
		System.out.println(phone);
		System.out.println(email);
		
		if(name == null || name.isEmpty() || sur == null || sur.isEmpty() )
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			request.setAttribute("error", "No box should stay empty.");
			request.setAttribute("Birth_number", brthno);
			request.setAttribute("Name", name);
			request.setAttribute("Surname", sur);
			request.setAttribute("Phone_number", phone);
			request.setAttribute("Email", email);
			dispatcher.forward(request, response);

			return;
		}
		
		DBconn dbcom = new DBconn();
		Teachers teacher = new Teachers();
		
		
		try {
			if(dbcom.addTeacher(teacher)){
				response.sendRedirect("teachers");
				request.setAttribute("error", "Registration successful.");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("teachers");
				request.setAttribute("error", "Registration unsuccessful.");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// keep me on registration page
			response.sendRedirect("index.jsp");
			
		}
	}
	

}