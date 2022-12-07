package vibedu.ecommerce;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import vibedu.ecommerce.model.Usuario;
import vibedu.ecommerce.repository.IUsuario;
@RunWith(SpringRunner.class)
@SpringBootTest
class VibeduApplicationTests {
	@Autowired
	private IUsuario Prueba;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	Date date = new Date();
	
	Timestamp time = new Timestamp(date.getTime());
	@Test
	public void crearUsuarioTest() {
		Usuario user = new Usuario();
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
		Usuario retorno = Prueba.save(user);
		assertTrue(retorno.getPassword().equalsIgnoreCase(user.getPassword()));
		
	}
	
//	void contextLoads() {
//	}

}
