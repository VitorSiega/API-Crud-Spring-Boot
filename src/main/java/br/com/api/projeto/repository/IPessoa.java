package br.com.api.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.projeto.model.Pessoa;

public interface IPessoa extends JpaRepository<Pessoa, Long> {

}
