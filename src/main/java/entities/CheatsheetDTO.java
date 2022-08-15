package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class CheatsheetDTO {
    @Getter
    @Setter
    private long id;
    @Setter
    @Getter
    private String codeLanguage;
    @Getter
    @Setter
    private String cheatMethod;
    @Getter
    @Setter
    private String cheatBody;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheatsheetDTO that = (CheatsheetDTO) o;
        return id == that.id && Objects.equals(codeLanguage, that.codeLanguage) && Objects.equals(cheatMethod, that.cheatMethod) && Objects.equals(cheatBody, that.cheatBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeLanguage, cheatMethod, cheatBody);
    }

    @Override
    public String toString() {
        return "CheatsheetDTO{" +
                "id=" + id +
                ", codeLanguage='" + codeLanguage + '\'' +
                ", cheatMethod='" + cheatMethod + '\'' +
                ", cheatBody='" + cheatBody + '\'' +
                '}';
    }
}
