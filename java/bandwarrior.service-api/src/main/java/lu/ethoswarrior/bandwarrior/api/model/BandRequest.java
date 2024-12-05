package lu.ethoswarrior.bandwarrior.api.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class BandRequest {

    @EmbeddedId
    private BandRequestId id;

    private String message;
}
