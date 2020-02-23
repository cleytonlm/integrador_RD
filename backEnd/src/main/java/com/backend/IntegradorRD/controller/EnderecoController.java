package com.backend.IntegradorRD.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.IntegradorRD.model.Endereco;
import com.backend.IntegradorRD.model.Pedido;
import com.backend.IntegradorRD.repository.EnderecoRepository;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoController {
	
	EnderecoRepository repository;
	
	public EnderecoController(EnderecoRepository enderecoRepository) {
		this.repository = enderecoRepository;
	}
	
	@GetMapping(value="/cadastrarendereco")
	   public String cadastrarEndereco() {
		   
		   
		   return "cadastrarEndereco";
	   }
	   
	   @GetMapping
	   public List findAll(){
	      return repository.findAll();
	   }
	   
	   @GetMapping(path = {"/{id}"})
	   public ResponseEntity findById(@PathVariable long id){
	      return repository.findById(id)
	              .map(record -> ResponseEntity.ok().body(record))
	              .orElse(ResponseEntity.notFound().build());
	   }
	   
	   @PostMapping
	   public Endereco create(@RequestBody Endereco endereco){
	      return repository.save(endereco);
	   }
	   
	   @PutMapping(value="/{id}")
	   public ResponseEntity update(@PathVariable("id") long id,
	                                         @RequestBody Endereco endereco) {
	      return repository.findById(id)
	              .map(record -> {
	                  record.setEstado(endereco.getEstado());
	                  record.setCidade(endereco.getCidade());
	                  record.setCep(endereco.getCep());
	                  record.setBairro(endereco.getBairro());
	                  record.setRuaAv(endereco.getRuaAv());
	                  record.setNumero(endereco.getNumero());
	                  record.setComplemento(endereco.getComplemento());
	                  Endereco updated = repository.save(record);
	                  return ResponseEntity.ok().body(updated);
	              }).orElse(ResponseEntity.notFound().build());
	   }
	   
	   @DeleteMapping(path ={"/{id}"})
	   public ResponseEntity<?> delete(@PathVariable long id) {
	      return repository.findById(id)
	              .map(record -> {
	                  repository.deleteById(id);
	                  return ResponseEntity.ok().build();
	              }).orElse(ResponseEntity.notFound().build());
	   }

}
