package com.backend.IntegradorRD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.IntegradorRD.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	 
}

