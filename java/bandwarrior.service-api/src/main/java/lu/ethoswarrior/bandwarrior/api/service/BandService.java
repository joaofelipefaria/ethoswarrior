package lu.ethoswarrior.bandwarrior.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.ethoswarrior.bandwarrior.api.model.Band;
import lu.ethoswarrior.bandwarrior.api.model.User;
import lu.ethoswarrior.bandwarrior.api.repository.BandMemberRepository;
import lu.ethoswarrior.bandwarrior.api.repository.BandRepository;
import lu.ethoswarrior.bandwarrior.api.repository.UserRepository;

@Service
public class BandService {

	@Autowired
	private BandMemberRepository bandMemberRepository;

	@Autowired
	private BandRepository bandRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Band> pesquisaBandasUsuario(Long userId) {
		// Busca todas as bandas em que o usuário é membro
		return bandMemberRepository.findBandsByUserId(userId);
	}

	public Band createBand(Long userId, String name, String description) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		// Cria uma nova banda com o usuário como responsável
		Band band = new Band();
		band.setName(name);
		band.setDescription(description);
		band.setCreatedOn(LocalDateTime.now());
		band.setResponsible(user);

		return bandRepository.save(band);
	}
	
	public Band updateBand(Long bandId, String name, String description) {
	    Band band = bandRepository.findById(bandId).orElseThrow(() -> new RuntimeException("Banda não encontrada"));

	    band.setName(name);
	    band.setDescription(description);

	    return bandRepository.save(band);
	}
	
	public void deleteBand(Long bandId) {
	    Band band = bandRepository.findById(bandId).orElseThrow(() -> new RuntimeException("Banda não encontrada"));

	    bandRepository.delete(band);
	}
	
	public Band bandDetails(Long bandId) {
	    return bandRepository.findById(bandId).orElseThrow(() -> new RuntimeException("Banda não encontrada"));
	}
	
	public List<Band> searchBands() {
	    return bandRepository.findAll();
	}
}
