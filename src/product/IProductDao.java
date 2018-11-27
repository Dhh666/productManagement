package product;

public interface IProductDao {
	boolean save(Product product);
	boolean delete(int id);
	Product modById(int id);
	Product[] queryAll();
	Product queryById(int id);
	Product[] queryByName(String name);
	Product[] queryByPrice(int max,int min);
	Product[] queryByStatus(boolean status);
	Product[] queryByCount(Product[] product);
	Product[] sortByDate(Product[] product);
}
