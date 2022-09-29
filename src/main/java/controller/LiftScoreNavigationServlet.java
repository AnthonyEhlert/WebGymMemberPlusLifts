package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GymMember;
import model.LiftScore;

/**
 * Servlet implementation class LiftScoreNavigationServlet
 */
@WebServlet("/liftScoreNavigationServlet")
public class LiftScoreNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiftScoreNavigationServlet() {
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
		
		LiftScoreHelper lsh = new LiftScoreHelper();
		String act = request.getParameter("doThisToLiftScore");
		
		String path = "/viewAllLiftScoresServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				LiftScore liftScoreToDelete = lsh.searchForLiftScoreById(tempId);
				lsh.deleteLiftScore(liftScoreToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a memebr");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				LiftScore liftScoreToEdit = lsh.searchForLiftScoreById(tempId);
				request.setAttribute("liftScoreToEdit", liftScoreToEdit);
				path = "/edit-lift-score.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a memebr");
			}
		} else if (act.equals("add")) {
			path = "/addLiftScoreServlet";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
