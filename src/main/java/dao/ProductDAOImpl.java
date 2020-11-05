package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.crud.Product;


public class ProductDAOImpl implements ProductDAO {
	private static SessionFactory factory;
	private Session session;
	private Transaction transaction;

	static {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
	}

	public ProductDAOImpl() {

	}
	@Override
	public List<Product> view() {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public List<Product> sortByCostPrice(String order) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Criteria c = null;
		List<Product> product = null;
		c=session.createCriteria(Product.class);
		if(order.equals("asc")) {
			c.addOrder(Order.asc("costPrice"));
			product=c.list();
			//System.out.println(product);
			transaction.commit();
			session.close();
			return product;
		}
		else {
			c.addOrder(Order.desc("costPrice"));
			product=c.list();
			//System.out.println(product);
			transaction.commit();
			session.close();
			return product;
		}
	
	}
	
	@Override
	public List<Product> sortBySalePrice(String order) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Criteria c = null;
		List<Product> product = null;
		c=session.createCriteria(Product.class);
		if(order.equals("asc")) {
			c.addOrder(Order.asc("salePrice"));
			product=c.list();
			//System.out.println(product);
			transaction.commit();
			session.close();
			return product;
		}
		else {
			c.addOrder(Order.desc("salePrice"));
			product=c.list();
			//System.out.println(product);
			transaction.commit();
			session.close();
			return product;
		}
	
	}

}
