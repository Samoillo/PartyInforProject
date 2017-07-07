package pl.PartyInfor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.PartyInfor.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

	@Query("SELECT u FROM User u WHERE u.id = ?1")
	User findById(Long userId);

	
}
