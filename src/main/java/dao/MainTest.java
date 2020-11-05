package dao;

import java.util.ArrayList;
import java.util.List;

import com.crud.Product;

public class MainTest {

	public static void main(String[] args) {
		ProductDAOImpl impl=new ProductDAOImpl();
		List<Product> prod=impl.view();
		for(Product p:prod) {
			System.out.println(p);
		}
		System.out.println("********************");
		List<Product> prod1=impl.sortByCostPrice("asc");	
		for(Product p:prod1) {
			System.out.println(p);
		}
		
	}

}
