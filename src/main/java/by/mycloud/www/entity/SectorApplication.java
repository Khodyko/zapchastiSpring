package by.mycloud.www.entity;

import java.sql.Timestamp;

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

import lombok.Data;

@Entity
@Table(name = "sector_appliction")
@Data
public class SectorApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sector_application")
	private Integer id;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_item")
	private Item item;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//manytomany?
	@JoinColumn(name="id_sector")
	private Sector sector;
	
	@NotNull(message = "{message.is.required}")
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_parent_depo", referencedColumnName = "depo_id")
	//manytomany?
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
	@Column(name="sector_num")
	//validate
	private Double sectorNum;
}
