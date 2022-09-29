package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GymMember;

/**
 * Servlet implementation class AddMemberServlet
 */
@WebServlet("/addMemberServlet")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer age = Integer.parseInt(request.getParameter("age"));
		
		//System.out.println(firstName + ", " + lastName + ", " + age);
			GymMember gm = new GymMember(firstName, lastName, age);
			GymMemberHelper gmh = new GymMemberHelper();
			gmh.insertMember(gm);
		} catch (NumberFormatException e) {
			System.out.println("Forgot to enter information");
		}
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
