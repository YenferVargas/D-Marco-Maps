
package com.tecsup.edu.restaurantetrujillo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LugaresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)

        val menu_chan = findViewById<ImageView>(R.id.menu_chan)
        val menu_senor = findViewById<ImageView>(R.id.menu_señor)

        menu_chan.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("title", "Chan Chan")
            intent.putExtra("description", ".")
            intent.putExtra("latitude", -8.086934)
            intent.putExtra("longitude", -79.105946)
            startActivity(intent)
        }

        menu_senor.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("title", "Señor de Sipán")
            intent.putExtra("description", ".")
            intent.putExtra("latitude", -6.771648)
            intent.putExtra("longitude", -79.850743)
            startActivity(intent)
        }
    }
}



