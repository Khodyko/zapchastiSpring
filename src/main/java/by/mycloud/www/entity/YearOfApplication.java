package by.mycloud.www.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "year")
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class YearOfApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_year")
	private Integer idYear;

	@NotNull(message = "{message.is.required}")
	@Pattern(regexp = "(.){1,20}", message = "{valid.nnsap}")
	@Column(name = "year")
	private String year;

	@Column(name = "is_open_for_change")
	private Boolean isOpenForChange;

}
