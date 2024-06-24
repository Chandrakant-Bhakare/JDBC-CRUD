package StudentCrude.StudentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import StudentCrude.dao.StudentDAO;
import StudentCrude.daoImpliment.daoImpliment;
import StudentCrude.model.Student;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	daoImpliment studentDAOImpl;

    /**
     * Default constructor. 
     */
    public StudentController() {
    	studentDAOImpl = new daoImpliment();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			List<Student> student = studentDAOImpl.getAll();
			printWriter.println("<table border='1' cellspacing='0' cellpadding='10'>");
			printWriter.println("<tr>");
			printWriter.println("<th>Id</th>");
			printWriter.println("<th>Name</th>");
			printWriter.println("<th>Phone</th>");
			printWriter.println("<th>Marks</th>");
			printWriter.println("<th>City</th>");
			printWriter.println("<th>Gender</th>");
			printWriter.println("<th>Actions</th>");
			printWriter.println("</tr>");
			
			Iterator<Student> studentIterator = student.iterator();
			while(studentIterator.hasNext()) {
				Student std = studentIterator.next();
				printWriter.println("<tr>");
				printWriter.println("<td><a href='index.html'>"+std.getId()+"</a></td>");
				printWriter.println("<td>"+std.getName()+"</td>");
				printWriter.println("<td>"+std.getPhone()+"</td>");
				printWriter.println("<td>"+std.getMarks()+"</td>");
				printWriter.println("<td>"+std.getCity()+"</td>");
				printWriter.println("<td>"+std.getGender()+"</td>");
				printWriter.println("<td><a href='DeleteStudent?id="+std.getId()+"'>Delete</a></td>");
				printWriter.println("<tr>");
			}
			
			printWriter.println("</table>");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			printWriter.println("<h3>Something went wrong...</h3>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printwriter = response.getWriter();
		try {
		Student std = new Student();
		std.setId(Integer.parseInt(request.getParameter("id")));
		std.setName(request.getParameter("name"));
		std.setPhone(request.getParameter("phone"));
		std.setMarks(Float.parseFloat(request.getParameter("marks")));
		std.setCity(request.getParameter("city"));
		std.setGender(request.getParameter("gender"));
		daoImpliment stdimpl = new daoImpliment();
		int result = stdimpl.add(std);
		response.sendRedirect("StudentController");
		if(result>0) {
			printwriter.println("<h3>Student Registration Successful</h3>");
		}
		printwriter.println("Registration Failed");
		} catch (Exception e) {
			System.out.println(e);
			printwriter.println("<h3>Somthing went Wrong....</h3>");
		}
	}

}
