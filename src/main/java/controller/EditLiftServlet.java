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
 * Servlet implementation class EditLiftServlet
 */
@WebServlet("/editLiftServlet")
public class EditLiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		LiftHelper lh = new LiftHelper();
		
		String liftName = request.getParameter("name");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Lift liftToUpdate = lh.searchForLiftById(tempId);
		liftToUpdate.setName(liftName);
		
		lh.updateLift(liftToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllLiftsServlet").forward(request, response);
		
	}

}
