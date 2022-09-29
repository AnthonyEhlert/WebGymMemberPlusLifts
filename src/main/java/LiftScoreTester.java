import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.LiftScoreHelper;
import model.GymMember;
import model.Lift;
import model.LiftScore;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */
public class LiftScoreTester {

	public static void main(String[] args) {
		
		GymMember david = new GymMember("David", "Smith", 30);
		GymMember robin = new GymMember("Robin", "Smith", 29);
		
		Lift benchPress = new Lift("Bench Press");
		Lift deadlift = new Lift("Deadlift");
		
		int benchScore = 250;
		int deadliftScore = 400;
		
		LiftScoreHelper lsh = new LiftScoreHelper();
		
//		List<Lift> davidsLifts = new ArrayList<Lift>();
//		davidsLifts.add(benchPress);
//		davidsLifts.add(deadlift);
		
		LiftScore davidBenchPress = new LiftScore(david, benchPress, benchScore, LocalDate.now());
		LiftScore robinDeadlift = new LiftScore(robin, deadlift, deadliftScore, LocalDate.now());
		
		lsh.insertNewLiftScore(davidBenchPress);
		lsh.insertNewLiftScore(robinDeadlift);
		
		List<LiftScore> allScores = lsh.showAllLiftScores();
		
		for (LiftScore a : allScores) {
			System.out.println(a.toString());
		}

	}

}
