package salmaan.ahmsal.com.customizablespinnerdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set dataset to spinner as following
        spinner.dataSet = arrayOf("Hello", "Lets", "See", "The", "Magic")

        // Add listener to the spinner
        spinner.selectionChanged { index, string ->
            textView.text = "$index: $string"
        }

        // Set selected value
        spinner.setSelectedValue("Magic")
    }
}
