package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{

	List<Stock> findByCode(String code);

	@Query("SELECT s from Stock s where st_code='FB' and st_date like '2019-09%'")
	List<Stock> findStockFBSep();

	List<Stock> findByCodeAndCloseGreaterThan(String string, double d);

	List<Stock> findTop3ByOrderByVolumeDesc();

	List<Stock> findTop3ByCodeOrderByClose(String string);
	



}
