package com.Ecommerce.CarritoDeCompras.Dao

import com.Ecommerce.CarritoDeCompras.Model.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductoRepository: JpaRepository<Producto, Long>
