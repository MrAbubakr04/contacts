package ru.appsmile.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.appsmile.RetrofitApi
import ru.appsmile.rickandmorty.adapter.ContactsAdapter
import ru.appsmile.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.layoutManager = LinearLayoutManager(this)


        RetrofitApi.getCharacter().enqueue(object : Callback<Item> {
            override fun onResponse(p0: Call<Item>, p1: Response<Item>) {

                if (p1.isSuccessful) {
                    val resultList = p1.body()?.results ?: emptyList()
                    Log.d("TAG_TEST", "должно работать ${p1.body()} ")
                    binding.root.adapter = ContactsAdapter(resultList)
                } else {
                    Log.d("TAG_TEST", "!isSuccessful: что то пошло не так")
                }
            }

            override fun onFailure(p0: Call<Item>, p1: Throwable) {
                Log.d("TAG_TEST", "onFailure: вообще что то пошло не так ${p1.message}")
            }
        })
    }
}