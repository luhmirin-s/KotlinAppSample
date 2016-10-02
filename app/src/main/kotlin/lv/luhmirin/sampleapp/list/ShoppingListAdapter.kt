package lv.luhmirin.sampleapp.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.pawegio.kandroid.inflateLayout
import kotlinx.android.synthetic.main.item_shopping_list.view.*
import lv.luhmirin.sampleapp.R
import lv.luhmirin.sampleapp.list.model.ShoppingItem

internal class ShoppingListAdapter(private val context: Context, var items: List<ShoppingItem> = emptyList()) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingItemHolder>() {

    fun setItemsAndNotify(items: List<ShoppingItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemHolder {
        return ShoppingItemHolder(context.inflateLayout(R.layout.item_shopping_list))
    }

    override fun onBindViewHolder(holder: ShoppingItemHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    internal class ShoppingItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ShoppingItem) {
            itemView.item_name.text = item.name
            itemView.item_price.text = "%.2f".format(item.price)
            itemView.item_description.text = item.description
        }
    }

}
