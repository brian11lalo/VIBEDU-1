package vibedu.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vibedo.ecommerce.enums.RolName;
import vibedu.ecommerce.model.Rol;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
	Rol  findByRolName(RolName rolName);
	boolean existsByRolName(RolName rolName);
}
