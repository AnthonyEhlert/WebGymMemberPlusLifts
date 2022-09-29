package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GymMember;
import model.LiftScore;

/**
 * Servlet implementation class EditLiftScoreServlet
 */
@WebServlet("/editLiftScoreServlet")
public class EditLiftScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLiftScoreServlet() {
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
		
		LocalDate dateOfScore = LocalDate.parse(request.getParameter("dateOfScore"));
		Integer score = Integer.parseInt(request.getParameter("score"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println(waiverSigned);
		
		LiftScore liftScoreToUpdate = lsh.searchForLiftScoreById(tempId);
		liftScoreToUpdate.setDateOfScore(dateOfScore);
		liftScoreToUpdate.setScore(score);
		
		lsh.updateLiftScore(liftScoreToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllLiftScoresServlet").forward(request, response);
		
		
	}

}
