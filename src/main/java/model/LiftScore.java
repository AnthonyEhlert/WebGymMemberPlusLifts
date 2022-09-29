package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */

@Entity
@Table(name = "lift_score")
public class LiftScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= {CascadeType.MERGE})
	private GymMember gymMember;
	
//	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
//	private List<Lift> listOfLifts;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private Lift lift;
	
	private int score;
	
	private LocalDate dateOfScore;
	
	//default no-arg constructor
	public LiftScore() {
		super();
	}
	
	//helper constructors
	public LiftScore(int id, GymMember gymMember, Lift lift, int score, LocalDate dateOfScore) {
		super();
		this.id = id;
		this.gymMember = gymMember;
		this.lift = lift;
		this.score = score;
		this.dateOfScore = dateOfScore;
	}
	
	public LiftScore(GymMember gymMember, Lift lift, int score, LocalDate dateOfScore) {
		super();
		this.gymMember = gymMember;
		this.lift = lift;
		this.score = score;
		this.dateOfScore = dateOfScore;
	}
	
	public LiftScore(GymMember gymMember, Lift lift, int score) {
		super();
		this.gymMember = gymMember;
		this.lift = lift;
		this.score = score;
	}

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GymMember getGymMember() {
		return gymMember;
	}

	public void setGymMember(GymMember gymMember) {
		this.gymMember = gymMember;
	}

//	public List<Lift> getListOfLifts() {
//		return listOfLifts;
//	}
//
//	public void setListOfLifts(List<Lift> listOfLifts) {
//		this.listOfLifts = listOfLifts;
//	}

	public Lift getLift() {
		return lift;
	}

	public void setLift(Lift lift) {
		this.lift = lift;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDate getDateOfScore() {
		return dateOfScore;
	}

	public void setDateOfScore(LocalDate dateOfScore) {
		this.dateOfScore = dateOfScore;
	}

	@Override
	public String toString() {
		return "LiftScore [id=" + id + ", gymMember=" + gymMember + ", listOfLifts= + listOfLifts + + lift=" + lift
				+ ", score=" + score + ", dateOfScore=" + dateOfScore + "]";
	}
	
	
}
