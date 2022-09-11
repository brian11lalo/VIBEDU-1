package vibedu.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vibedu.ecommerce.model.User;
@Repository
public interface IUsuario extends JpaRepository<User, Integer> {
	User  findByUsername(String name);
	boolean existsByUsername(String name);
}
