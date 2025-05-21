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

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val textView = findViewById<TextView>(R.id.flashCard1)
        val falseButton = findViewById<Button>(R.id.buttonFalse1)
        val trueButton = findViewById<Button>(R.id.buttonTrue1)

        val correctAnswer = true
        val currentScore = intent.getIntExtra("score", 0) // Get score from previous activity (default is 0)

        trueButton.setOnClickListener {
            val newScore = if (correctAnswer) currentScore + 1 else currentScore

            textView.text = if (correctAnswer) "Correct!" else "Incorrect!"
            textView.setTextColor(
                if (correctAnswer) getColor(android.R.color.holo_green_dark)
                else getColor(android.R.color.holo_red_dark)
            )

            trueButton.isEnabled = false
            falseButton.isEnabled = false

            textView.postDelayed({
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", newScore) // Pass updated score
                startActivity(intent)
                finish()
            }, 1000)
        }

        falseButton.setOnClickListener {
            val newScore = if (!correctAnswer) currentScore + 1 else currentScore

            textView.text = if (!correctAnswer) "Correct!" else "Incorrect!"
            textView.setTextColor(
                if (!correctAnswer) getColor(android.R.color.holo_green_dark)
                else getColor(android.R.color.holo_red_dark)
            )

            trueButton.isEnabled = false
            falseButton.isEnabled = false

            textView.postDelayed({
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", newScore) // Pass updated score
                startActivity(intent)
                finish()
            }, 1000)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
