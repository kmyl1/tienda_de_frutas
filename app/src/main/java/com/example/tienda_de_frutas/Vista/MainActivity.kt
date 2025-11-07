package com.example.tienda_de_frutas.Vista
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tienda_de_frutas.R;
import com.example.tienda_de_frutas.Contrato.MainContrato;
import com.example.tienda_de_frutas.Presentador.MainPresentador;

class MainActivity : AppCompatActivity(), MainContrato.View {

    private lateinit var presenter: MainPresentador;
    private lateinit var spinner: Spinner;
    private lateinit var btnVer: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = MainPresentador(this);
        spinner = findViewById(R.id.spFrutas)
        btnVer = findViewById(R.id.btnVerDetalles)

        presenter.cargarFrutas()

        btnVer.setOnClickListener {
            presenter.onVerDetallesSeleccionado(spinner.selectedItemPosition)
        }
    }

    override fun mostrarListaFrutas(nombres: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    override fun navegarADetalle(idFruta: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID_FRUTA, idFruta)
        startActivity(intent)
    }

    override fun mostrarError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}