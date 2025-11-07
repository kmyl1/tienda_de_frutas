package com.example.tienda_de_frutas.Presentador
import com.example.tienda_de_frutas.Contrato.DetailContrato;
import com.example.tienda_de_frutas.Modelo.Fruta;
import com.example.tienda_de_frutas.Modelo.FrutaRepositorio;
import java.util.Locale;
import kotlin.math.max;

class DetailPresentador(private val view: DetailContrato.View) : DetailContrato.Presenter {

    private var fruta:Fruta?=null;

    override fun cargarDetalles(idFruta: Int) {
        fruta = FrutaRepositorio.obtenerFrutaPorId(idFruta);
        fruta?.let {
            view.mostrarDetalles(
                it.nombre,
                it.descripcion,
                String.format(Locale.getDefault(), "%.2f", it.precio),
                it.stock.toString()
            )
        } ?: run {
            view.mostrarError("Fruta no encontrada");
        }
    }

    override fun actualizarCantidad(cantidad: Int) {
        val f = fruta;
        if (f == null) {
            view.mostrarError("Datos no disponibles");
            return
        }

        val safeCantidad = max(0, cantidad)

        if (safeCantidad > f.stock) {
            view.mostrarError("Stock insuficiente. Máximo: ${f.stock}");
            view.mostrarTotal("$0.00");
            return
        }

        view.ocultarError()
        val total = safeCantidad * f.precio;
        view.mostrarTotal(String.format(Locale.getDefault(), "$%.2f", total));
    }
}