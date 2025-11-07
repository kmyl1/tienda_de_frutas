package com.example.tienda_de_frutas.Vista

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.tienda_de_frutas.R
import com.example.tienda_de_frutas.Contrato.DetailContrato
import com.example.tienda_de_frutas.Presentador.DetailPresentador

class DetailActivity : AppCompatActivity(), DetailContrato.View {

    companion object {
        const val EXTRA_ID_FRUTA = "ID_FRUTA"
    }

    private lateinit var presenter: DetailPresentador
    private lateinit var etCantidad: EditText
    private lateinit var tvTotal: TextView
    private lateinit var tvError: TextView
    private lateinit var tvNombre: TextView
    private lateinit var tvDescripcion: TextView
    private lateinit var tvPrecio: TextView
    private lateinit var tvStock: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter = DetailPresentador(this)

        etCantidad = findViewById(R.id.etCantidad)
        tvTotal = findViewById(R.id.tvTotal)
        tvError = findViewById(R.id.tvError)

        tvNombre = findViewById(R.id.tvNombre)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        tvPrecio = findViewById(R.id.tvPrecio)
        tvStock = findViewById(R.id.tvStock)

        val id = intent.getIntExtra(EXTRA_ID_FRUTA, -1)
        presenter.cargarDetalles(id)

        etCantidad.addTextChangedListener { editable ->
            val cantidad = editable?.toString()?.toIntOrNull() ?: 0
            presenter.actualizarCantidad(cantidad)
        }
    }

    override fun mostrarDetalles(nombre: String, descripcion: String, precio: String, stock: String) {
        tvNombre.text = nombre
        tvDescripcion.text = descripcion
        tvPrecio.text = "Precio: $${precio}"
        tvStock.text = "Stock: $stock"
    }

    override fun mostrarTotal(total: String) {
        tvTotal.text = "Total a pagar: $total"
    }

    override fun mostrarError(mensaje: String) {
        tvError.text = mensaje
        tvError.visibility = View.VISIBLE
    }

    override fun ocultarError() {
        tvError.visibility = View.GONE
    }
}