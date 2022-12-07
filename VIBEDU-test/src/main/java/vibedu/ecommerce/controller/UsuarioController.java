package vibedu.ecommerce.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vibedo.ecommerce.enums.RolName;
import vibedu.ecommerce.model.Rol;
import vibedu.ecommerce.model.Usuario;
import vibedu.ecommerce.services.RolService;
import vibedu.ecommerce.services.UserService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UserService userService;
	@Autowired
	RolService rolService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/registro")
	public String registroshow() {
		return "login/register";
		
	}
	//modelandview
	@PostMapping ("/registrar")
	public ModelAndView registrar(String username,
			String name,
			String last_name, 
			String mail, 
			String password)
	{
		
		ModelAndView mv = new ModelAndView();
		
		if(StringUtils.isBlank(username) ) {
			mv.setViewName("/registro");
			mv.addObject("error", "no puede estar vacio el username");
			return mv;

		}
		if(StringUtils.isBlank(name) ) {
			mv.setViewName("/registro");
			mv.addObject("error", "no puede estar vacio el name");
			return mv;

		}
		if(StringUtils.isBlank(last_name) ) {
			mv.setViewName("/registro");
			mv.addObject("error", "no puede estar vacio el last_name");
			return mv;

		}
		if(StringUtils.isBlank(mail) ) {
			mv.setViewName("/registro");
			mv.addObject("error", "no puede estar vacio el mail");
			return mv;

		}
		if(StringUtils.isBlank(password) ) {
			mv.setViewName("/registro");
			mv.addObject("error", "no puede estar vacio el password");
			return mv;
			
		}
		Usuario user = new Usuario();
		user.setUsername(username);
		user.setName(name);
		user.setLast_name(last_name);
		user.setMail(mail);
		user.setPassword(passwordEncoder.encode(password));
		//get para convertirlos a objeto
		Rol rolUser = rolService.getByRolName(RolName.ROLE_CLIENT).get();
		Set<Rol> roles = new HashSet<>();
		roles.add(rolUser);
		user.setRoles(roles);
		userService.save(user);
		mv.setViewName("login/login");
		mv.addObject("registroOK", "cuenta creada"+user.getName()+", puedes iniciar sesion ");
		return mv;
		
	}
}
