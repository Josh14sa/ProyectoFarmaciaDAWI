package com.ciberfarma.tema03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.tema03.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer>{

}
