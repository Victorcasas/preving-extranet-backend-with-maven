package preving.extranet.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROL_EXTRANET")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 892213153409959665L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="RE_ID")
	private Long id;

	@Column(name="RE_NOMBRE_ROL", unique = true)
	private String nombreRol;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<User> usuarios;
	
	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<User> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
