package lu.ethoswarrior.bandwarrior.api.model;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "createdon")
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "responsible")
    private User responsible;
}
