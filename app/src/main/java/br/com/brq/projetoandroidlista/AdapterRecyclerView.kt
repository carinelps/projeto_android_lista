package br.com.brq.projetoandroidlista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//Classe extendida ao Adapter
class AdapterRecyclerView (
    val context: Context,
    val nossaListaDeAnimais: ArrayList<String>

): RecyclerView.Adapter<ViewHolderAnimais>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAnimais {
        //Carrega a view com inflater
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_da_nossa_lista, parent, false)

        return ViewHolderAnimais(view)
    }

    override fun getItemCount(): Int {
        //Cria um item para cada
        //Usando o tamanho do array
        return nossaListaDeAnimais.size
    }

    override fun onBindViewHolder(holder: ViewHolderAnimais, position: Int) {
       holder.textView_titulo.text = "$position - ${nossaListaDeAnimais[position]}"
    }

}

class ViewHolderAnimais (itemView : View) : RecyclerView.ViewHolder(itemView){
    var textView_titulo : TextView

    init {
        textView_titulo = itemView.findViewById(R.id.textView_titulo)
    }
}