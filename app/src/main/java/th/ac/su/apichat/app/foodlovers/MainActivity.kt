package th.ac.su.apichat.app.foodlovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.apichat.app.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.apichat.app.foodlovers.data.Food
import th.ac.su.apichat.app.foodlovers.data.FoodAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Food> = ArrayList<Food>()
    lateinit var arrayAdater: ArrayAdapter<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"food_data.json")

        //Log.i("data",jsonFileString)

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Food>>(){}.type

        var foodList : ArrayList<Food> = gson.fromJson(jsonFileString,listItemType)

        //Log.i("data",foodList[0].monsterName)

        itemList = foodList

        val adapter = FoodAdapter(this@MainActivity,itemList)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)    //ต้นทางไปปลายททาง
            intent.putExtra("foodName",itemList[position].foodName)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("imageFile",itemList[position].imageFile)
            intent.putExtra("price",itemList[position].price)
            intent.putExtra("detail",itemList[position].detail)
            intent.putExtra("reviewScore",itemList[position].reviewScore)

            startActivity(intent)
        }


    }
}