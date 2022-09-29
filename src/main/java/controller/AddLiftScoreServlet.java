package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GymMember;
import model.Lift;
import model.LiftScore;

/**
 * Servlet implementation class AddLiftScoreServlet
 */
@WebServlet("/addLiftScoreServlet")
public class AddLiftScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLiftScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GymMemberHelper gmh = new GymMemberHelper();
		request.setAttribute("allMembers", gmh.showAllMembers());
		String path = "/add-lift-score.jsp";
		
		if(gmh.showAllMembers().isEmpty()) {
			path = "/index.html";
		}
		
		LiftHelper lh = new LiftHelper();
		request.setAttribute("allLifts", lh.showAllLifts());
		
		if(lh.showAllLifts().isEmpty()) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		GymMemberHelper gmh = new GymMemberHelper();
		LiftHelper lh = new LiftHelper();
		LiftScoreHelper lsh = new LiftScoreHelper();
		
		Integer tempMemberId = Integer.parseInt(request.getParameter("memberId"));
		Integer tempLiftId = Integer.parseInt(request.getParameter("liftId"));
		
		GymMember memberSelected = gmh.searchForMemberById(tempMemberId);
		Lift liftSelected = lh.searchForLiftById(tempLiftId);
		
		LocalDate dateOfScore = LocalDate.parse(request.getParameter("dateOfScore"));
		Integer score = Integer.parseInt(request.getParameter("score"));
		
		LiftScore liftScoreToAdd = new LiftScore(memberSelected, liftSelected, score, dateOfScore);
		
		lsh.insertNewLiftScore(liftScoreToAdd);
	}

}
