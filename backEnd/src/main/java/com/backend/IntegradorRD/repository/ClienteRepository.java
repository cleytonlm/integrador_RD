package com.backend.IntegradorRD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.IntegradorRD.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/**
	 * Encontra um Cliente a partir do seu Nome. Retorna uma lista pois podem
	 * existir mais de um Cliente com mesmo nome.
	 * 
	 * @param nome
	 * @return lista de Clientes
	 */
	List<Cliente> findByNome(String nome);
}
