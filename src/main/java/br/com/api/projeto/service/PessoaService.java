package br.com.api.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.projeto.model.Pessoa;
import br.com.api.projeto.repository.IPessoa;

@Service
public class PessoaService {
	
	@Autowired
	private IPessoa ipessoa;
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return ipessoa.save(pessoa);
	}
	
}
