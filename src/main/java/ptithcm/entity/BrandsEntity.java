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
@Table(name = "brands")
public class BrandsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private Integer brand_id;

	@Column(name = "brand_name")
	private String brand_name;

	@OneToMany(mappedBy = "brands", fetch = FetchType.EAGER)
	private Collection<ProductsEntity> products;

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public Collection<ProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(Collection<ProductsEntity> products) {
		this.products = products;
	}
	
	

}
