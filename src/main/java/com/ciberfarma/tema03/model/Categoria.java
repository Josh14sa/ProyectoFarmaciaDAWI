package com.ciberfarma.tema03.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_categorias")
@Data
public class Categoria {
	@Id
	private int idcategoria;
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	private List<Producto> lstProductos;
	
}
