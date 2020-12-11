package perifaDelivery.PerifaBuy.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="tb_categoriaProduto")
public class CategoriaProdutoModel {
	
	@Id
	@Column
	//Equivalente ao - PRIMARY KEY AUTO_INCREMENT
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "nome", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("nome")
	@Column
	private String nomeCategoriaProduto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCategoriaProduto() {
		return nomeCategoriaProduto;
	}
	public void setNomeCategoriaProduto(String nomeCategoriaProduto) {
		this.nomeCategoriaProduto = nomeCategoriaProduto;
	}
	// getters and setters
	
	
}