package lv.luhmirin.sampleapp.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lv.luhmirin.sampleapp.R;
import lv.luhmirin.sampleapp.list.model.ShoppingItem;

class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingItemHolder> {

    private final Context context;

    private List<ShoppingItem> items;

    ShoppingListAdapter(@NonNull Context context) {
        this.context = context;
    }

    void setItems(List<ShoppingItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ShoppingItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShoppingItemHolder(LayoutInflater.from(context).inflate(R.layout.item_shopping_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ShoppingItemHolder holder, int position) {
        ShoppingItem item = items.get(position);

        holder.name.setText(item.getName());
        holder.price.setText(String.format("%.2f", item.getPrice()));
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ShoppingItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_name) public TextView name;
        @BindView(R.id.item_price) public TextView price;
        @BindView(R.id.item_description) public TextView description;

        ShoppingItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
