package lu.ethoswarrior.bandwarrior.api.model;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "band_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String pwd;
    private String name;
    private String description;

    @Column(name = "firstlogin")
    private boolean firstLogin;

    @Column(name = "createdon")
    private LocalDateTime createdOn;

    private boolean active;
}
