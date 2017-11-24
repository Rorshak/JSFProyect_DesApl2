package utng.jsf.repositories;

import java.util.List;

import javax.persistence.EntityManager;



import utng.jsf.entities.User;

public class UserReository {
	private EntityManager entityManager;
	
	public UserReository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(User user) {
		this.entityManager.persist(user);
		this.entityManager.flush();
	}
	
	public void update(User user) {
		this.entityManager.persist(user);
		this.entityManager.flush();
	}
	
	public void remove(User user) {
		this.entityManager.remove(user);
	}
	
	public User search(Long ID) {
		return this.entityManager.find(User.class,ID);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsuarios(){
		return this.entityManager.createNamedQuery("User.findAll")
				.getResultList();
	}
	
	public Long getCountUsuarios() {
		return (Long) this.entityManager.createNamedQuery("User.count")
				.getSingleResult();
	}
	
}
