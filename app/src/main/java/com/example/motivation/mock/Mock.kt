package com.example.motivation.mock

import com.example.motivation.util.MotivationConstantes
import com.example.motivation.util.MotivationConstantes.PHRASE_FILTER.ALL
import java.util.*

class Phrase(val description: String, val category: Int)

fun Int.random():Int = Random().nextInt(this)

class Mock {
    private val VALORES = MotivationConstantes.PHRASE_FILTER
    private val mListPhrases: List<Phrase> = listOf(
        Phrase("O dia só termina quando acabar!",VALORES.HAPPY),
        Phrase("O Começo é o início do fim!",VALORES.SUN),
        Phrase("Só digo uma coisa, não vou dizer nada!",VALORES.SUN),
        Phrase("Ordinária, tududu pahhh!!!",VALORES.HAPPY),
        Phrase("Molejão era bom, mas eu prefiro Raça Negra!",VALORES.SUN),
        Phrase("Teste de frase para ser testada!",VALORES.SUN),
        Phrase("Vc está vendo essa frase? Kibom!",VALORES.HAPPY),
        Phrase("Palmeiras não tem mundial!",VALORES.HAPPY),
        Phrase("360 é igual a 9",VALORES.SUN),
        Phrase("Cansei de escrever...",VALORES.HAPPY)

    )

    fun getPhrase(value: Int): String{
        val filtrado = mListPhrases.filter{it -> (it.category == value || value == ALL)}

        val rand = (filtrado.size).random()
        return filtrado[rand].description

    }
}