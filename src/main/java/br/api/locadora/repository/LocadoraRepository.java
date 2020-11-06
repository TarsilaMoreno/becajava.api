package br.api.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.api.locadora.model.Locadora;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long> {

}
