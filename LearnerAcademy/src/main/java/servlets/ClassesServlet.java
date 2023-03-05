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
@WebServlet("/classes")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbc = new DBconn();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesServlet() {
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
			List<Classes> classList = dbc.getAllClasses();
			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
			request.setAttribute("classList", classList);
			dispatcher.forward(request, response);
							
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
	
		//Addin new Student 
		
		System.out.println(name);
	
		if(name == null || name.isEmpty() )
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
			request.setAttribute("error", "No box should stay empty.");
			request.setAttribute("Name", name);
			dispatcher.forward(request, response);

			return;
		}
		
		DBconn dbcom = new DBconn();
		Classes cls = new Classes();
		
		
	
		
		try {
			if(dbcom.addClass(cls)){
				response.sendRedirect("classes.jsp");
				request.setAttribute("error", "Registration successful.");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
				request.setAttribute("error", "Registration unsuccessful.");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// keep me on registration page
			response.sendRedirect("index.jsp");
			
		}
	}
	

}