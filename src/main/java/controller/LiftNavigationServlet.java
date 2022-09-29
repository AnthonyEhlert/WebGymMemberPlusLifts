package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lift;
import model.LiftScore;

/**
 * Servlet implementation class LiftNavigationServlet
 */
@WebServlet("/liftNavigationServlet")
public class LiftNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiftNavigationServlet() {
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
		String act = request.getParameter("doThisToLift");
		
		String path = "/viewAllLiftsServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Lift liftToDelete = lh.searchForLiftById(tempId);
				lh.deleteLift(liftToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a memebr");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Lift liftToEdit = lh.searchForLiftById(tempId);
				request.setAttribute("liftToEdit", liftToEdit);
				path = "/edit-lift.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a memebr");
			}
		} else if (act.equals("add")) {
			path = "/add-lift.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
