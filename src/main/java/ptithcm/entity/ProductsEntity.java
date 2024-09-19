package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer product_id;
	
	@Column(name="product_name")
	private String product_name;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private BrandsEntity brands;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoriesEntity categories;
	
	@Column(name="model_year")
	private Short model_year;
	
	@Column(name="list_price")
	private Double list_price;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public BrandsEntity getBrands() {
		return brands;
	}

	public void setBrands(BrandsEntity brands) {
		this.brands = brands;
	}

	public CategoriesEntity getCategories() {
		return categories;
	}

	public void setCategories(CategoriesEntity categories) {
		this.categories = categories;
	}

	public Short getModel_year() {
		return model_year;
	}

	public void setModel_year(Short model_year) {
		this.model_year = model_year;
	}

	public Double getList_price() {
		return list_price;
	}

	public void setList_price(Double list_price) {
		this.list_price = list_price;
	}
	
	

}
