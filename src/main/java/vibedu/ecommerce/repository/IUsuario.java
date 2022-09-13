package vibedu.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vibedu.ecommerce.model.Usuario;
@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {
	Usuario  findByUsername(String name);
	boolean existsByUsername(String name);
}
