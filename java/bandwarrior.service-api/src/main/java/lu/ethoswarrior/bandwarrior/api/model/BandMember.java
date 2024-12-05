package lu.ethoswarrior.bandwarrior.api.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class BandMember {

    @EmbeddedId
    private BandMemberId id;

    private String description;
}
