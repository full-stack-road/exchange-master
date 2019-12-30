package com.fsd.stock.exchange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.exchange.common.Result;
import com.fsd.stock.exchange.model.Stockexchange;
import com.fsd.stock.exchange.repository.ExchangeRepository;
import com.fsd.stock.exchange.service.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService{

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public List<Stockexchange> getStockExchangesList() {
        return exchangeRepository.findAll();
    }

    @Override
    public Stockexchange findStockExchangeById(String id) {
        return exchangeRepository.findByStockExchangesId(id);
    }

    @Override
    public Result addStockExchange(Stockexchange stockExchange) {
		try {
	    	exchangeRepository.save(stockExchange);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
    }
    
    @Override
    public void edit(Stockexchange stockExchange) {
    	exchangeRepository.save(stockExchange);
    }
}
