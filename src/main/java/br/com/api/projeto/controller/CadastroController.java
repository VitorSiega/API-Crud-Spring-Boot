package br.com.api.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projeto.model.Login;
import br.com.api.projeto.model.Pessoa;
import br.com.api.projeto.service.LoginService;
import br.com.api.projeto.service.PessoaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CadastroController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private LoginService loginService;
	
	public CadastroController(LoginService loginService, PessoaService pessoaService) {
		this.loginService = loginService;
		this.pessoaService = pessoaService;
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<Login> cadastrarLogin(@RequestBody Login login) {
	    Pessoa pessoa = pessoaService.salvarPessoa(login);
	    login.setId(pessoa.getId());
	    loginService.salvarPessoa(login);
	    return ResponseEntity.status(201).body(null);
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Login>> listarUsuarios(){
		return ResponseEntity.status(200).body(loginService.listarLogins());
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Login> editarLogin(@RequestBody Login login){
		loginService.editarLogin(login);
		return ResponseEntity.status(200).body(null);
	}
}
