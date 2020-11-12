package com.api.apiestatistica.ut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.apiestatistica.model.Transacao;
import com.api.apiestatistica.service.EstatisticaService;
import com.api.apiestatistica.service.TransacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiestatisticaTestsUnitarios {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private EstatisticaService estatisticaService;
	
	@Test
	public void transacaoNotNullTransactionService() {
		assertNotNull(transacaoService);
	}
	
	@Test
	public void estatisticaNotNullTransactionService() {
		assertNotNull(estatisticaService);
	}
	
	@Test
	public void testCriacaoTransacao() throws Exception {

		Transacao transacao1 = new Transacao();
		Random random = new Random(); 

		LocalDateTime agora = LocalDateTime.now();		
		BigDecimal valor = new BigDecimal(random.nextDouble()*100);
		
		transacao1.setDataHora(agora);
		transacao1.setValor(valor);
		
		transacaoService.adiciocaTransacao(transacao1);
		
		assertNotNull(transacao1);
		assertEquals(agora, transacao1.getDataHora());
		assertEquals(valor, transacao1.getValor());

	}
	
	@Test
	public void testaPassado() throws Exception {
		Transacao transacao2 = new Transacao();
		Random random = new Random(); 

		LocalDateTime agora = LocalDateTime.now();		
		BigDecimal valor = new BigDecimal(random.nextDouble()*100);
		
		transacao2.setDataHora(agora);
		transacao2.setValor(valor);
		
		transacaoService.adiciocaTransacao(transacao2);
		
		assertTrue(transacaoService.dataNoPassado(transacao2));
	}
	
	@Test
	public void testaPositivo() throws Exception {
		Transacao transacao3 = new Transacao();
		Random random = new Random(); 

		LocalDateTime agora = LocalDateTime.now();		
		BigDecimal valor = new BigDecimal(random.nextDouble()*100);
		
		transacao3.setDataHora(agora);
		transacao3.setValor(valor);
		
		transacaoService.adiciocaTransacao(transacao3);
		
		assertTrue(transacaoService.valorPositivo(transacao3));
	}
	
}
