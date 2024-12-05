package lu.ethoswarrior.bandwarrior.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.ethoswarrior.bandwarrior.api.model.User;
import lu.ethoswarrior.bandwarrior.api.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        // Busca o usuário pelo login (nome de usuário)
        User user = userRepository.findByLogin(username);
        
        // Verifica se a senha está correta (em um cenário real, use hash e salt)
        if (user != null && user.getPwd().equals(password)) {
            return user;
        }
        return null; // Retorna null se não encontrar ou senha incorreta
    }
}
