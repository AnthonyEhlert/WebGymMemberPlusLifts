import java.util.List;

import controller.LiftHelper;
import model.Lift;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */
public class LiftTester {

	public static void main(String[] args) {
	
		Lift backSquat = new Lift("Back Squat");
		Lift frontSquat = new Lift("Front Squat");
		
		LiftHelper lh = new LiftHelper();
		
		lh.insertLift(backSquat);
		lh.insertLift(frontSquat);
		
		List<Lift> allLifts = lh.showAllLifts();
		
		for (Lift l: allLifts) {
			System.out.println(l.toString());
		}
		
	}
}
