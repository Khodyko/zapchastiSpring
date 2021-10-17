package by.mycloud.www.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name = "depo_list")
@Data
public class Depo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depo_id")
	private Integer id;

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,80}", message = "{valid.name}")
	@Column(name = "depo_name")
	private String name;

//	@ManyToMany
//	@JoinTable(name = "depo_parent_sector", joinColumns = @JoinColumn(name = "depo_id"), inverseJoinColumns = @JoinColumn(name = "id_sector"))
//	private List<Sector> sector;
//	
//	@ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="id_depo")
//    private DepoApplication depoApplication;

}
