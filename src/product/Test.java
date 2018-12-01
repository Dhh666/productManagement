package product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test {
	
	public static void printProduct(ArrayList<Product> products){
		for(Product product : products){
			System.out.println("商品名："+ product.getName());
			System.out.println("单价："+ product.getPrice());
			System.out.println("数量："+ product.getCount());
			System.out.println("状态："+ product.isStatus());
			System.out.println("入库日期："+ product.getDate());
			System.out.println("--------------------------");
		}
	}
	
	public static Date dateChange(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d	= sdf.parse(date);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
			return null;
		}
	
	public static void main(String[] args) {
		Product p1 = new Product(111, "PSP", 1000, 10, true,dateChange("2017-10-13"));
		Product p2 = new Product(211, "New 3DSLL", 1800, 0, false,dateChange("2018-11-21"));
		Product p3 = new Product(321, "Sony 4K电视", 5599, 8, true,dateChange("2015-09-08"));
		Product p4 = new Product(322, "Sony 4K电视", 6599, 8, true,dateChange("2018-02-08"));
		Product p5 = new Product(134, "HTC VIVE", 4888, 5, true,dateChange("2018-01-31"));
		Product p6 = new Product(554, "Swtich", 2188, 6, true,dateChange("2017-04-24"));
		Product p7 = new Product(126, "Xbox one", 2800, 0, false,dateChange("2018-12-23"));
		Product p8 = new Product(127, "Xbox one", 1800, 5, true,dateChange("2018-10-01"));
		Product p9 = new Product(329, "PS VR", 2599, 3, true,dateChange("2017-07-04"));
		Product p10 = new Product(140, "PS4", 1999, 5, true,dateChange("2016-02-16"));
		
		IProductDao ipd = new ProductDaoImpl();
		
		ipd.save(p1);
		ipd.save(p2);
		ipd.save(p3);
		ipd.save(p4);
		ipd.save(p5);
		ipd.save(p6);
		ipd.save(p7);
		ipd.save(p8);
		ipd.save(p9);
		ipd.save(p10);
		System.out.println("-------------save--------------");
		printProduct(ipd.queryAll());
		
		System.out.println("-------------delete------------");
		ipd.delete(111);
		printProduct(ipd.queryAll());
		
		System.out.println("-------------modById------------");
		Product product1 = ipd.modById(322);
		product1.setPrice(6299);
		product1.setCount(7);
		System.out.println("商品名："+ product1.getName());
		System.out.println("单价："+ product1.getPrice());
		System.out.println("数量："+ product1.getCount());
		System.out.println("状态："+ product1.isStatus());
		
		System.out.println("-------------queryById------------");
		Product product2 = ipd.queryById(554);
		if(null != product2){
			System.out.println("商品名："+ product2.getName());
			System.out.println("单价："+ product2.getPrice());
			System.out.println("数量："+ product2.getCount());
			System.out.println("状态："+ product2.isStatus());
		}
		
		System.out.println("-------------queryByName------------");
//		Product[] product3 = ipd.queryByName("Xbox one");
		ArrayList<Product> product3 = ipd.queryByName("Xbox one");
		printProduct(product3);
		
		System.out.println("-------------queryByPrice------------");
//		Product[] product4 = ipd.queryByPrice(5000, 2000);
		ArrayList<Product> product4 = ipd.queryByPrice(5000, 2000);
		printProduct(product4);
		
		System.out.println("-------------queryByStatus------------");
//		Product[] product5 = ipd.queryByStatus(false);
		ArrayList<Product> product5 = ipd.queryByStatus(false);
		printProduct(product5);
		
		System.out.println("-------------sortByCount------------");
		printProduct(ipd.sortByCount(ipd.queryAll()));

		System.out.println("-------------sortByDate------------");
		printProduct(ipd.sortByDate(ipd.queryAll()));
	}
}
