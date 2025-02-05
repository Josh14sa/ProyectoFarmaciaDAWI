package com.ciberfarma.tema03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.tema03.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, String>{

}
