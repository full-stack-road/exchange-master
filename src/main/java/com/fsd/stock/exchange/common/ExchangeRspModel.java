package com.fsd.stock.exchange.common;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fsd.stock.exchange.model.Stockexchange;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Sector action model")
public class ExchangeRspModel {
	
	@ApiModelProperty(notes = "code", example = "200", required = true, dataType = "java.lang.Integer")
	@NotNull
	private Integer code;
	
	@ApiModelProperty(notes = "message", example = "Created", required = true, dataType = "java.lang.String")
	@NotNull
	private String message;
	
	@ApiModelProperty(notes = "data", required = true, dataType = "java.lang.Object")
	private List<Stockexchange> data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Stockexchange> getData() {
		return data;
	}

	public void setData(List<Stockexchange> data) {
		this.data = data;
	}
	
	

}