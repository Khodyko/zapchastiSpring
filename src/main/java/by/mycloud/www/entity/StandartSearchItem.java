package by.mycloud.www.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StandartSearchItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idItem;
	private String nnSap;
	private String nn;
	private String name;
	
	public StandartSearchItem(Integer idItem, String nnSap, String nn, String name) {
		super();
		this.idItem = idItem;
		this.nnSap = nnSap;
		this.nn = nn;
		this.name = name;
	}
	
	
}
