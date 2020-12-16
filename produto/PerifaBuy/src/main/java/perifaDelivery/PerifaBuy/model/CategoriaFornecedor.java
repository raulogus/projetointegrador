package perifaDelivery.PerifaBuy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_categoria_fornecedor")
public class CategoriaFornecedor {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private int idLoja;
	
	@NotNull
	@Size(max=50)
	private String segmento;

	//----------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	
	
}
