package com.example.sqliteread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }
    private lateinit var editText: EditText
    private lateinit var btnSave : Button
    private lateinit var rvMain: RecyclerView
    private lateinit var rvAdapter: RVAdapter

    private lateinit var notes: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notes = arrayListOf()
        rvMain = findViewById(R.id.rvMain)
        rvAdapter = RVAdapter(notes)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)
        editText = findViewById(R.id.etText)
        btnSave = findViewById(R.id.btSubmit)


            notes = databaseHelper.readData()
            rvAdapter.update(notes)


            btnSave.setOnClickListener {
                val Text = editText.text.toString()
                databaseHelper.saveData(Text)
                Toast.makeText(this, "Added successfully", Toast.LENGTH_LONG).show()
                notes = databaseHelper.readData()
                rvAdapter.update(notes)
                editText.text.clear()

            }

    }
}