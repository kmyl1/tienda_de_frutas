package com.example.tienda_de_frutas.Contrato

interface MainContrato {

    interface View {
        fun mostrarListaFrutas(nombres: List<String>)
        fun navegarADetalle(idFruta: Int)
        fun mostrarError(msg: String)
    }

    interface Presenter {
        fun cargarFrutas()
        fun onVerDetallesSeleccionado(indice: Int)
    }
}