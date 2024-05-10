package productapp.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import productapp.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	// adding product 
	@Transactional
	public void addProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	// getting all products 
	public List<Product> getAllProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	// getting a single product
	
	public Product getProduct(int pid) {
		Product product = this.hibernateTemplate.get(Product.class, pid);
		return product;
	}
	
	// delete product
	@Transactional
	public void deleteProduct(int pid) {
		Product product = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(product);
	}
	
	
	
	
}
