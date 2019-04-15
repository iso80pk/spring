package pl.softsystem.wyklad1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserModel {

    public UserModel() {
    }

    private String name;
    private String login;


}
