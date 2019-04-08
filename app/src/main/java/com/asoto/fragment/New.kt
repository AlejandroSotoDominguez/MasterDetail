package com.asoto.fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class New : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val valor = intent.getIntExtra("id", 0)
        textView2.setText(valor.toString())

        //Si el estado de la activity es null carga el fragment detalle
        if (savedInstanceState == null ) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_new, Detalle.newInstance(), "Detalle")
                    .commit()
        }
    }
}
