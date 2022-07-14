package com.example.a220707kotlinpractice

import android.content.Context
import android.content.Intent
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_java.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_basic.setScaleType(ImageView.ScaleType.MATRIX)

        val matrix = Matrix()
        matrix.postRotate(100f)
        iv_basic.setImageMatrix(matrix)
    }


}