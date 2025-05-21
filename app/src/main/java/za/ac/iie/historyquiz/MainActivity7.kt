package za.ac.iie.historyquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity7 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        // Get the score from the Intent
        val score = intent.getIntExtra("score", 0)

        // Get references to the TextViews
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitBtn)

        // Display score
        scoreTextView.text = "$score/5"

        // Show message based on score
        val message = when {
            score >= 3 -> "Well done!"
            else -> "Keep working!"
        }

        messageTextView.text = message

        reviewButton.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
















            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
