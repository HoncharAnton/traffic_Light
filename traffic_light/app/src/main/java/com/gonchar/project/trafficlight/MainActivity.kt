package com.gonchar.project.trafficlight

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    @SuppressLint( "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        green_button.setOnClickListener {
            label.text = getString(R.string.activity_greenButton)
            screen.setBackgroundColor(resources.getInteger(R.color.main_background_greenButton))
        }
        yellow_button.setOnClickListener {
            label.text = getString(R.string.activity_yellowButton)
            screen.setBackgroundColor(resources.getInteger(R.color.main_background_yellowButton))
        }
        red_button.setOnClickListener {
            label.text = getString(R.string.activity_redButton)
            screen.setBackgroundColor(resources.getInteger(R.color.main_background_redButton))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("label", label.text as String)
        super.onSaveInstanceState(outState)
    }


    @SuppressLint("ResourceType")
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        label.text = savedInstanceState.getString("label")

        if(label.text == resources.getString(R.string.activity_redButton)){
            screen.setBackgroundColor(resources.getInteger(R.color.main_background_redButton))
        }else if (label.text == resources.getString(R.string.activity_yellowButton)){
            screen.setBackgroundColor(resources.getInteger(R.color.main_background_yellowButton))
        }else{
            screen.setBackgroundColor(resources.getInteger(R.color.main_background_greenButton))
        }
    }
}
