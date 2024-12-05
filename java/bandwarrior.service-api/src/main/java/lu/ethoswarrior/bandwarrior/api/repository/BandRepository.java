package lu.ethoswarrior.bandwarrior.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lu.ethoswarrior.bandwarrior.api.model.Band;

public interface BandRepository extends JpaRepository<Band, Long> {
    // Consultas personalizadas para Band
}