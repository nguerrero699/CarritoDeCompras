package com.Ecommerce.CarritoDeCompras.Business

import com.Ecommerce.CarritoDeCompras.Dao.ProductoRepository
import com.Ecommerce.CarritoDeCompras.Exception.BusinessException
import com.Ecommerce.CarritoDeCompras.Exception.NotFoundException
import com.Ecommerce.CarritoDeCompras.Model.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class ProductoBusiness:IProductoBusiness {

    @Autowired
    val ProductoRepository: ProductoRepository?=null


    @Throws(BusinessException::class)
    override fun list(): List<Producto> {
        try {
            return ProductoRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idProducto: Long): Producto {
        val op: Optional<Producto>
        try {
            op=ProductoRepository!!.findById(idProducto)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!op.isPresent){
            throw NotFoundException("No se encontro la producto con id $idProducto")
        }
        return op.get()

    }


    @Throws(BusinessException::class)
    override fun save(produto: Producto): Producto {
        try {
            return ProductoRepository!!.save(produto)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }
    @Throws(BusinessException::class)
    override fun remove(idProducto: Long) {
        val op:Optional<Producto>
        try {
            op=ProductoRepository!!.findById(idProducto)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se econtro el producto con el $idProducto")
        }else{
            try {
                ProductoRepository!!.deleteById(idProducto)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }

    }
}