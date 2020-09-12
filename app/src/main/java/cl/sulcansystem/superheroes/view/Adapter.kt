package cl.sulcansystem.superheroes.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.sulcansystem.superheroes.R
import cl.sulcansystem.superheroes.model.HeroMini
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var heroName = itemView.txt_name_hero_list
    var heroImage = itemView.image_hero_list
}

class HeroAdapter (private var heroList : MutableList<HeroMini>) :
    RecyclerView.Adapter<HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view)
    }
    val heroSelected = MutableLiveData<HeroMini>()

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {

        holder.heroName.text = heroList.get(position).name
        Picasso.get().load(heroList.get(position).images_sm).into(holder.heroImage)

        holder.itemView.setOnClickListener{
            Log.d("viewholder", "${heroList.get(position)}")

        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }
    fun updateItems (it: List<HeroMini>) {
        heroList.clear()
        heroList.addAll(it)
        notifyDataSetChanged()
    }
}