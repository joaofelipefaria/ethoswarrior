package lu.ethoswarrior.bandwarrior.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lu.ethoswarrior.bandwarrior.api.model.BandRequest;
import lu.ethoswarrior.bandwarrior.api.model.BandRequestId;

public interface BandRequestRepository extends JpaRepository<BandRequest, BandRequestId> {
    // Consultas personalizadas para BandRequest
}