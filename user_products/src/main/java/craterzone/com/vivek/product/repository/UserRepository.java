package craterzone.com.vivek.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import craterzone.com.vivek.product.dao.UserDao;
import craterzone.com.vivek.product.model.User;


public interface UserRepository extends JpaRepository<UserDao, Long> { 
	
	Optional<UserDao> findByEmail(String name);
	Optional<UserDao> findById(Long id);
	

	
}

