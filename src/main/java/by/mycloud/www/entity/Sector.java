package by.mycloud.www.entity;

import java.util.List;

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

import lombok.Data;

@Entity
@Table(name = "sector_list")
@Data
public class Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sector")
	private Integer id;

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,50}", message = "{valid.name}")
	@Column(name = "name_sector")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "depo_parent_sector", joinColumns = @JoinColumn(name = "id_sector"), inverseJoinColumns = @JoinColumn(name = "depo_id"))
	private List<Sector> sector;
}
