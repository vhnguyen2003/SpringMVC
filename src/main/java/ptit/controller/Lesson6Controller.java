package ptit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.BrandsEntity;
import ptithcm.entity.CategoriesEntity;
import ptithcm.entity.ProductsEntity;

@Controller
@RequestMapping("/Lesson6/")
@Transactional
public class Lesson6Controller {

	@Autowired
	private SessionFactory factory;

	@RequestMapping("index")
	public String showProductsFile(ModelMap model, @ModelAttribute("product") ProductsEntity product) {

		List<ProductsEntity> products = this.getProducts();
		model.addAttribute("products", products);
		model.addAttribute("btnStatus", "btnAdd");
		return "products";
	}

	// hàm tìm kiếm theo tên sản phẩm
	@RequestMapping(value = "index", params = "btnSearch")
	public String searchProductByName(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") ProductsEntity product) {
		List<ProductsEntity> products = this.searchProducts(request.getParameter("searchInput"));
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "index", params = "btnAdd", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") ProductsEntity product) {
		int temp = this.insertProduct(product);
		if (temp != 0) {
			model.addAttribute("message", "Đã thêm sản phẩm thành công");

		} else {
			model.addAttribute("message", "Thêm sản phẩm thất bại");
		}

		List<ProductsEntity> products = this.getProducts();
		model.addAttribute("products", products);

		return "products";
	}

	// hàm hiển thị thông tin sản phẩm khi click vào bảng
	@RequestMapping(value = "index/{id}.htm", params = "linkEdit")
	public String getInforEditProduct(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") ProductsEntity product, @PathVariable("id") Integer id) {
		List<ProductsEntity> products = this.getProducts();
		model.addAttribute("products", products);
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("product", this.getProduct(id));
		return "products";
	}

	@RequestMapping(value = "index", params = "btnEdit")
	public String editProduct(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") ProductsEntity product) {
		Integer temp = this.updateProduct(product);
		if (temp != 0) {
			model.addAttribute("message", "Edit sản phẩm thành công");
		} else {
			model.addAttribute("message", "Edit sản phẩm thất bại");
		}
		List<ProductsEntity> products = this.getProducts();
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "index/{id}.htm", params = "linkDelete")
	public String deleteProduct(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") ProductsEntity product, @PathVariable("id") Integer id) {
		Integer temp = this.deleteProduct(this.getProduct(id));
		if (temp != 0) {
			model.addAttribute("message", "Xóa sản phẩm thành công");

		} else {
			model.addAttribute("message", "Xóa sản phẩm thất bại");
		}

		List<ProductsEntity> products = this.getProducts();
		model.addAttribute("products", products);

		return "products";
	}

	// ========== DAO ==========

	public List<ProductsEntity> getProducts() {
		Session sesion = this.factory.getCurrentSession();
		String hql = "FROM ProductsEntity";
		Query query = sesion.createQuery(hql);
		List<ProductsEntity> list = query.list();
		return list;
	}

	public List<ProductsEntity> searchProducts(String productName) {
		Session sesion = this.factory.getCurrentSession();
		String hql = "FROM ProductsEntity where product_name LIKE :productName";
		Query query = sesion.createQuery(hql);
		query.setParameter("productName", "%" + productName + "%");
		List<ProductsEntity> list = query.list();
		return list;
	}

	public Integer insertProduct(ProductsEntity pd) {
		Session session = this.factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public ProductsEntity getProduct(Integer id) {
		Session session = this.factory.getCurrentSession();
		String hql = "FROM ProductsEntity WHERE product_id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ProductsEntity result = (ProductsEntity) query.list().get(0);
		return result;

	}

	public Integer updateProduct(ProductsEntity pd) {
		Session session = this.factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteProduct(ProductsEntity pd) {
		Session session = this.factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@ModelAttribute("brandsSel")
	public List<BrandsEntity> getBrands() {
		Session sessons = this.factory.getCurrentSession();
		String hql = "FROM BrandsEntity";
		Query query = sessons.createQuery(hql);
		List<BrandsEntity> list = query.list();
		return list;
	}

	@ModelAttribute("categorySel")
	public List<CategoriesEntity> getCategories() {
		Session sessons = this.factory.getCurrentSession();
		String hql = "FROM CategoriesEntity";
		Query query = sessons.createQuery(hql);
		List<CategoriesEntity> list = query.list();
		return list;
	}

}
