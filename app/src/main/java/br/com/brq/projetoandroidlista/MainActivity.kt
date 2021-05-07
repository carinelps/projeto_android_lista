package br.com.brq.projetoandroidlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetoandroidlista.model.Pessoa

class MainActivity : AppCompatActivity(), ItemClickListener {

    var recyclerView: RecyclerView? = null

    //lateinit var recyclerView: RecyclerView
    lateinit var meuArrayDeAnimais: ArrayList<Pessoa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()
        carregarArray()


        AdapterRecyclerView(this, meuArrayDeAnimais, this).let {
            recyclerView?.adapter = it
        }
        //recyclerView?.adapter = AdapterRecyclerView(this, meuArrayDeAnimais)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_produtos)
    }

    fun carregarArray() {
        meuArrayDeAnimais = ArrayList()
        //Adicionando animais no array
        meuArrayDeAnimais.add(Pessoa("Carine", 22, R.drawable.ic_baseline_account_circle_24))

    }

    override fun onClickItem(view: View?, index: Int) {
        Toast.makeText(this, meuArrayDeAnimais[index].nome, Toast.LENGTH_SHORT).show()
    }

}