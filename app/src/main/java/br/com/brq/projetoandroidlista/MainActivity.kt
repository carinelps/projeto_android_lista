package br.com.brq.projetoandroidlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    //lateinit var recyclerView: RecyclerView
    lateinit var meuArrayDeAnimais: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()
        carregarArray()


        recyclerView?.adapter = AdapterRecyclerView(this, meuArrayDeAnimais)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun carregarElementos(){
        recyclerView = findViewById(R.id.rv_produtos)
    }

    fun carregarArray(){
        meuArrayDeAnimais = ArrayList()
        //Adicionando animais no array
        meuArrayDeAnimais.add("Cachorro")
        meuArrayDeAnimais.add("Gato")
        meuArrayDeAnimais.add("Passarinho")
    }
}