package br.com.api.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.projeto.model.Login;

public interface ILogin extends JpaRepository<Login, Long> {

	Login getById(int id);
	Login findByEmail(String email);
}
