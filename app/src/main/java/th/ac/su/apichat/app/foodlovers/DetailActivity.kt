package th.ac.su.apichat.app.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_item_food.*
import kotlinx.android.synthetic.main.list_item_food.tvTitle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val foodName = intent.getStringExtra("foodName")
        val description = intent.getStringExtra("description")
        val imageFile = intent.getStringExtra("imageFile")
        val detail = intent.getStringExtra("detail")
        val price = intent.getStringExtra("price")
        val reviewScore = intent.getStringExtra("reviewScore")


        tvFoodName.setText(foodName)
        //tvResturant.setText(price)
        tvDetail1.setText(description)

        tvPrice.setText(price)
        tvResturant.setText(detail)


        val res = resources
        val drawableId:Int = res.getIdentifier(imageFile,"drawable",packageName)
        imgView.setImageResource(drawableId)

        val drawableRs:Int = res.getIdentifier(reviewScore,"drawable",packageName)
        ratingView.setImageResource(drawableRs)



    }
}
