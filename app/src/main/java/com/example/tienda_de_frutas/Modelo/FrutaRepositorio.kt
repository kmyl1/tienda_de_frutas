package com.example.tienda_de_frutas.Modelo

object FrutaRepositorio {

    fun obtenerFrutas(): List<Fruta> {
        return listOf(
            Fruta(1, "Manzana", "Dulce, crujiente y jugosa.", 1.50, 120),
            Fruta(2, "Platano", "Fuente natural de potasio y energia.", 1.00, 80),
            Fruta(3, "Mango", "Suave y de sabor tropical.", 2.00, 60),
            Fruta(4, "Fresa", "Pequeña, roja y con mucho sabor.", 3.00, 40),
            Fruta(5, "Uva Verde", "Refrescante, ideal para jugos.", 2.50, 100)
        )
    }

    fun obtenerFrutaPorId(id: Int): Fruta? {
        return obtenerFrutas().find { it.id == id };
    }
}