package kiskadee.dreambillboard.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kiskadee.dreambillboard.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByTwitterUser(String twitterUser);
	
}
