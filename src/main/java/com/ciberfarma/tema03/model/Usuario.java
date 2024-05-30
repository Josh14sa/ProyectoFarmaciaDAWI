package com.ciberfarma.tema03.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_usuarios")
@Data
public class Usuario {
	@Id
	private int cod_usua;
	
	@Column(length = 15, nullable = false)
	private String nom_usua;
	
	@Column(length = 25, nullable = false)
	private String ape_usua;
	
	@Column(name = "usr_usua", length = 45, nullable = false, unique = true)
	private String correo;
	
	@Column(name = "cla_usua", length = 100, nullable = false)
	private String clave;
	
	private String fna_usua;
	
	@Column(nullable = true, columnDefinition = "int default 2")
	private int idtipo;
	
	@Column(nullable = true, columnDefinition = "int default 1")
	private int est_usua;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idtipo", updatable = false, insertable = false)
	private Tipo objTipo;
	
	
}
