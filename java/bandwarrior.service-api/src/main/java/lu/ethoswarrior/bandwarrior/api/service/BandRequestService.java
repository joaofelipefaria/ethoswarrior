package lu.ethoswarrior.bandwarrior.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.ethoswarrior.bandwarrior.api.model.Band;
import lu.ethoswarrior.bandwarrior.api.model.BandRequest;
import lu.ethoswarrior.bandwarrior.api.model.BandRequestId;
import lu.ethoswarrior.bandwarrior.api.model.User;
import lu.ethoswarrior.bandwarrior.api.repository.BandRepository;
import lu.ethoswarrior.bandwarrior.api.repository.BandRequestRepository;
import lu.ethoswarrior.bandwarrior.api.repository.UserRepository;

@Service
public class BandRequestService {

    @Autowired
    private BandRequestRepository bandRequestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BandRepository bandRepository;

    public BandRequest solicitarEntrarBanda(Long userId, Long bandId, String message) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Band band = bandRepository.findById(bandId).orElseThrow(() -> new RuntimeException("Banda não encontrada"));

        BandRequest request = new BandRequest();
        BandRequestId id = new BandRequestId();
        id.setUser(user);
        id.setBand(band);
        request.setId(id);
        request.setMessage(message);

        return bandRequestRepository.save(request);
    }
    
    public void aceitarRequisicao(Long userId, Long bandId) {
        BandRequestId bandRequestId = new BandRequestId();
        bandRequestId.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        bandRequestId.setBand(bandRepository.findById(bandId).orElseThrow(() -> new RuntimeException("Banda não encontrada")));

        BandRequest bandRequest = bandRequestRepository.findById(bandRequestId)
                .orElseThrow(() -> new RuntimeException("Requisição não encontrada"));

        // Aqui você pode adicionar o usuário à banda ou qualquer outra lógica de aceitação

        bandRequestRepository.delete(bandRequest); // Remove a solicitação depois de aceita
    }
    
    public void rejeitarRequisicao(Long userId, Long bandId) {
        BandRequestId bandRequestId = new BandRequestId();
        bandRequestId.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        bandRequestId.setBand(bandRepository.findById(bandId).orElseThrow(() -> new RuntimeException("Banda não encontrada")));

        BandRequest bandRequest = bandRequestRepository.findById(bandRequestId)
                .orElseThrow(() -> new RuntimeException("Requisição não encontrada"));

        bandRequestRepository.delete(bandRequest); // Remove a solicitação depois de rejeitada
    }
}
