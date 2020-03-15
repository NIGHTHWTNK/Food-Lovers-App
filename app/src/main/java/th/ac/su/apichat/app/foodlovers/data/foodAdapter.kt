package th.ac.su.apichat.app.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.list_item_food.view.*
import th.ac.su.apichat.app.foodlovers.R

class FoodAdapter(private val context: Context,
                  private  val dataSource:ArrayList<Food>) : BaseAdapter() {

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item_food, null)

        rowView.tvTitle.text = dataSource[position].foodName
        rowView.tvSubtitle.text = dataSource[position].description
        rowView.tvDetail.text = dataSource[position].price.toString()
        //rowView.tvResturant.text = dataSource[position].detail

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)
        val drawableRs:Int = res.getIdentifier(dataSource[position].reviewScore,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)
        //rowView.imgThumbnail.setImageResource(drawableRs)


        return  rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {

        return dataSource.size
    }
}