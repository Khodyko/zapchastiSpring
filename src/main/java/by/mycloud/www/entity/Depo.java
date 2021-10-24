package by.mycloud.www.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "depo_list")
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Depo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_depo")
	private Integer id;

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,80}", message = "{valid.name}")
	@Column(name = "depo_name")
	private String name;

	
	@ManyToMany 
	@JoinTable(name = "depo_parent_sector", joinColumns = {@JoinColumn(name = "id_depo")}, inverseJoinColumns = {@JoinColumn(name = "id_sector")})
	List<Sector> sectors=new ArrayList<Sector>();
	
//	@ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="id_depo")
//    private DepoApplication depoApplication;

}
