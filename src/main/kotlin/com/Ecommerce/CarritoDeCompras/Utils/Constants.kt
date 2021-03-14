package com.Ecommerce.CarritoDeCompras.Utils

class Constants {

    companion object{
        private const val URL_API_BASE="/api"
        private const val URL_API_VERSION="/v2"
        private const val URL_BASE= URL_API_BASE+ URL_API_VERSION
        //Base API endopoint para productos
        const val URL_BASE_PRODUCTOS="$URL_BASE/productos"
    }
}