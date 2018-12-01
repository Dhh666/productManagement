package product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class ProductDaoImpl implements IProductDao{

	private ArrayList<Product> products;
	
	 public ProductDaoImpl() {
		products = new ArrayList<Product>();
	}
	
	@Override
	public boolean save(Product product) {
		products.add(product);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Product temp = new Product(id);
		if(products.contains(temp)){
			products.remove(temp);
			return true;
		}
		return false;
	}

	@Override
	public Product modById(int id) {
		Product temp = new Product(id);
		if(products.contains(temp)){
			int index = products.indexOf(temp);
			return products.get(index);
		}
		return null;
	}

	@Override
	public Product queryById(int id) {
		Product temp = new Product(id);
		if(products.contains(temp)){
			int index = products.indexOf(temp);
			return products.get(index);
		}
		return null;
	}

	@Override
	public ArrayList<Product> queryByName(String name) {
		ArrayList<Product> products2 = new ArrayList<Product>();
		for(int i = 0; i < products.size(); i++){
			if(products.get(i).getName().equals(name)){
				products2.add(products.get(i));
			}
		}
		return products2;
	}

	@Override
	public ArrayList<Product> queryByPrice(int max, int min) {
		ArrayList<Product> products2 = new ArrayList<Product>();
		for(int i = 0; i < products.size(); i++){
			if(min < products.get(i).getPrice() && max > products.get(i).getPrice()){
				products2.add(products.get(i));
			}
		}
		return products2;
	}

	@Override
	public ArrayList<Product> queryByStatus(boolean status) {
		ArrayList<Product> products2 = new ArrayList<Product>();
		for(int i = 0; i < products.size(); i++){
			if(products.get(i).isStatus() == status){
				products2.add(products.get(i));
			}
		}
		return products2;
	}

	@Override
	public ArrayList<Product> sortByCount(ArrayList<Product> product) {
		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o2.getCount()-o1.getCount();
			}
		});
		return products;
	}

	@Override
	public ArrayList<Product> sortByDate(ArrayList<Product> product) {
		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		return products;
	}

	@Override
	public ArrayList<Product> queryAll() {
		return products;
	}
/*
	private Product[] products;
	private int index = 0;
	public ProductDaoImpl() {
		products = new Product[10];
	}
	public ProductDaoImpl(int size) {
		products = new Product[size];
	}

	@Override
	public boolean save(Product product) {
		if( index < products.length) {
			products[index++] = product;
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		for( int i = 0; i < index; i++ ) {
			if( products[i].getId() == id) {
				for( int j = i+1; j < index; j++) {
					products[j-1] = products[j];
				}
				index--;
			}
		}
		return false;
	}

	@Override
	public Product modById(int id) {
		for(int i = 0;i < index; i++){
			if(products[i].getId() == id) {
				return products[i];
			}
		}
		return null;
	}

	@Override
	//查询所有商品
	public Product[] queryAll() {
		Product[] p = new Product[index];
		System.arraycopy(products, 0, p, 0, index);
		return p;
	}
	//按照id查询商品信息
	@Override
	public Product queryById(int id) {
		for(int i = 0; i < index ; i++) {
			if(products[i].getId() == id) { 
				return products[i];
			}
		}
		return null;
	}
	//按照name查询商品信息
	@Override
	public Product[] queryByName(String name) {
		int count = 0;  
		for(int i = 0; i < index ; i++) {
			if(products[i].getName().equals(name)) {
				count++;
			}
		}
		if(0 == count) {
			return null;
		}
		Product[] p = new Product[count];
		for(int i = 0; i < index; i++) {
			if(products[i].getName().equals(name)) {
				p[--count] = products[i];
			}
		}
		return p;
	}

	@Override
	public Product[] queryByPrice(int max,int min) {
		int count = 0;
		for(int i = 0; i < index;i++){
			if(products[i].getPrice() > min && products[i].getPrice() < max) {
				count++;
			}
		}
		if(0 == count){
			return null;
		}
		Product[] p = new Product[count];
		for(int i = 0;i<index;i++) {
			if(products[i].getPrice() > min && products[i].getPrice() < max) {
				p[--count] = products[i];
			}
		}
		return p;
	}
	//根据status查询商品
	@Override
	public Product[] queryByStatus(boolean status) {
		int count = 0;
		for(int i = 0; i < index; i++) {
			if(products[i].isStatus() == status) {
				count++;
			}
		}
		if(0 == count){
			return null;
		}
		Product[] p = new Product[count];
		for(int i = 0;i<index;i++) {
			if(products[i].isStatus() == status) {
				p[--count] = products[i];
			}
		}
		return p;
	}
	//根据count数量降序排序
	@Override
	public Product[] queryByCount(Product[] product) {
		for(int i = 0; i < index-1; i++) {
			for(int j = i+1; j  < index; j++) {
				if(product[j].getCount() > product[i].getCount()) {
					Product temp = product[j];
					product[j] = product[i];
					product[i] = temp;
				}
			}
		}
		return product ;
	}
	@Override
	public Product[] sortByDate(Product[] product) {
		for(int i = 0; i < index-1; i++){
			for(int j = i+1; j  < index; j++){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date d,d1;
				try {
					d = sdf.parse(product[j].getDate());
					d1 = sdf.parse(product[i].getDate());
					if(d.before(d1)){
						Product temp = product[j];
						product[j] = product[i];
						product[i] = temp;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return product;
	}
*/
}
