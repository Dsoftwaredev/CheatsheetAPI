package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    @Getter
    @Setter
    private long id;
    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    private String email;
    }