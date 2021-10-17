package by.mycloud.www.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer idUser;
	
	@NotNull(message = "{message.is.required}")
	//change pattern
	@Pattern(regexp = "(.){1,20}", message = "{valid.name}")
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "{message.is.required}")
	//change pattern
	@Pattern(regexp = "(.){1,20}", message = "{valid.name}")
	@Column(name = "surname")
	private String surname;
	
	@NotNull(message = "{message.is.required}")
	//change pattern
	@Pattern(regexp = "(.){1,70}", message = "{valid.name}")
	@Column(name = "password")
	private String password;
	
	
	@NotNull(message = "{message.is.required}")
	//change pattern
	@Pattern(regexp = "(.){1,20}", message = "{valid.name}")
	@Column(name = "role")
	private String role;
	
	@NotNull(message = "{message.is.required}")
	//change pattern
	@Pattern(regexp = "(.){1,30}", message = "{valid.name}")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne (optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_sector")
	private Sector idSector;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne (optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_depo")
	private Depo idDepo;
	
	@NotNull(message = "{message.is.required}")
	@Column(name = "agreed")
	private Boolean agreed;
	
}
