package by.mycloud.www.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;


@Entity
@Table(name = "item")
@Data
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
	
	public StandartSearchItem(Integer idItem, String nnSap, String nn, String name) {
		super();
		this.idItem = idItem;
		this.nnSap = nnSap;
		this.nn = nn;
		this.name = name;
	}

	public StandartSearchItem() {
	
	}
	
	
	
}
