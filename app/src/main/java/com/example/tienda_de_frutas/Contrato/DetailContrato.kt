package com.example.tienda_de_frutas.Contrato

interface DetailContrato {

    interface View {
        fun mostrarDetalles(nombre: String, descripcion: String, precio: String, stock: String);
        fun mostrarTotal(total: String);
        fun mostrarError(mensaje: String);
        fun ocultarError();
    }

    interface Presenter {
        fun cargarDetalles(idFruta: Int);
        fun actualizarCantidad(cantidad: Int);
    }
}