package com.asoto.fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity;
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.net.URL
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton.setOnClickListener{
            if (textViewHorizontal != null){
                //Muestra el toast al pulsar el botón con el móvil en horizontal y el fragment_detelle
                toast("horizontal")
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragmentland, Detalle.newInstance(), "Detalle")
                        .commit()


            }else{
                //En vertical muestra el texto del fragment_detalle y al pulsar el botón mouestra el valor del intent
                startActivity(intentFor<New>("id" to 5).singleTop())
            }
        }

    }




}
