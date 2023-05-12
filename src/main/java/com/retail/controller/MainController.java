package com.retail.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.retail.dao.AddressDao;
import com.retail.dao.CartDao;
import com.retail.dao.CategoryDao;
import com.retail.dao.CustomerDao;
import com.retail.dao.PaymentMethodDao;
import com.retail.dao.ProductDao;
import com.retail.dao.ReviewDao;
import com.retail.dao.UserDao;
import com.retail.dao.WishListDao;
import com.retail.entity.Address;
import com.retail.entity.Cart;
import com.retail.entity.Category;
import com.retail.entity.Customer;
import com.retail.entity.Helper1;
import com.retail.entity.PaymentMethod;
import com.retail.entity.Product;
import com.retail.entity.Review;
import com.retail.entity.User;
import com.retail.entity.WishList;
import com.retail.entity.pkCart;
import com.retail.helper.CartItems;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class MainController {

	@Autowired
	private CategoryDao categorydao;

	@Autowired
	private UserDao userdao;

	@Autowired
	private ProductDao productdao;

	@Autowired
	private ReviewDao reviewdao;
	
	@Autowired
	private WishListDao wishlistdao;
	
	@Autowired
	private CartDao cartdao;
	
	@Autowired
	private PaymentMethodDao paymentmethoddao;
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private AddressDao addressdao;

	
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Category> category = categorydao.getCategories();
		m.addAttribute("category", category);

		return "index";
	}

	@RequestMapping("/auth")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/checking", method = RequestMethod.POST)
	public RedirectView check(@ModelAttribute User user, HttpServletRequest request, Model m) {
		System.out.println(user);
		RedirectView redirectView = new RedirectView();
		if (this.userdao.ckUser(user) != null) {

			HttpSession s = request.getSession();
			s.setAttribute("currentuser", this.userdao.getUser(user.getUserId()));
			m.addAttribute("session", s);
			redirectView.setUrl(request.getContextPath() + "/");
			return redirectView;
		}
		redirectView.setUrl(request.getContextPath() + "/auth");
		return redirectView;
	}

	@RequestMapping(value = "/creating", method = RequestMethod.POST)
	public RedirectView creating(@ModelAttribute User user, Model m, HttpServletRequest request) {
		System.out.println(user);
		this.userdao.createUser(user);

		HttpSession s = request.getSession();
		s.setAttribute("currentuser", user);

		m.addAttribute("session", s);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/product")
	public String loadProducts() {
		return "product";
	}

	@RequestMapping("/products/{catid}")
	public String getproducts(@PathVariable("catid") int catId, Model m, HttpServletRequest request) {

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		if (user == null) {
			return "login";
		}

		List<Product> products = this.productdao.getproducts(catId);
		m.addAttribute("product", products);
		List<Category> categoryL = categorydao.getCategories();
		m.addAttribute("category", categoryL);
		m.addAttribute("pathCat", catId);
		return "product";
	}

	@RequestMapping("/filter/{val}/{categor}")
	public String applyFilter(@PathVariable("val") float value, @PathVariable("categor") int catId, Model m, HttpServletRequest request) {

		if (value == 0) {
			List<Product> products = this.productdao.getproducts(catId);
			m.addAttribute("product", products);
			List<Category> categoryL = categorydao.getCategories();
			m.addAttribute("category", categoryL);
			m.addAttribute("pathCat", catId);
			return "product";
		}

		List<Product> products = this.productdao.getFiltredProduct(value, catId);
		m.addAttribute("product", products);
		List<Category> categoryL = categorydao.getCategories();
		m.addAttribute("category", categoryL);
		return "product";
	}


	@RequestMapping("/productdetail/{productId}")
	public String getProductDetail(@PathVariable("productId") int productId, Model m) {

		Product p = productdao.getProductDetail(productId);
		m.addAttribute("product", p);
		List<Category> categoryL = categorydao.getCategories();
		m.addAttribute("category", categoryL);
		List<Review> reviews = this.reviewdao.getReviewsOnProduct(productId);
		m.addAttribute("reviews", reviews);
		return "detail";
	}

	@RequestMapping("/review/{productId}")
	public RedirectView addReview(@PathVariable("productId") int productId, @ModelAttribute Review review, HttpServletRequest request) {

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		review.setUserId(user.getUserId());
		this.reviewdao.addReview(review);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/productdetail/" + productId);
		return redirectView;
	}

	@RequestMapping("/addtolist/{productId}")
	public RedirectView addToCart(@PathVariable("productId") int productId, HttpServletRequest request) {

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		this.wishlistdao.insert(productId, user.getUserId());		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/productdetail/" + productId);
		return redirectView;
	}
	
	
	@RequestMapping("/wishlist")
	public String getWidhList(Model m, HttpServletRequest request) {
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
				
		List<Category> categoryL = categorydao.getCategories();
		m.addAttribute("category", categoryL);
		List<Product> products = this.wishlistdao.getWishList(user.getUserId());
		m.addAttribute("product",products);
		
		return "wishlist";
	}
	
	
	@RequestMapping("/remove/{productId}")
	public RedirectView removeFromList(@PathVariable("productId") int productId, HttpServletRequest request) {
		
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		
		System.out.println(this.wishlistdao.deleteItem(productId, user.getUserId()));		
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/wishlist");
		return redirectView;
	}
	
	@RequestMapping("/addtocart/{productId}")
	public RedirectView addTOCart(@PathVariable("productId") int productId, @ModelAttribute("queryForm") Cart cart,  Model m, HttpServletRequest request) {
		
//		System.out.println(productId);
//		System.out.println(cart);
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		
		this.cartdao.insert(new Cart(new pkCart(user.getUserId(),productId),cart.getQuantity()));
			
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/productdetail/" + productId);
		return redirectView;
	}
	
	@RequestMapping("/cart")
	public String getcart(Model m, HttpServletRequest request) {
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
				
		List<CartItems> cart = this.cartdao.getCartItems(user.getUserId());
		m.addAttribute("cartItems",cart);
		List<Category> category = categorydao.getCategories();
		m.addAttribute("category", category);		
		return "cart";
	}
	
	@RequestMapping("/removeitem/{productId}")
	public RedirectView moveTolist(@PathVariable("productId") int productId, Model m, HttpServletRequest request) {
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		
		this.cartdao.remove(productId, user.getUserId());		
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/cart");
		return redirectView;
	}
	
	@RequestMapping("/detail")
	public String payment(Model m) {
		
		List<Category> category = categorydao.getCategories();
		m.addAttribute("category", category);	
		
		return "payment";
	}
	
	@RequestMapping("/Adetail/{productId}")
	public String Apayment(@PathVariable("productId") int productId, Model m) {
		
		m.addAttribute("productId",productId);
		List<Category> category = categorydao.getCategories();
		m.addAttribute("category", category);	
		
		return "payment2";
		
	}
	
	@RequestMapping("/order")
	public String confirm(@ModelAttribute Customer customer, @ModelAttribute Address address, Model m, HttpServletRequest request) {
		
		HttpSession s = request.getSession();
		User user = (User)s.getAttribute("currentuser");
		
		customer.setCustomerId(user.getUserId());
		address.setUserId(user.getUserId());
//		System.out.println(customer);
//		System.out.println(address);
		System.out.println(this.customerdao.insert(customer, address));
		
		List<CartItems> cart = this.cartdao.getCartItems(user.getUserId());
		m.addAttribute("cartItems",cart);
		
		double total = 0;
		
		for(CartItems c : cart) {
			total += c.getQuantity() * c.getProduct().getPrice();
		}
		m.addAttribute("total",total);
		
		List<PaymentMethod> methods =  this.paymentmethoddao.getPaymentMethods();
		m.addAttribute("methods",methods);
		
		List<Category> category = categorydao.getCategories();
		m.addAttribute("category", category);	

		
		return "paytype";
	}
	
	
	@RequestMapping("/search")
	public RedirectView searchproduct(@ModelAttribute String name, Model m, HttpServletRequest request) {
		
		System.out.println(name);
		
		List<Product> products = this.productdao.getSearchedProduct(name);
		m.addAttribute("product",products);
		List<Category> category = categorydao.getCategories();
		m.addAttribute("category", category);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/product");
		return redirectView;
	}

}
