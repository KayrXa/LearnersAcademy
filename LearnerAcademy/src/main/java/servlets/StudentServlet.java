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
import com.bean.Students;
import com.hibernate.DBconn;





/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbc = new DBconn(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
    	System.out.println("Student Servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		try {
			List<Students> studentList = dbc.getAllStudents();
			List<Classes> classList = dbc.getAllClasses();
			request.setAttribute("studentList", studentList);
			request.setAttribute("classList", classList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			
			dispatcher.forward(request, response);
							
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String sur = request.getParameter("sur");
		String cid = request.getParameter("cid");
		String brthno = request.getParameter("brthno");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		System.out.println(name);
		System.out.println(sur);
		System.out.println(cid);
		System.out.println(brthno);
		System.out.println(phone);
		System.out.println(email);
		
		if(name == null || name.isEmpty() || sur == null || sur.isEmpty() || cid == null || cid.isEmpty())
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			request.setAttribute("error", "No box should stay empty.");
			request.setAttribute("Name", name);
			request.setAttribute("Surname", sur);
			request.setAttribute("cid", cid);
			request.setAttribute("Birth_number", brthno);
			request.setAttribute("Phone_number", phone);
			request.setAttribute("Email", email);
			dispatcher.forward(request, response);

			return;
		}
		
		DBconn dbcom = new DBconn();
		
		
		Students st = new Students(name, sur, cid, brthno, phone, email);
		
		
	
		
		try {
			if(dbcom.addStudent(st)){
				response.sendRedirect("students");
				request.setAttribute("error", "Registration successful.");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("students");
				request.setAttribute("error", "Registration unsuccessful.");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// keep me on registration page
			response.sendRedirect("index.jsp");
			
		}
	}
	

}