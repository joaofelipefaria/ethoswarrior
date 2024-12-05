package lu.ethoswarrior.bandwarrior.api.model;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class BandRequestId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "id_band")
    private Band band;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
