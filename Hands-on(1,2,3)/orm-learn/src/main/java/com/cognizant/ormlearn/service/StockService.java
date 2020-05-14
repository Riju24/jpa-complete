package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Transactional
	public List<Stock> getStocks()
	{
		
		List<Stock> li = stockRepository.findAll();	
		
		return li;
	}
	
	@Transactional
	public List<Stock> getStocksFBSep()
	{
		List<Stock> li = stockRepository.findStockFBSep();
		return li;
	}

	@Transactional
	public List<Stock> getStockGT() {
		
		List<Stock> li = stockRepository.findByCodeAndCloseGreaterThan("GOOGL",1250);
		
		return li;
	}

	public List<Stock> getStockTopVolume() {
		
		List<Stock> li = stockRepository.findTop3ByOrderByVolumeDesc();
		
		
		return li;
	}

	public List<Stock> getStockTopNetflixPrice() {
		List<Stock> li = stockRepository.findTop3ByCodeOrderByClose("NFLX");
		
		return li;
	}

}
