package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GymMember;
import model.Lift;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */
public class LiftHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGymMemberPlusLifts");
	
	// method to add/insert a new lift to the database
		public void insertLift(Lift l) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			em.close();
		}
		
		//method to show display all lifts in database
		public List<Lift> showAllLifts() {
			EntityManager em = emfactory.createEntityManager();
			List<Lift> allLifts = em.createQuery("SELECT i FROM Lift i").getResultList();
			return allLifts;
		}
		
		// method to delete lift from database
		public void deleteLift(Lift toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Lift> typedQuery = em.createQuery("SELECT l FROM Lift l WHERE l.name = :selectedName", Lift.class);
			
			//Substitute parameter with actual data from the toDelete lift
			typedQuery.setParameter("selectedName", toDelete.getName());
			
			//ensures only one result is selected for deletion
			typedQuery.setMaxResults(1);
			
			//get the result and save it into a new list member
			Lift result = typedQuery.getSingleResult();
			
			//remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
		
		public void updateLift(Lift toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
		
		public Lift searchForLiftById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction();
			Lift found = em.find(Lift.class, idToEdit);
			return found;
		}
		
		/**
		 * @param name- Lift's name parameter to search database for
		 * @return- list of Lift objects that have matching name parameter
		 */
		public List<Lift> searchForLiftByName(String name) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction();
			TypedQuery<Lift> typedQuery = em.createQuery("SELECT l FROM Lift l WHERE l.name = :selectedName", Lift.class);
			typedQuery.setParameter("selectedName", name);
			List<Lift> foundLifts = typedQuery.getResultList();
			em.close();
			return foundLifts;
		}
		
		// method to ensure database has no entry points when finished
		public void cleanUp() {
			emfactory.close();
		}
}
