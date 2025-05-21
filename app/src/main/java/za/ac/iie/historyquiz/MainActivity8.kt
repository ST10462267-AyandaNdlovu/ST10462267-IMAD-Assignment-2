package za.ac.iie.historyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity8 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main8)


        val msg1TextView = findViewById<TextView>(R.id.messageTextView1)
        val msg2TextView = findViewById<TextView>(R.id.messageTextView2)
        val msg3TextView = findViewById<TextView>(R.id.messageTextView3)
        val msg4TextView = findViewById<TextView>(R.id.messageTextView4)
        val msg5TextView = findViewById<TextView>(R.id.messageTextView5)
        val buttonExit = findViewById<Button>(R.id.exitBtn2)

        buttonExit.setOnClickListener {
            finishAffinity()




            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}