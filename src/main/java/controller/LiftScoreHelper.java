package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LiftScore;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */
public class LiftScoreHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGymMemberPlusLifts");
	
	public void insertNewLiftScore(LiftScore ls) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ls);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<LiftScore> showAllLiftScores() {
		EntityManager em = emfactory.createEntityManager();
		List<LiftScore> allScores = em.createQuery("SELECT s FROM LiftScore s").getResultList();
		return allScores;
	}
	
	public void deleteLiftScore(LiftScore toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LiftScore> typedQuery = em.createQuery("SELECT score FROM LiftScore score WHERE score.id = :selectedId", LiftScore.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		LiftScore result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public LiftScore searchForLiftScoreById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LiftScore found = em.find(LiftScore.class, tempId);
		em.close();
		return found;
	}
	
	public void updateLiftScore(LiftScore toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
