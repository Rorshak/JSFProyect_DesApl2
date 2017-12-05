package utng.jsf.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import utng.jsf.entities.SecurityRole;
import utng.jsf.entities.User;

public class SecurityRoleRepository {
	
	private EntityManager entityManager;
	
	public SecurityRoleRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public SecurityRole search(Long ID) {
		return entityManager.find(SecurityRole.class, ID);
	}
	
	public void save(SecurityRole security) {
		this.entityManager.persist(security);
		this.entityManager.flush();
	}
	
	public void update(SecurityRole security) {
		this.entityManager.merge(security);
		this.entityManager.flush();
	}
	
	public void remove(SecurityRole security) {
		this.entityManager.remove(security);
	}
	

	
	@SuppressWarnings("unchecked")
	public List<SecurityRole> getSecurityRoles(){
		return this.entityManager.createNamedQuery("SecurityRole.findAll").getResultList();
	}
	
	public Long getCountSecurityRoles() {
		return (Long) this.entityManager.createNamedQuery("SecurityRole.count").getSingleResult();
	}
}
