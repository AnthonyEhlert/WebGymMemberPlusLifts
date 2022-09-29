package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GymMember;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editMemberServlet")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMemberServlet() {
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
		
		GymMemberHelper gmh = new GymMemberHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer age = Integer.parseInt(request.getParameter("age"));
		boolean waiverSigned = Boolean.parseBoolean(request.getParameter("waiverSigned"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println(waiverSigned);
		
		GymMember memberToUpdate = gmh.searchForMemberById(tempId);
		memberToUpdate.setFirstName(firstName);
		memberToUpdate.setLastName(lastName);
		memberToUpdate.setAge(age);
		memberToUpdate.setWaiverSigned(waiverSigned);
		
		gmh.updateMember(memberToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllMembersServlet").forward(request, response);
		
	}

}
