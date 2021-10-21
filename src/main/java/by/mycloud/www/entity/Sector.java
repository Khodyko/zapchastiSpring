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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sector_list")
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sector")
	private Integer id;

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,50}", message = "{valid.name}")
	@Column(name = "name_sector")
	private String name;
	
	@ToString.Exclude
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "depo_parent_sector", joinColumns = {@JoinColumn(name = "id_sector")}, inverseJoinColumns = {@JoinColumn(name = "id_depo")})
	Set<Depo> depos=new HashSet<Depo>();
	}
