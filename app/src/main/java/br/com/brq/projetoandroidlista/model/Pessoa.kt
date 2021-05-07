package br.com.brq.projetoandroidlista.model

import androidx.annotation.DrawableRes

class Pessoa(
    val nome: String,
    val idade: Int,
    @DrawableRes
    val photo: Int //
) {
}