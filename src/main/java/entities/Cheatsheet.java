package entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cheatsheet")
public class Cheatsheet {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="code_language")
	private String codeLanguage;
	@Column(name="cheat_method")
	private String cheatMethod;
	@Column(name="cheat_body")
	private String cheatBody;


}

