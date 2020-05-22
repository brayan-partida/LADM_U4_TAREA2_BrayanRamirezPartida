package mx.edu.ittepic.ladm_u4_tarea2_brayanramirezpartida

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.calendario.*

class Calendario : AppCompatActivity() {

    private  val PROJECTION_ID_INDEX: Int = 0
    private  val PROJECTION_ACCOUNT_NAME_INDEX: Int = 1
    private  val PROJECTION_DISPLAY_NAME_INDEX: Int = 2
    private  val PROJECTION_OWNER_ACCOUNT_INDEX: Int = 3
    private val EVENT_PROJECTION: Array<String> = arrayOf(
        CalendarContract.Calendars._ID,                     // 0
        CalendarContract.Calendars.ACCOUNT_NAME,            // 1
        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,   // 2
        CalendarContract.Calendars.OWNER_ACCOUNT            // 3
    )


    val uri: Uri = CalendarContract.Calendars.CONTENT_URI
    val selection: String = "((${CalendarContract.Calendars.ACCOUNT_NAME} = ?) AND (" +
            "${CalendarContract.Calendars.ACCOUNT_TYPE} = ?) AND (" +
            "${CalendarContract.Calendars.OWNER_ACCOUNT} = ?))"
    val selectionArgs: Array<String> =
        arrayOf("brenramirezpa@ittepic.edu.mx", "brayan_71.6@hotmail.com")
    val cur: Cursor = contentResolver.query(uri, EVENT_PROJECTION, selection, selectionArgs, null)!!


    // The indices for the projection array above.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamadad__ejemplo1)


        button.setOnClickListener {
Dirigir()
        }//TODO btnLlamadas------------------------------------------->



    }

    private fun Dirigir(){
        while (cur.moveToNext()) {
            // Get the field values
            val calID: Long = cur.getLong(PROJECTION_ID_INDEX)
            val displayName: String = cur.getString(PROJECTION_DISPLAY_NAME_INDEX)
            val accountName: String = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX)
            val ownerName: String = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX)
            // Do something with the values..
        }
    }
}
