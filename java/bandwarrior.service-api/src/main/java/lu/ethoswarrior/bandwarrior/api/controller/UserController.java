package lu.ethoswarrior.bandwarrior.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lu.ethoswarrior.bandwarrior.api.model.User;
import lu.ethoswarrior.bandwarrior.api.service.LoginService;
import lu.ethoswarrior.bandwarrior.api.service.UserProfileService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserProfileService userService;

    @Autowired
    private LoginService loginService;

    // Endpoint para login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
    	String login = user.getLogin();
    	String password = user.getPwd();
        return loginService.login(login, password);
    }

    // Endpoint para editar perfil do usuário
    @PutMapping("/edit")
    public User editUserProfile(@RequestBody User user) {
        return userService.updateUserProfile(user.getId(), user.getName(), user.getDescription());
    }

    // Endpoint para pesquisar perfil do usuário
    @GetMapping("/{userId}")
    public User getUserProfile(@PathVariable Long userId) {
        return userService.getUserProfile(userId);
    }

    // Endpoint para pesquisar bandas do usuário
    /*
    @GetMapping("/{userId}/bands")
    public List<Band> getUserBands(@PathVariable Long userId) {
        return userService.getUserBands(userId);
    }*/
}
