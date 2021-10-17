package by.mycloud.www.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import lombok.Data;

@Entity
@Table(name = "depo_appliction")
@Data
public class DepoApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_depo_application")
	private Integer id;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_item")
	private Item item;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_depo", referencedColumnName = "depo_id")
	private Depo depo;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_year")
	private YearOfApplication yearOfApplication;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_user")
	private User user;
	
	@NotNull(message = "{message.is.required}")
	@Column(name="date")
	private Timestamp date;
	
	@NotNull(message = "{message.is.required}")
	@Column(name="depo_num")
	//validate
	private Double depoNum;
} 
