package utng.jsf.manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import utng.jsf.entities.SecurityRole;
import utng.jsf.entities.User;
import utng.jsf.repositories.SecurityRoleRepository;
import utng.jsf.repositories.UserRepository;

@ManagedBean
public class SecurityRoleBean {
	
	@ManagedProperty(value="#{entityManager}")
	
	private EntityManager entityManager;
	private SecurityRole security = new SecurityRole();
	private List<SecurityRole> securityRoles=null;
	
	//
	public List<SecurityRole> getSecurityRoles(){
		if(this.securityRoles == null) {
			SecurityRoleRepository repository = new SecurityRoleRepository(entityManager);
			this.securityRoles= repository.getSecurityRoles();
		}
		return this.securityRoles;
	}
	
	public void save() {
		SecurityRoleRepository securityRoleRepository = new SecurityRoleRepository(entityManager);		
		if(this.security.getId()!=null) {
			securityRoleRepository.update(this.security);
		}else {
			securityRoleRepository.save(this.security);
		}
		this.security= new SecurityRole();
		this.securityRoles = null;
		
	}
	
	//
	public void remove(SecurityRole security) {
		SecurityRoleRepository repository= new SecurityRoleRepository(this.entityManager);
		repository.remove(security);
		this.securityRoles= null;
	}
	//
	public void search(SecurityRole security) {
		SecurityRoleRepository repository= new SecurityRoleRepository(this.entityManager);
		security= repository.search(security.getId());
		this.security = security;
		

	}
	//
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager= entityManager;
	}
	public Long getCount() {
		SecurityRoleRepository repository= new SecurityRoleRepository(this.entityManager);
		return repository.getCountSecurityRoles();
	}
	
	public SecurityRole getSecurityRole() {
		return security;
	}
	
	public void setSecurityRoleID(SecurityRole security) {
		this.security= security;
	}
	
	
	
	@SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("EntityManager");
	}

}
