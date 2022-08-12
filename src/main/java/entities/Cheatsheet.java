package entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="cheatsheet")
public class Cheatsheet {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name="code_language")
	private String codeLanguage;
	@Column(name="cheat_method")
	private String cheatMethod;
	@Column(name="cheat_body")
	private String cheatBody;
	
}
