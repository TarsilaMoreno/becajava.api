package br.api.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.api.locadora.model.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
