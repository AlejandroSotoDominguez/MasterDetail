package com.asoto.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import java.net.URL


class Detalle : Fragment() {
    // TODO: Rename and change types of parameters

    companion object {

        fun newInstance():Detalle{
            return Detalle()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false)

        doAsync {
            try{
                val respuesta = URL("http://18.203.139.184/wp5/?rest_route=/wp/v2/posts").readText()
                val miJSONArray = JSONArray(respuesta)

                for (jsonIndex in 0..(miJSONArray.length() - 1)) {
                    val idpost = miJSONArray.getJSONObject(jsonIndex).getString("id")
                    val titulo = miJSONArray.getJSONObject(jsonIndex).getString("title")
                    val resumen = miJSONArray.getJSONObject(jsonIndex).getString("body")
                    //DummyContent.addItem(DummyItem(idpost, titulo, resumen))
                }


                uiThread {
                    Log.d("LOGTAG", respuesta)
                }
            } catch (e: Exception) { // Si algo va mal lo capturamos
           // Log.d(DummyContent.LOGTAG,"Algo va mal: $e")
            }

        }


    }

}

data class DummyItem(val id: String, val title: String, val resumen: String) {
    // personalizamos toString para que nos devuelva el titulo
    override fun toString(): String = title
}
