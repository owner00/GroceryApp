package com.example.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryListItemsAdapter extends RecyclerView.Adapter<GroceryListItemsAdapter.ViewHolder> {

    private ArrayList<GroceryListItem> mGroceryList;

    public GroceryListItemsAdapter(ArrayList<GroceryListItem> groceryList) {
        mGroceryList = groceryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemGName;
        public TextView itemGQuantity;
        public TextView itemGAmount;

        public ViewHolder(View itemView) {
            super(itemView);

            itemGName = (TextView) itemView.findViewById(R.id.grocery_item_name);
            itemGQuantity = (TextView) itemView.findViewById(R.id.grocery_item_quantity);
            itemGAmount = (TextView) itemView.findViewById(R.id.grocery_item_total);
        }
    }


    @NonNull
    @Override
    public GroceryListItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View groceryItemView = inflater.inflate(R.layout.grocery_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(groceryItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryListItemsAdapter.ViewHolder holder, int position) {
        GroceryListItem grocItem = mGroceryList.get(position);

        TextView name = holder.itemGName;
        name.setText(grocItem.getGItemName());
        TextView quantity = holder.itemGQuantity;
        quantity.setText(grocItem.getGItemQuantity().toString());
        TextView amount = holder.itemGAmount;
        amount.setText(grocItem.getGTotalPrice().toString());
    }

    @Override
    public int getItemCount() {
        return mGroceryList.size();
    }
}
