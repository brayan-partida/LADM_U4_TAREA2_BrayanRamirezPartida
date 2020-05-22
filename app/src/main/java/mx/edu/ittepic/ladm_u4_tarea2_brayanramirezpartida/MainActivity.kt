package mx.edu.ittepic.ladm_u4_tarea2_brayanramirezpartida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var examples = arrayOf("Llamadas", "Alarma")
    var mySpinner: Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mySpinner = this.spn1
        // mySpinner.setOnItemSelectedListener(this)


        val s1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, examples)


        mySpinner!!.setAdapter(s1)

        btnBoton.setOnClickListener {

            if (mySpinner!!.selectedItem.equals("Llamadas")) {
                // Toast.makeText(this, "hola", Toast.LENGTH_LONG).show()

                var ejemplo1 = Intent(this, Calendario::class.java)
                startActivity(ejemplo1)
            }


            if (mySpinner!!.selectedItem.equals("Alarma")) {
                // Toast.makeText(this, "hola", Toast.LENGTH_LONG).show()

                var ejemplo2 = Intent(this, ejemplollamadas::class.java)
                startActivity(ejemplo2)
            }
        }//termina el boton========>


    }

}
