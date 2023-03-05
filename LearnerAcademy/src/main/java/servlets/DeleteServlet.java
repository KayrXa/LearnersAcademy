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
import com.bean.Students;
import com.hibernate.DBconn;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn dbconn = new DBconn();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ent = request.getParameter("ent");
		System.out.println(ent);
		
		List<ClassesSubjectsTeacherLink> relList = dbconn.getAllRelations();
		List<Students> studentList = dbconn.getAllStudents();
		
		switch(ent) {
			case "rel":
				int id = Integer.parseInt(request.getParameter("id"));
				RequestDispatcher dispatcherAs = request.getRequestDispatcher("relations");
				try {
					dbconn.deleteRelationById(id); 
					request.setAttribute("message", "Assignment deleted successfully.");
					dispatcherAs.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", "Assignment not deleted.");
					dispatcherAs.forward(request, response);
					e.printStackTrace();
				}
				break;
			case "cls":
				String cid = request.getParameter("cid");
				RequestDispatcher dispatcherCl = request.getRequestDispatcher("classes");
				for(Students s:studentList) {
					if(cid.equals(s.getCid())) {
						request.setAttribute("message", "Class cannot be deleted, there are still students in the class.");
						dispatcherCl.forward(request, response);
					}
				}
				try {
					dbconn.deleteClassById(cid); 
					request.setAttribute("message", "Class deleted successfully.");
					dispatcherCl.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", "Class not deleted.");
					dispatcherCl.forward(request, response);
					e.printStackTrace();
				}
				break;
			case "stud":
				int stid = Integer.parseInt(request.getParameter("stid"));
				RequestDispatcher dispatcherSt = request.getRequestDispatcher("students");
				try {
					dbconn.deleteStudentById(stid); 
					request.setAttribute("message", "Student deleted successfully.");
					dispatcherSt.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", "Student not deleted.");
					dispatcherSt.forward(request, response);
					e.printStackTrace();
				}
				break;
			case "sub":
				int sid = Integer.parseInt(request.getParameter("sid"));
				RequestDispatcher dispatcherSb = request.getRequestDispatcher("subjects");
				//Relationsnot done yet
				for(ClassesSubjectsTeacherLink r:relList) {
					if(sid == r.getClasses()) {
						request.setAttribute("message", "Subject cannot be deleted, it is still assigned to classes.");
						dispatcherSb.forward(request, response);
					}
					
				}
				try {
					dbconn.deleteSubjectById(sid); 
					request.setAttribute("message", "Subject deleted successfully.");
					dispatcherSb.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", "Subject not deleted.");
					dispatcherSb.forward(request, response);
					e.printStackTrace();
				}
				break;
			case "tchr":
				int tid = Integer.parseInt(request.getParameter("tid"));
				RequestDispatcher dispatcherTe = request.getRequestDispatcher("teachers");
				for(ClassesSubjectsTeacherLink r:relList) {
					if(tid == r.getTid()) {
						request.setAttribute("message", "Teacher cannot be removed, he/she is still assigned to classes.");
						dispatcherTe.forward(request, response);
					}
				}
				try {
					dbconn.deleteTeacherById(tid); 
					request.setAttribute("message", "Teacher deleted successfully.");
					dispatcherTe.forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", "Teacher not deleted.");
					dispatcherTe.forward(request, response);
					e.printStackTrace();
				}
				break;
			default:
				response.sendRedirect("index.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
