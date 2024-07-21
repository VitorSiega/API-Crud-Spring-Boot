package br.com.api.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.projeto.model.Login;
import br.com.api.projeto.repository.ILogin;

@Service
public class LoginService {
	
	@Autowired
	private ILogin ilogin;
	
	public Login salvarPessoa(Login login) {
		return ilogin.save(login);
	}
	
	public List<Login> listarLogins(){
		return ilogin.findAll();
	}
}
