package olga.ku.restcountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_country.view.*
import olga.ku.restcountries.R
import olga.ku.restcountries.model.Country

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountryHolder>() {
    val items = mutableListOf<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.layout_country,
            parent,
            false
        )
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.country = items[position]
    }


    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var country: Country? = null
            set(value) {
                field = value
                itemView.textViewName.text = value?.name
            }
    }
}