package lu.ethoswarrior.bandwarrior.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.ethoswarrior.bandwarrior.api.model.User;
import lu.ethoswarrior.bandwarrior.api.repository.UserRepository;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    public User updateUserProfile(Long userId, String name, String description) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Atualiza as informações do usuário
        user.setName(name);
        user.setDescription(description);

        return userRepository.save(user); // Salva as alterações
    }
    
    public User getUserProfile(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
