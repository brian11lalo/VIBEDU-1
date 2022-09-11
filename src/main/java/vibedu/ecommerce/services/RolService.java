package vibedu.ecommerce.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vibedo.ecommerce.enums.RolName;
import vibedu.ecommerce.model.Rol;
import vibedu.ecommerce.repository.IRolRepository;

@Service
@Transactional
public class RolService {
@Autowired
IRolRepository rolRepository;
 public void save(Rol rol) {
	 rolRepository.save(rol);
 }
 public Optional<Rol> getByRolName(RolName rolName){
	return Optional.ofNullable(rolRepository.findByRolName(rolName));
	 
 }
 public boolean existsByRolName(RolName rolName) {
 	return rolRepository.existsByRolName(rolName);
 			}
}
