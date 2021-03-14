package com.Ecommerce.CarritoDeCompras.Model
import javax.persistence.*
import java.util.*

@Entity
@Table(name="producto")
data class Producto(val nombre:String="",val sku:Long=0, val descripcion:String="",val precio:Int=0) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long =0

}