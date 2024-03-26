package ru.yandex.practicum.sprint09koh15

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton
import java.io.Serializable

class SearchActivity : AppCompatActivity() {

    private var editTextValue: String? = null
    private var counter: Int = 0
    private lateinit var counterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        Log.d(TAG, "$this onCreate savedInstanceState=$savedInstanceState")

        findViewById<EditText>(R.id.edit_text).apply {
            addTextChangedListener {
                editTextValue = it?.toString()
                Log.d(TAG, "$this onTextChange editTextValue=$editTextValue")
            }
        }
        counterText = findViewById<TextView>(R.id.counter)
        findViewById<MaterialButton>(R.id.plus).setOnClickListener {
            counterText.text = (++counter).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "$this onSaveInstanceState counter=$counter")
        val data = MyData(id = "1", title = "1")
        outState.putString(KEY_EDIT_TEXT_VALUE, editTextValue)
        outState.putInt(KEY_COUNTER, counter)
        outState.putSerializable("my_data", data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "$this onRestoreInstanceState1 counter=$counter")
        editTextValue = savedInstanceState.getString(KEY_EDIT_TEXT_VALUE)
        counter = savedInstanceState.getInt(KEY_COUNTER)
        counterText.text = counter.toString()
        Log.d(TAG, "$this onRestoreInstanceState2 counter=$counter")
    }

    companion object {
        const val KEY_EDIT_TEXT_VALUE = "KEY_EDIT_TEXT_VALUE"
        const val KEY_COUNTER = "KEY_COUNTER"
        const val TAG = "SPRINT_9"
    }
}

data class MyData(
    val id: String,
    val title: String,
) : Serializable