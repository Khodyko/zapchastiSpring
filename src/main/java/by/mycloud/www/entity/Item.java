package by.mycloud.www.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Integer id;

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,30}", message = "{valid.nnsap}")
	@Column(name = "nnsap")
	private String nnSap;
	
	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,30}", message = "{valid.nn}")
	@Column(name = "nn")
	private String nn;
	
	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,50}", message = "{valid.name}")
	@Column(name = "name")
	private String name;
	

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,20}", message = "{valid.name}")
	@Column(name = "units")
	private String units;
	
	@Column(name = "img_links_id")
	private Integer idImg;
	
	@Column(name = "locomotive_seria_id")
	private Integer locomotive_seria_id;
	
	@Column(name = "item_parent")
	private String itemParent;
	
	@Column(name = "supplier")
	private String supplierName;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "user_id_last_change")
	private Integer user_id_last_change;
	
	@Column(name = "last_change_time")
	private Timestamp timeLastChange;
	
	@Column(name = "cost")
	private Double cost;
	
	
	
	

}
