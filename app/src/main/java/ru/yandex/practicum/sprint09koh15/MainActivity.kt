package ru.yandex.practicum.sprint09koh15

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.go_to_search).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        Utils.vibrate(this)
        vibrate()

    }


}



class Utils {
    companion object {
        fun vibrate(context: Context) {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (vibrator.hasVibrator()) {
                // set vibration on 50 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(
                        VibrationEffect.createOneShot(
                            50,
                            VibrationEffect.DEFAULT_AMPLITUDE
                        )
                    )
                }
            }
        }
    }
}