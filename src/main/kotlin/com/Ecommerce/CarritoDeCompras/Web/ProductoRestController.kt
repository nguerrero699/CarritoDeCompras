package com.Ecommerce.CarritoDeCompras.Web

import com.Ecommerce.CarritoDeCompras.Business.IProductoBusiness
import com.Ecommerce.CarritoDeCompras.Exception.BusinessException
import com.Ecommerce.CarritoDeCompras.Exception.NotFoundException
import com.Ecommerce.CarritoDeCompras.Model.Producto
import com.Ecommerce.CarritoDeCompras.Utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PRODUCTOS)
class ProductoRestController {

    @Autowired
    val productoBusiness: IProductoBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Producto>> {
        return try {
            ResponseEntity(productoBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idProducto: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(productoBusiness!!.load(idProducto), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}