package by.mycloud.www.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Data
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private int id;

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
	@Column(name = "name")
	private String units;
	
	@Column(name = "img_links_id")
	private int idImg;
	
	@Column(name = "locomotive_seria_id")
	private int locomotive_seria;
	
	@Column(name = "item_parent")
	private String itemParent;
	
	@Column(name = "supplier")
	private String supplierName;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "user_id_last_change")
	private int user_id_last_change;
	
	@Column(name = "last_change_time")
	private Timestamp timeLastChange;
	
	@Column(name = "cost")
	private Double cost;
	

}
