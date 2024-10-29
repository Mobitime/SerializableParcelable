package com.example.serializableparcelable

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var persons: MutableList<Person>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persons = mutableListOf()
        val listView = findViewById<ListView>(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, persons.map { "${it.firstName} ${it.lastName}" })
        listView.adapter = adapter

        findViewById<Button>(R.id.buttonSave).setOnClickListener {
            savePerson()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val person = persons[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("firstName", person.firstName)
                putExtra("lastName", person.lastName)
                putExtra("address", person.address)
                putExtra("phone", person.phone)
            }
            startActivity(intent)
        }
    }

    private fun savePerson() {
        val firstName = findViewById<EditText>(R.id.editFirstName).text.toString()
        val lastName = findViewById<EditText>(R.id.editLastName).text.toString()
        val address = findViewById<EditText>(R.id.editAddress).text.toString()
        val phone = findViewById<EditText>(R.id.editPhone).text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
            val person = Person(firstName, lastName, address, phone)
            persons.add(person)
            adapter.add("${person.firstName} ${person.lastName}")
            adapter.notifyDataSetChanged()
        } else {
            Toast.makeText(this, "Заполните имя и фамилию", Toast.LENGTH_SHORT).show()
        }
    }
}
