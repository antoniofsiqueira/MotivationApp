package com.example.motivation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.util.MotivationConstantes
import com.example.motivation.util.SecurityPrefereces
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSecurity: SecurityPrefereces

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurity = SecurityPrefereces(this)
        verifyUserName()

        buttonSave.setOnClickListener {this}
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if(id == R.id.buttonSave){
            handleSave()
        }
    }

    private fun verifyUserName(){
        val userName = mSecurity.getStoredString(MotivationConstantes.KEY.PERSON_NAME)
        if (userName != ""){
            startActivity(Intent(this,MainActivity::class.java))
        }
        editName.setText(userName)
    }
    private fun handleSave(){
       val name: String = editName.text.toString()
        if(!name.isNullOrEmpty()){
            Toast.makeText(this, getString(R.string.informe_nome),Toast.LENGTH_LONG).show()

        }else {
            mSecurity.storeString(MotivationConstantes.KEY.PERSON_NAME, name)
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Impede que seja possivel voltar a essa activity
            //finish()
        }

    }
}
