package perifaDelivery.PerifaBuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min=2, max=100)
	private String nome;
	
	@NotNull
	private float precoUnitario;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_categoria_produto; // ver como deixar??
	
	@NotNull
	private String imagem_produto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getId_categoria_produto() {
		return id_categoria_produto;
	}

	public void setId_categoria_produto(int id_categoria_produto) {
		this.id_categoria_produto = id_categoria_produto;
	}

	public String getImagem_produto() {
		return imagem_produto;
	}

	public void setImagem_produto(String imagem_produto) {
		this.imagem_produto = imagem_produto;
	}
	
	
	
	

}
