package com.api.apiestatistica.service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.api.apiestatistica.model.Transacao;

@Service
public class TransacaoService {
	
	public List<Transacao> transacaoList = new ArrayList<Transacao>();

	public boolean dataNoPassado(Transacao transacao) {
		return transacao.getDataHora().isBefore(LocalDateTime.now());
	}
	
	public boolean valorPositivo(Transacao transacao) {
		return 	(transacao.getValor().compareTo(BigDecimal.ZERO) >= 0) ? true : false;
	}
	
	public void adiciocaTransacao(Transacao transacao) {
		transacaoList.add(transacao);
	}

	public void deletaTransacao() {
		transacaoList.clear();
	}
	
	public List<Transacao> getAll() {
		return transacaoList;
	}

}
