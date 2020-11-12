package com.api.apiestatistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiestatistica.model.Estatisca;
import com.api.apiestatistica.model.Transacao;
import com.api.apiestatistica.service.EstatisticaService;
import com.api.apiestatistica.service.TransacaoService;

@RestController
@RequestMapping("/estatistica")
@CrossOrigin(origins = "*")
public class EstatisticaController {

	@Autowired
	private EstatisticaService estatisticaService;
	
	@Autowired
	private TransacaoService transacaoService;
	
	@GetMapping()
	public ResponseEntity<Estatisca> getEstatistica() {
		List<Transacao> transacao= transacaoService.getAll();
		transacao = estatisticaService.getUltimoMinuto(transacao);
		return ResponseEntity.ok(estatisticaService.statsCreate(transacao));
	}

}
