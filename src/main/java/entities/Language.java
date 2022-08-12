package entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class Language {

	@Id
	@GeneratedValue
	private long id;
	
	private String codeLanguage;
	
	private String cheatMethod;
	
	private String cheatBody;
	
}
