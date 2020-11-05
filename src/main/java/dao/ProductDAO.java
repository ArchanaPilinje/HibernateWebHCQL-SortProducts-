package dao;

import java.util.List;

import com.crud.Product;

public interface ProductDAO {
	List<Product> view();
	List<Product> sortByCostPrice(String order);
	List<Product> sortBySalePrice(String order);
}
