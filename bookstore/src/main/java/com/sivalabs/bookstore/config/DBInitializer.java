/**
 * 
 */
package com.sivalabs.bookstore.config;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import com.sivalabs.bookstore.entities.Address;
import com.sivalabs.bookstore.entities.Category;
import com.sivalabs.bookstore.entities.Customer;
import com.sivalabs.bookstore.entities.Order;
import com.sivalabs.bookstore.entities.OrderItem;
import com.sivalabs.bookstore.entities.OrderStatus;
import com.sivalabs.bookstore.entities.Payment;
import com.sivalabs.bookstore.entities.Product;
import com.sivalabs.bookstore.services.CatalogService;
import com.sivalabs.bookstore.services.CustomerService;
import com.sivalabs.bookstore.services.OrderService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	private DataSource dataSource;

	@Value("${init-db:false}")
	private String initDatabase;

	//@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		ResourceDatabasePopulator dp = new ResourceDatabasePopulator();
		dp.addScript(new ClassPathResource("bookstore.sql"));
		DatabasePopulatorUtils.execute(dp, dataSource);		
		logger.info("DB Initialization completed.");
	}
	
	@Autowired private CustomerService customerService;
	@Autowired private CatalogService catalogService;
	@Autowired private OrderService orderService;
	 
	@PostConstruct
	public void initialize()
	{
		initCustommers();
		initCatalog();
		initTestOrders();
	}

	private void initTestOrders() 
	{
		Customer customer = new Customer();
		customer.setFirstName("Siva");
		customer.setLastName("K");
		customer.setEmail("siva@gmail.com");
		customer.setPassword("siva");
		customer.setPhone("90000510456");
		
		Address shippingAddress = new Address();
		shippingAddress.setAddrLine1("KP");
		shippingAddress.setAddrLine2("BalajiNagar");
		shippingAddress.setCity("Hyd");
		shippingAddress.setState("AP");
		shippingAddress.setCountry("India");
		shippingAddress.setZipCode("500072");
		
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		OrderItem item1 = new OrderItem();
		item1.setProduct(catalogService.findProductById(1));
		item1.setQuantity(1);
		
		OrderItem item2 = new OrderItem();
		item2.setProduct(catalogService.findProductById(2));
		item2.setQuantity(2);
		
		orderItems.add(item1);
		orderItems.add(item2);
		
		Payment payment = new Payment();
		payment.setCreditCardNumber("123-456-789");
		payment.setCvv("123");
		payment.setExpiryDate(new Date());
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setShippingAddress(shippingAddress);
		order.setOrderItems(orderItems);
		order.setPayment(payment );
		order.setStatus(OrderStatus.NEW);
		
		orderService.createOrder(order);
		
	}

	private void initCatalog()
	{
		Category c1 = new Category(0,"Java Books","Java Programming Books");
		Category c2 = new Category(0,"MS.NET Books","MS.NET Programming Books");
		Category c3 = new Category(0,"General Books","General Books");
		
		c1 = catalogService.createCategory(c1);
		c2 = catalogService.createCategory(c2);
		c3 = catalogService.createCategory(c3);
		
		
		Product p1 = new Product(0, "Java Persistence with MyBatis 3", "Java Persistence with MyBatis 3", new BigDecimal("250"), "MyBatis3.jpg",c1);
		Product p2 = new Product(0, "PrimeFaces Beginner\'s Guide: RAW", "PrimeFaces Beginner\'s Guide: RAW", new BigDecimal("350"), "PFBG_Raw.jpg",c1);
		Product p3 = new Product(0, "CleanCode", "CleanCode", new BigDecimal("450"), "CleanCode.jpg",c1);
		Product p4 = new Product(0, "HibernateInAction", "HibernateInAction", new BigDecimal("480"), "HibernateInAction.jpg",c1);
		Product p5 = new Product(0, "ProSpring3", "ProSpring3", new BigDecimal("750"), "ProSpring3.jpg",c1);
		Product p6 = new Product(0, "FirstLookatC#4.5", "FirstLookatC#4.5", new BigDecimal("500"), "FirstLookatCSharp4.5.jpg",c2);
		Product p7 = new Product(0, "Visual Studio 2012 Cookbook", "Visual Studio 2012 Cookbook", new BigDecimal("560"), "VS2012Cookbook.jpg",c2);
		Product p8 = new Product(0, "The Monk Who Sold His Ferrari", "The Monk Who Sold His Ferrari", new BigDecimal("150"), "nocover_book.jpg",c3);
		Product p9 = new Product(0, "Who Will Cry When You Die?", "Who Will Cry When You Die?", new BigDecimal("200"), "nocover_book.jpg",c3);
		
		catalogService.createProduct(p1);
		catalogService.createProduct(p2);
		catalogService.createProduct(p3);
		catalogService.createProduct(p4);
		catalogService.createProduct(p5);
		catalogService.createProduct(p6);
		catalogService.createProduct(p7);
		catalogService.createProduct(p8);
		catalogService.createProduct(p9);
		
	}

	private void initCustommers() 
	{
		Customer customer = null;
		customer = new Customer(0,"sivaprasadreddy.k@gmail.com","siva","Siva Prasad Reddy", "Katamreddy","9000510456");
		customerService.createCustomer(customer);
		
		customer = new Customer(0,"admin@gmail.com","admin","Administrator", null,"900000000000");
		customerService.createCustomer(customer);
		
	}
}
