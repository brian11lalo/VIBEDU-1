package vibedu.ecommerce.config;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vibedo.ecommerce.enums.RolName;
import vibedu.ecommerce.model.Rol;
import vibedu.ecommerce.model.Usuario;
import vibedu.ecommerce.repository.IUsuario;
import vibedu.ecommerce.services.RolService;
import vibedu.ecommerce.services.UserService;

@Service
public class CreateUser implements CommandLineRunner {
@Autowired
UserService userservice;
@Autowired
private IUsuario Prueba;
@Autowired
private BCryptPasswordEncoder encoder;
@Autowired
RolService rolService;

Date date = new Date();

Timestamp time = new Timestamp(date.getTime());
@Override
public void run(String... args) throws Exception {
/*	Usuario user = new Usuario();	
user.setId(1);
user.setUsername("alberto23121");
user.setPassword(encoder.encode("1234"));
user.setMail("albertoojeda44@aragon.unam.mx");
user.setName("Alberto");
user.setLast_name("ojeda");
user.setUpdated_by(3);
user.setActive(true);
user.setCreated_at(time);
user.setUpdated_at(time);
Rol rolAdmin = rolService.getByRolName(RolName.ROLE_ADMIN).get();
Rol rolClient= rolService.getByRolName(RolName.ROLE_CLIENT).get();
Set <Rol> roles= new HashSet<>();
roles.add(rolAdmin);
roles.add(rolClient);
user.setRoles(roles);
userservice.save(user);*/
	}
}
