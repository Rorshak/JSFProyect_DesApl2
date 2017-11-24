package utng.jsf.managebeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import utng.jsf.repositories.securityRoleRepository;
import utng.jsf.entities.SecurityRole;


@ManagedBean
public class RolSeguridadBean {

	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;
	
	private List<SecurityRole>  rolesSeguridad = null;
	
	public List<SecurityRole> getRolesSeguridad(){
		if(this.rolesSeguridad == null) {
			securityRoleRepository repository = new securityRoleRepository(entityManager);
			this.rolesSeguridad = repository.getSecurityRole();
		}
		return this.rolesSeguridad;
	}
	
	public void setEntityManager (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
