package br.com.brq.projetoandroidlista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetoandroidlista.model.Pessoa

// Com // são minhas anotações

//Classe extendida ao Adapter
class AdapterRecyclerView (
    val context: Context,
    val nossaListaDePessoas: ArrayList<Pessoa>,
    val onClick: ItemClickListener? = null

): RecyclerView.Adapter<ViewHolderPessoas>() {

    //Pssa neste metódo para definir qual layout que quer usar em cada item da lista
    /**
     * Passa neste método para definir qual o layout que vc quer usar em cada item da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPessoas{
        //Carrega a view com inflater
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_da_nossa_lista, parent, false)

        return ViewHolderPessoas(view, onClick)
    }

    /**
     * Verifica o número de elementos no array
     * Usa este método como base para carregar a sua lista (Para o adapter saber o total de elementos que vai utilizar)
     */
    override fun getItemCount(): Int {
        //Cria um item para cada
        //Usando o tamanho do array
        return nossaListaDePessoas.size
    }

    //Passa nesse metódo para popular cada item da lista
    override fun onBindViewHolder(holder: ViewHolderPessoas, position: Int) {
       nossaListaDePessoas.get(position).also{
           holder.textView_titulo.text = it.nome
           holder.textView_subtitulo.text = "Idade: ${it.idade}"
           holder.imageViewAvatar.setImageResource(it.photo)
       }
    }

}
/**
 * View onde serão manipulados os elementos da tela com o Kotlin
 */
class ViewHolderPessoas(itemView: View, private val onClick: ItemClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    var textView_titulo : TextView
    var textView_subtitulo: TextView
    var imageViewAvatar : ImageView

    init {

        textView_titulo = itemView.findViewById(R.id.textView_titulo)
        textView_subtitulo = itemView.findViewById(R.id.textView_subtitulo)
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)


    }

    override fun onClick(v: View?) {
        onClick?.onClickItem(v, adapterPosition)
    }

}
interface ItemClickListener {
    fun onClickItem(view: View?, position: Int)

}