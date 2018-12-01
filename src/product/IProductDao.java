package product;

import java.util.ArrayList;

public interface IProductDao {
//	boolean save(Product product);
//	boolean delete(int id);
//	Product modById(int id);
//	Product[] queryAll();
//	Product queryById(int id);
//	Product[] queryByName(String name);
//	Product[] queryByPrice(int max,int min);
//	Product[] queryByStatus(boolean status);
//	Product[] queryByCount(Product[] product);
//	Product[] sortByDate(Product[] product);
	
	boolean save(Product product);
	boolean delete(int id);
	Product modById(int id);
	Product queryById(int id);
	ArrayList<Product> queryByName(String name);
	ArrayList<Product> queryByPrice(int max, int min);
	ArrayList<Product> queryByStatus(boolean status);
	ArrayList<Product> sortByCount(ArrayList<Product> product);
	ArrayList<Product> sortByDate(ArrayList<Product> product);
	ArrayList<Product> queryAll();
}
