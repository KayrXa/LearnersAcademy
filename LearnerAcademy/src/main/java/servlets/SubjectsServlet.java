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
import com.bean.Subjects;
import com.hibernate.DBconn;


/**
 * Servlet implementation class Subjects
 */
@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbc = new DBconn(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Subjects> subjectList = dbc.getAllSubjects();
			request.setAttribute("subjectList", subjectList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
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
		String name = request.getParameter("name");
		String shortcut = request.getParameter("shortcut");
		
		
		System.out.println(name);
		System.out.println(shortcut);
	
		if(name == null || name.isEmpty() )
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
			request.setAttribute("error", "No box should stay empty.");
			request.setAttribute("Name", name);
			request.setAttribute("Shortcut", shortcut);
			dispatcher.forward(request, response);

			return;
		}
		
		DBconn dbcom = new DBconn();
		Subjects sub = new Subjects(name, shortcut);
		
		
	
		
		try {
			if(dbcom.addSubject(sub)){
				response.sendRedirect("subjects");
				request.setAttribute("error", "Registration successful.");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjects");
				request.setAttribute("error", "Registration unsuccessful.");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// keep me on registration page
			response.sendRedirect("index.jsp");
			
		}
	}

}
