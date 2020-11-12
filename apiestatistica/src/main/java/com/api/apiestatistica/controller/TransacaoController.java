package com.api.apiestatistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.apiestatistica.model.Transacao;
import com.api.apiestatistica.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*")
public class TransacaoController {
	
	
	@Autowired
	private TransacaoService transactionService;

	@PostMapping
	public ResponseEntity<Transacao> criarTransacao(@Validated @RequestBody Transacao transacao) {
		
		if(transactionService.dataNoPassado(transacao) && transactionService.valorPositivo(transacao)) {
			transactionService.adiciocaTransacao(transacao);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
		
	}

	@DeleteMapping
	public ResponseEntity<Object> deletar() {
		transactionService.deletaTransacao();
		return ResponseEntity.noContent().build();
	}

}
