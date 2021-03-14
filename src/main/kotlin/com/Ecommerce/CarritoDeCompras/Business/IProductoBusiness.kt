package com.Ecommerce.CarritoDeCompras.Business

import com.Ecommerce.CarritoDeCompras.Model.Producto

interface IProductoBusiness {
    fun list(): List<Producto>
    fun load(idProducto:Long):Producto
    fun save(produto:Producto):Producto
    fun remove(idProducto:Long)

}