package mx.edu.ittepic.ladm_u4_tarea2_brayanramirezpartida

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.CallLog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_llamadad__ejemplo1.*

class ejemplollamadas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendario)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CALL_LOG
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CALL_LOG),
                1
            )
        }//if
        btnLlamadas.setOnClickListener {
            ListaLlamdas()
        }//TODO btnLlamadas------------------------------------------->
    }

    @SuppressLint("MissingPermission")
    private fun ListaLlamdas() {
        var llamadas = ""
        var cursor = contentResolver.query(CallLog.Calls.CONTENT_URI, null, null, null, null)

        if (cursor!!.moveToFirst()) {
            var numero = cursor.getColumnIndex(CallLog.Calls.NUMBER)
            var tipo = cursor.getColumnIndex(CallLog.Calls.TYPE)

            var name = cursor.getColumnIndex(CallLog.Calls.CACHED_NAME)
            var dia =cursor.getColumnIndex(CallLog.Calls.DATE)
            var d=cursor.getColumnIndex(CallLog.Calls.DURATION)

            do {
                llamadas += "Numero: " + cursor.getString(numero) + "\nTipo: " +
                        cursor.getString(tipo) + "\n Name: " +
                        cursor.getString(name) + "\n date"+
                        cursor.getString(dia)

            } while (cursor.moveToNext())
        }//if
        else {
            llamadas = "No hay data"
        }//else
        textLlamadas.setText(llamadas)
    }
//TODO de las llamada------------------------------>
}

