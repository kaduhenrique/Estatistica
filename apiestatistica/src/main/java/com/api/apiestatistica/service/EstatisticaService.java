package com.api.apiestatistica.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.apiestatistica.model.Estatisca;
import com.api.apiestatistica.model.Transacao;

@Service
public class EstatisticaService {
	
	public List<Transacao> getUltimoMinuto(List<Transacao> transacao) {
		return transacao.stream().filter(t -> Duration.between(t.getDataHora(), LocalDateTime.now()).toMillis() <= 60000).collect(Collectors.toList());
	}
	
	public Estatisca statsCreate(List<Transacao> transactions) {
		
		Estatisca estats = new Estatisca();
		estats.setCount(transactions.stream().count());
		estats.setAvg(BigDecimal.valueOf(transactions.stream().mapToDouble(t -> t.getValor().doubleValue()).average().orElse(0.0)));
		estats.setMin(BigDecimal.valueOf(transactions.stream().mapToDouble(t -> t.getValor().doubleValue()).min().orElse(0.0)));
		estats.setMax(BigDecimal.valueOf(transactions.stream().mapToDouble(t -> t.getValor().doubleValue()).max().orElse(0.0)));
		estats.setSum(BigDecimal.valueOf(transactions.stream().mapToDouble(t -> t.getValor().doubleValue()).sum()));
		
		return estats;
	}

	
}
