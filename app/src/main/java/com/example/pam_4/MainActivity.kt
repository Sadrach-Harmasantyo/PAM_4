package com.example.pam_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pam_4.adapter.StudentAdapter
import com.example.pam_4.data.StudentModel
import com.example.pam_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: StudentAdapter
    private var itemList: ArrayList<StudentModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Soekarno", "12345678910"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Soeharto", "11121314151617181920"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Habibie", "21222324252627182930"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Gusdur", "31323334353637383940"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Megawati", "41424344454647484950"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Susilo Bambang Yudhoyono", "51525354555657585960"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Joko Widodo", "61626364656667686970"))
        itemList.add(StudentModel(R.drawable.ic_launcher_foreground, "Prabowo", "71727374757677787980"))

        itemAdapter = StudentAdapter(itemList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = itemAdapter

        binding.buttonAddItem.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val description = binding.editTextNim.text.toString()

            if (name.isNotEmpty() && description.isNotEmpty()) {
                val newItem = StudentModel(R.drawable.ic_launcher_foreground, name, description)
                itemList.add(0, newItem)
                itemAdapter.notifyDataSetChanged()

                binding.editTextName.text.clear()
                binding.editTextNim.text.clear()
            }
        }
    }
}

