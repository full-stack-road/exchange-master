package com.fsd.stock.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.exchange.model.Stockexchange;

public interface ExchangeRepository extends JpaRepository<Stockexchange, String> {
	Stockexchange findByStockExchangesId(String stockExchangesId);

}
