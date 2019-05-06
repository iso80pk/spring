package pl.softsystem.wyklad1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_model")

public class UserModel {

    public UserModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;


}
