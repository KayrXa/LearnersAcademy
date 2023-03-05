package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ClassesSubjectsTeacherLink;
import com.hibernate.DBconn;

/**
 * Servlet implementation class RelationsServlet
 */
@WebServlet("/relations")
public class RelationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbc = new DBconn(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ClassesSubjectsTeacherLink> relList = dbc.getAllRelations();
			request.setAttribute("relList", relList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("relations.jsp");
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
		String cid = request.getParameter("cid");
		String tid = request.getParameter("tid");
		String sid = request.getParameter("sid");
		
		System.out.println(cid);
		System.out.println(tid);
		System.out.println(sid);
	
		if(cid == null || cid.isEmpty() || tid == null || tid.isEmpty() || sid == null || sid.isEmpty())
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("relations.jsp");
			request.setAttribute("error", "No box should stay empty.");
			request.setAttribute("cid", cid);
			request.setAttribute("tid", tid);
			request.setAttribute("sid", sid);
			dispatcher.forward(request, response);

			return;
		}
		
		DBconn dbcom = new DBconn();
		ClassesSubjectsTeacherLink rel = new ClassesSubjectsTeacherLink();
		
		
	
		
		try {
			if(dbcom.addRelation(rel)){
				response.sendRedirect("relations.jsp");
				request.setAttribute("error", "Registration successful.");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("relations.jsp");
				request.setAttribute("error", "Registration unsuccessful.");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// keep me on registration page
			response.sendRedirect("index.jsp");
			
		}
	}

}
