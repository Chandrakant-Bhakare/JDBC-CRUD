package StudentCrude.StudentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import StudentCrude.daoImpliment.daoImpliment;

/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	daoImpliment studentDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        studentDAOImpl = new daoImpliment();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			int result = studentDAOImpl.remove(id);
			response.sendRedirect("StudentController");
			if(result>0) {
				printWriter.println("<h3>Student deleted</h3>");
			}
			else {
				printWriter.println("<h3>Problem in deletion</h3>");
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			printWriter.println("<h3>Something went wrong...</h3>");
		}
	}

}
