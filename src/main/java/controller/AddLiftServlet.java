package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GymMember;
import model.Lift;

/**
 * Servlet implementation class AddLiftServlet
 */
@WebServlet("/addLiftServlet")
public class AddLiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/add-lift.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String liftName = request.getParameter("name");
		
		if (!liftName.isBlank()) {
			Lift l = new Lift(liftName);
			LiftHelper lh = new LiftHelper();
			lh.insertLift(l);
		}
		
		getServletContext().getRequestDispatcher("/viewAllLiftsServlet").forward(request, response);
	}

}
