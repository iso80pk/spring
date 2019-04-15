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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_model_id_seq")
    @SequenceGenerator(name = "user_model_id_seq", sequenceName = "user_model_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String login;


}
