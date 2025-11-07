package com.example.tienda_de_frutas.Presentador

import com.example.tienda_de_frutas.Contrato.MainContrato;
import com.example.tienda_de_frutas.Modelo.FrutaRepositorio;

class MainPresentador(private val view: MainContrato.View) : MainContrato.Presenter {

    private val frutas = FrutaRepositorio.obtenerFrutas();

    override fun cargarFrutas() {
        val nombres = frutas.map { it.nombre }
        view.mostrarListaFrutas(nombres);
    }

    override fun onVerDetallesSeleccionado(indice: Int) {
        if (indice < 0 || indice >= frutas.size) {
            view.mostrarError("Selecciona una fruta valida");
            return;
        }
        val id = frutas[indice].id;
        view.navegarADetalle(id);
    }
}