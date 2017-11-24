package utng.jsf.managebeans;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import utng.jsf.entities.SecurityRole;
import utng.jsf.entities.User;
import utng.jsf.repositories.UserReository;
import utng.jsf.repositories.securityRoleRepository;

public class UsuarioBean {
	@ManagedProperty(value="#{entityManger}")
	private EntityManager entityManager;
	private User usuario = new User();
	private List<User> usuarios;
	private Long rolSeguridadID;
	
	public void save() {
		securityRoleRepository roleSeguridadRepository = new securityRoleRepository(this.entityManager);
		SecurityRole rolSeguridad = roleSeguridadRepository.seach(rolSeguridadID);
		this.usuario.setRole(rolSeguridad);
		this.usuario.setRole(rolSeguridad);
		UserReository userReository = new UserReository(this.entityManager);
		if(this.usuario.getId()!=null) {
			userReository.update(this.usuario);
		}else {
			userReository.update(this.usuario);
		}
		this.usuario = new User();
		this.usuarios = null;
		this.setRolSeguridadID();
	}
	
	public void remove(User user) {
		UserReository reository = new UserReository(this.entityManager);
		reository.remove(user);
		this.usuarios = null;
	}
	
	public void search(User user) {
		UserReository reository = new UserReository(this.entityManager);
		usuario = reository.search(usuario.getId());
	}
	
	public List<User> getUsuarios(){
		if (this.usuarios==null) {
			UserReository reository = new UserReository(this.entityManager);
			this.usuarios = reository.getUsuarios();
		}
		return this.usuarios;
	}
	
	public Long getCount() {
		UserReository reository = new UserReository(this.entityManager);
		return reository.getCountUsuarios();
	}
	
	public User getUser() {
		return usuario;
	}
	
	public void setUsuario(User user) {
		this.usuario = usuario;
	}
	
	public Long getRolSeguridadID() {
		return rolSeguridadID;
	}
	
	public Long setRolSeguridadID() {
		return rolSeguridadID;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute(" EntityManager ");
	}
	
}
