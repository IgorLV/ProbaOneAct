package com.example.probaoneact

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import java.security.AccessController.getContext


class CustomException(message: String): Exception(message)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    public final fun on_Click(view: View): Unit {

        val progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber);
        val rost = editTextNumber.text.toString().toDouble()
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2);
        val ves = editTextNumber2.text.toString().toDouble()
        val imt = ves/((rost/100.0)*(rost/100.0));

        val textView : TextView = findViewById<TextView>(R.id.textView);
        val imtstr = "%.2f".format(imt)

        val imtint = imt.toInt();

        var typ: String = "";
        if (imtint < 16)  typ = "Дистрофик";
        if (imtint in 16..18)  typ = "Худоба";
        if (imtint in 19..25)  typ = "Норма";
        if (imtint in 26..30)  typ = "Почти жирный";
        if (imtint in 31..35)  typ = "Жирный 1 степень";
        if (imtint in 36..40)  typ = "Жирный 2 степени";
        if (imtint > 40)  typ = "Жиртрест 3 степени";

        textView.text = "ИМТ: " + imtstr + " " + typ;

        progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
        if (imtint in 16..35)
            progressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        if (imtint in 19..25)
            progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));

        progressBar.max = 50;

        progressBar.progress = imtint;

    }

}


