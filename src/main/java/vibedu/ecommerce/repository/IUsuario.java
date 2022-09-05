package vibedu.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vibedu.ecommerce.model.User;

public interface IUsuario extends JpaRepository<User, Integer> {
	User  findByUsername(String name);
}
