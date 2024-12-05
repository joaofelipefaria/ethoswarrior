package lu.ethoswarrior.bandwarrior.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lu.ethoswarrior.bandwarrior.api.model.Band;
import lu.ethoswarrior.bandwarrior.api.model.BandMember;
import lu.ethoswarrior.bandwarrior.api.model.BandMemberId;

public interface BandMemberRepository extends JpaRepository<BandMember, BandMemberId> {

	@Query("SELECT bm.id.band FROM BandMember bm WHERE bm.id.user.id = :userId")
    List<Band> findBandsByUserId(Long userId);
}