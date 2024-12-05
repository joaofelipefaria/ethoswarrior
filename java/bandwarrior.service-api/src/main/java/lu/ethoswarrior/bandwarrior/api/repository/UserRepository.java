package lu.ethoswarrior.bandwarrior.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lu.ethoswarrior.bandwarrior.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String username);
}