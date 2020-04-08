package preving.extranet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USUARIO_EXTRANET")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5992289840321371442L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="UE_ID")
	private Long id;
	
	@Column(name="UE_EMAIL", unique = true)
	private String email;
	
	@Column(name="UE_PASS")
	private String passWord;
	
	@Column(name="UE_NOMBRE")
	private String nombre;
	
	@Column(name="UE_APELLIDOS")
	private String apellidos;
	
	@Column(name="UE_FECHA_ALTA")
	private Date fechaAlta;
	
	@Column(name="UE_GESTION")
	private Boolean perGestion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UE_ID_ROL")
	private Role rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Boolean getPerGestion() {
		return perGestion;
	}

	public void setPerGestion(Boolean perGestion) {
		this.perGestion = perGestion;
	}

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}

	
	
	
	
	
	

}
