package com.fsd.stock.exchange.service;

import java.util.List;

import com.fsd.stock.exchange.common.Result;
import com.fsd.stock.exchange.model.Stockexchange;

public interface ExchangeService {
    
	public List<Stockexchange> getStockExchangesList();

    public Stockexchange findStockExchangeById(String id);

    public Result addStockExchange(Stockexchange stockExchange);

    public void edit(Stockexchange stockExchange);

}
