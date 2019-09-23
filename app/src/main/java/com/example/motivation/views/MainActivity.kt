package com.example.motivation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.mock.Mock
import com.example.motivation.util.MotivationConstantes
import com.example.motivation.util.SecurityPrefereces
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private var mFilter: Int =  MotivationConstantes.PHRASE_FILTER.ALL
    private val mMock = Mock()
    private lateinit var mSecurityPrefereces: SecurityPrefereces

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPrefereces = SecurityPrefereces(this)

        // Seta Eventos
        setListeners()

        //Inicializa
        handleFilters(R.id.imageAll)
        refreshPhrase()
        verifyUserName()
    }
    override fun onClick(view: View?) {
        val id = view?.id
        val listId = listOf(R.id.imageAll,R.id.imageSun,R.id.imageHappy)
        if(id in listId){
            handleFilters(id)
        }else if (id == R.id.buttonNewPhrase){
            refreshPhrase()
        }

    }
    private fun verifyUserName(){
        textUserName.text = mSecurityPrefereces.getStoredString(MotivationConstantes.KEY.PERSON_NAME)

    }

    private fun setListeners(){
        imageAll.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)

    }

    private fun handleFilters(id: Int?) {
        if (id == R.id.imageAll){
            mFilter = MotivationConstantes.PHRASE_FILTER.ALL

        }else if (id == R.id.imageSun){
            mFilter = MotivationConstantes.PHRASE_FILTER.SUN

        }else {
            mFilter = MotivationConstantes.PHRASE_FILTER.HAPPY
        }
    }
    private fun refreshPhrase(){
        textPhrase.text = mMock.getPhrase(mFilter)

    }
}
