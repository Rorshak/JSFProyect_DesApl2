package utng.jsf.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import utng.jsf.entities.SecurityRole;

public class securityRoleRepository {
	private EntityManager entityManager;

	public securityRoleRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public SecurityRole seach(Long id) {
		return entityManager.find(SecurityRole.class, id);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SecurityRole> getSecurityRole(){
		return entityManager.createNamedQuery("SecurityRole.findAll").getResultList();
	}
}