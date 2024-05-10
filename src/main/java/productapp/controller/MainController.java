package productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productapp.dao.ProductDao;
import productapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	
	
	
	// adding product to the data base
	@RequestMapping(path = "/handle-product", method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, Model model, 
			HttpServletRequest request) {
		System.out.println(product);
		this.productDao.addProduct(product);
		RedirectView redirectView  = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	// delete product 
	@RequestMapping(path="/delete-{productId}", method = RequestMethod.GET)
	public RedirectView deleteProduct(HttpServletRequest request, @PathVariable("productId") int pid) {
		this.productDao.deleteProduct(pid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	// handling product data 
	@RequestMapping("/update-{productId}")
	public String updateProductHandler(Model model, @PathVariable("productId")int pid) {
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		return  "update-data";
	}
	
	
	// updating product data 
	@RequestMapping("/update-product-{productId}")
	public RedirectView updateProductData(@ModelAttribute Product product, Model model, 
			 HttpServletRequest request, @PathVariable("productId") int pid) {
		System.out.println("this is update product request "+ product);
		System.out.println("--->>>>>>>>>"+pid);
		product.setId(pid);
		this.productDao.addProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
}
