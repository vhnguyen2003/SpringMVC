package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class CategoriesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer category_id;
	
	@Column(name="category_name")
	private String category_name;
	
	@OneToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private Collection<ProductsEntity> products;

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Collection<ProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(Collection<ProductsEntity> products) {
		this.products = products;
	}
	
	

}
