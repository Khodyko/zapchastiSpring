package by.mycloud.www.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

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
@Immutable
public class StandartSearchItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Integer idItem;
	
	@Column(name = "nnsap")
	private String nnSap;
	
	@Column(name = "nn")
	private String nn;
	
	@Column(name = "name")
	private String name;
	
	
	
	
	
}
