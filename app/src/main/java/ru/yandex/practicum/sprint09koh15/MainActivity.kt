package ru.yandex.practicum.sprint09koh15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.go_to_search).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }
}