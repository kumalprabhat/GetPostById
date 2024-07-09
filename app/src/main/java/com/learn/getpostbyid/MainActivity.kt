package com.learn.getpostbyid

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.learn.getpostbyid.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView: TextView = findViewById(R.id.textView)
        viewModel = ViewModelProvider(this)[PostViewModel::class.java]
        viewModel.getPostById("1")

        viewModel.post.observe(this, Observer {
            val id = it.id
            val title = it.title
            val body = it.body

            textView.text = "Id: $id \n" +
                    "Title: $title \n" +
                    "\n" +
                    "Body: $body"
        })
    }
}