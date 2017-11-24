package utng.jsf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="user")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM user u"),
	@NamedQuery(name="User.count", query="SELECT COUNT(u) FROM user u")
})
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=70)
	private String name;
	
	@Column(length=10,nullable=false)
	private String login;
	
	@Column(length=30,nullable=false)
	private String password;
	
	@Column(nullable=false)
	private int age;

	@OneToOne @JoinColumn(name="role_id")
	private SecurityRole role;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the role
	 */
	public SecurityRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(SecurityRole role) {
		this.role = role;
	}
	
	
}
