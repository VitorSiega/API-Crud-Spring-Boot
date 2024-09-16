package br.com.api.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.projeto.model.Login;
import br.com.api.projeto.repository.ILogin;

@Service
public class LoginService {
	
	@Autowired
	private ILogin ilogin;
	
	private PasswordEncoder passwordEncoder;
	
	public LoginService(ILogin ilogin) {
		this.ilogin = ilogin;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public Login salvarPessoa(Login login) {
		String encoder = this.passwordEncoder.encode(login.getSenha());
		login.setSenha(encoder);
		return ilogin.save(login);
	}
	
	public Login editarLogin(Login login) {
		String encoder = this.passwordEncoder.encode(login.getSenha());
		login.setSenha(encoder);
		return ilogin.save(login);
	}
	
	public List<Login> listarLogins(){
		return ilogin.findAll();
	}

	public Boolean validarSenha(Login login) {
		String senha = ilogin.getById(login.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(login.getSenha(), senha);
		return valid;
	}
	
	public Boolean validarLogin(String entrada, String senhaDig) {
        Login login = ilogin.findByEmail(entrada);
        
        if (login == null) {
            return false; // Retorna false se o login não for encontrado
        }
        
        boolean valid = passwordEncoder.matches(senhaDig, login.getSenha());
        return valid;
    }

}
