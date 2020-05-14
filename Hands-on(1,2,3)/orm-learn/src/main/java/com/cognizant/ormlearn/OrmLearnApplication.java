package com.cognizant.ormlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.Exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {

	
	private static CountryService countryService;
	private static StockService stockService;
	
	private static StockRepository stockRepository;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	 @Autowired
	 public void setStockRepository(StockRepository stockRepository) {
	       this.stockRepository = stockRepository;
	    }
	
	
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		stockService = context.getBean(StockService.class);
		employeeService=context.getBean(EmployeeService.class);;
		departmentService=context.getBean(DepartmentService.class);;
		skillService=context.getBean(SkillService.class);
		
		
		LOGGER.info("Inside main");
		
	//	testGetAllCountries();
	//	getAllCountriesTest();
	//	addCountryTest();
	//	updateCountryTest();
	//	findCountrytest();
	//	findCountryStartsWithtest();
		
		
	//	getStockFBSeptest();
	//	getStockGreatertest();
	//	getTopVolumetest();
	//	getTopNetflixPricetest();
		
		
	//	getStockFBSeptembertest();
	//	getStockGreaterThantest();
	//	getTop3Volumetest();
	//	getTop3NetflixPricetest()
		
	//	testGetEmployee();
	//	testAddEmployee();
	//	testUpdateEmployee();
		
	//	testGetDepartment();
	//	testAddSkillToEmployee();
	//	testGetAllPermanentEmployees();
		
	//	testGetAverageSalary();
		
	//	testGetAllEmployeesNative();
		
	}
	
	
	//----------------------------Country Test----------------------------------------//
	
	
	private static void testGetAllCountries() 
	{

		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
	
		LOGGER.info("End");

	}
	
	private static void getAllCountriesTest() {

		LOGGER.info("Start");
		Country country;
		try 
		{
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
			
		} 
		catch (CountryNotFoundException e) 
		{
	
			System.out.println(e);
		}
		
		LOGGER.info("End");
		}
		
	private static void addCountryTest()
	{
			LOGGER.info("Start");
			Country c = new Country("EX","Example");
			countryService.addCountry(c);
			
			try 
			{
				Country country = countryService.findCountryByCode("EX");
				LOGGER.debug("Country:{}", country);
			} 
			catch (CountryNotFoundException e) 
			{
				
				System.out.println(e);
			}
			
			LOGGER.info("End");
		}
		
		private static void updateCountryTest()
		{
			LOGGER.info("Start");
			
			try 
			{
				countryService.updateCountry("EX", "New Example");
				Country country = countryService.findCountryByCode("EX");
				LOGGER.debug("Country:{}", country);
				countryService.deleteCountry("EX");
				
			} 
			
			catch (CountryNotFoundException e) 
			{
				
				System.out.println(e);
			}
			LOGGER.info("End");
			
		}
		
		private static void findCountrytest()
		{
			
			LOGGER.info("Start");
			List<Country> countries = countryService.searchCountryByName("ou");
			LOGGER.debug("Country:{}", countries);
			LOGGER.info("End");
		}
		
		private static void findCountryStartsWithtest()
		{
			LOGGER.info("Start");
			List<Country> countries = countryService.searchCountryByNameStartsWith("Z");
			LOGGER.debug("Country:{}", countries);
			LOGGER.info("End");
		}
		
		//--------------------------------Stock Test------------------------------------//
		
		private static void getStockFBSeptest()
		{
			
			LOGGER.info("Start");
			List<Stock> stocks = stockService.getStocksFBSep();
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
		}
		
		private static void getStockGreatertest()
		{
			
			LOGGER.info("Start");
			List<Stock> stocks = stockService.getStockGT();
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
		}
		
		private static void getTopVolumetest()
		{
			LOGGER.info("Start");
			List<Stock> stocks = stockService.getStockTopVolume();
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
			
		}
		private static void getTopNetflixPricetest()
		{
			LOGGER.info("Start");
			List<Stock> stocks = stockService.getStockTopNetflixPrice();
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
			
		}
		
		private static void getStockFBSeptembertest()
		{
			
			LOGGER.info("Start");
			List<Stock> stocks = stockRepository.findStockFBSep();
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
		}
		
		private static void getStockGreaterThantest()
		{
			
			LOGGER.info("Start");
			List<Stock> stocks =stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
		}
		
		private static void getTop3Volumetest()
		{
			LOGGER.info("Start");
			List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
			
		}
		private static void getTop3NetflixPricetest()
		{
			LOGGER.info("Start");
			List<Stock> stocks = stockRepository.findTop3ByCodeOrderByClose("NFLX");
			LOGGER.debug("Stocks:{}", stocks);
			LOGGER.info("End");
			
		}
		
		
//---------------------------------------------------------------------------------------------------------//		
		
		private static void testGetEmployee() 
		{
			LOGGER.info("Start");
			Employee employee = employeeService.get(1);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.debug("Department:{}", employee.getDepartment());
			LOGGER.debug("Skills:{}", employee.getSkillList());
			LOGGER.info("End");
		}
		
		private static void testAddEmployee()
		{
			LOGGER.info("Start");
			
			Employee emp = new Employee();
			emp.setName("Jp");
			emp.setPermanent(true);
			emp.setSalary((double)2000);
			Date date = new Date();
			try {
				date = sdf.parse("1998-05-02");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			emp.setDateOfBirth(date);
			Department dep = departmentService.get(1);
			
			emp.setDepartment(dep);
			LOGGER.debug("Employee:{}", emp);
			LOGGER.debug("Department:{}", emp.getDepartment());
			employeeService.save(emp);
			LOGGER.info("End");
		}
		
		private static void testUpdateEmployee()
		{
			LOGGER.info("Start");
			Employee emp = employeeService.get(1);
			Department dep = departmentService.get(2);
			
			emp.setDepartment(dep);
			employeeService.save(emp);
			LOGGER.debug("Employee:{}", emp);
			LOGGER.debug("Department:{}", emp.getDepartment());
			LOGGER.info("End");
		}
		
		private static void testGetDepartment()
		{
			LOGGER.info("Start");
			Department department = departmentService.get(2);
			Set<Employee> employees = department.getEmployeeList();
			LOGGER.debug("Department:{}",department);
			LOGGER.debug("Employees:{}", employees);
			
			LOGGER.info("End");
			
		}
		
		private static void testAddSkillToEmployee()
		{
			LOGGER.info("Start");
			Employee employee = employeeService.get(4);
			Skill skill = skillService.get(3);
			employee.getSkillList().add(skill);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.debug("Skills:{}", employee.getSkillList());
			employeeService.save(employee);
			LOGGER.info("End");
		}
		
		
		private static void testGetAllPermanentEmployees() {
			LOGGER.info("Start");
			List<Employee> employees = employeeService.getAllPermanentEmployees();
			LOGGER.debug("Permanent Employees:{}", employees);
			employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
			LOGGER.info("End");

			}
		
		private static void testGetAverageSalary()
		{
			LOGGER.info("Start");
			
			double avgsal = employeeService.getAverageSalary(2);
			LOGGER.debug("Average Sal:{}", avgsal);
			LOGGER.info("End");
		}
		
		private static void testGetAllEmployeesNative()
		{
			LOGGER.info("Start");
			List<Employee> employees = employeeService.getAllEmployeeNative();
			LOGGER.debug("Permanent Employees:{}", employees);
			LOGGER.info("End");
		}
		
}
