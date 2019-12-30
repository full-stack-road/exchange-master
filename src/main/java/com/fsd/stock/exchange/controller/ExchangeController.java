package com.fsd.stock.exchange.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.exchange.common.Result;
import com.fsd.stock.exchange.common.ExchangeRspModel;
import com.fsd.stock.exchange.model.Stockexchange;
import com.fsd.stock.exchange.service.ExchangeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(description = "Exchange Interface")
public class ExchangeController {
	@Autowired
	private ExchangeService exchangeSrc;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "exchange-add")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), @ApiResponse(code = 400, message = "error request"),
			@ApiResponse(code = 401, message = "no authorize"), @ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<ExchangeRspModel> addExchange(@ApiParam(name = "body", required = true) @RequestBody Stockexchange sector) {
		ExchangeRspModel rsp = new ExchangeRspModel();
		try {
			Stockexchange checkexchange = exchangeSrc.findStockExchangeById(sector.getStockExchangesId());
			if (checkexchange == null) {
				Result rs = exchangeSrc.addStockExchange(sector);
				if (rs.get("code").equals(200)) {
					rsp.setCode(200);
					rsp.setMessage("exchange " + sector.getStockExchangesId() + " was created");
					return new ResponseEntity<ExchangeRspModel>(rsp, HttpStatus.OK);
				} else {
					rsp.setCode(400);
					rsp.setMessage("exchange added fail");
					return new ResponseEntity<ExchangeRspModel>(rsp, HttpStatus.OK);
				}
			} else {
				rsp.setCode(400);
				rsp.setMessage("exchange already exist");
				return new ResponseEntity<ExchangeRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<ExchangeRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
		
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "exchange-list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), @ApiResponse(code = 400, message = "error request"),
			@ApiResponse(code = 401, message = "no authorize"), @ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<ExchangeRspModel> listExchanges(){
		ExchangeRspModel rsp = new ExchangeRspModel();
		List<Stockexchange> stockExchanges= exchangeSrc.getStockExchangesList();
		rsp.setCode(200);
		rsp.setMessage("success");
		rsp.setData(stockExchanges);
		return new ResponseEntity<ExchangeRspModel>(rsp, HttpStatus.OK);
	}
}