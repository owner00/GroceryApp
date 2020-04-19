package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SampleDialogFragment.SampleDialogFragmentListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<GroceryListItem> allGroceries;
    private GroceryListItemsAdapter adapter;
    int buttonclicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView2);
        allGroceries = GroceryListItem.createGroceryList(5);
        adapter = new GroceryListItemsAdapter(allGroceries);
        mRecyclerView.setAdapter(adapter);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        buttonclicked = 0;
    }


    public void createAlertDialog(View view) {
        new SampleDialogFragment().show(getFragmentManager(), "sample");
    }

    //if a user has clicked a dialog, the list should be emptied and a new one created
    //after the list should be updated with the values of the new list
    //if after this, the dialog is clicked again it should just add to the list
    //all this should happen while updating the recyclerView

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        buttonclicked++;
        if(buttonclicked == 1) {
            //create a new arraylist
            EditText gNameText = findViewById(R.id.item_name);
            EditText gQuantity = findViewById(R.id.item_quantity);
            EditText gUnitPrice = findViewById(R.id.unit_price);
            String itemName = gNameText.getText().toString();
            Integer quant = Integer.parseInt(gQuantity.getText().toString());
            Double unitPrice = Double.parseDouble(gUnitPrice.getText().toString());

            ArrayList<GroceryListItem> newList = new ArrayList<GroceryListItem>();
            int curSize = adapter.getItemCount();

            newList.add(new GroceryListItem(itemName, quant, unitPrice));

            allGroceries.addAll(newList);
            adapter.notifyItemRangeInserted(curSize, newList.size());
        }
        //update the actual arraylist
        else {
            EditText gNameText = findViewById(R.id.item_name);
            EditText gQuantity = findViewById(R.id.item_quantity);
            EditText gUnitPrice = findViewById(R.id.unit_price);
            String itemName = gNameText.getText().toString();
            Integer quant = Integer.parseInt(gQuantity.getText().toString());
            Double unitPrice = Double.parseDouble(gUnitPrice.getText().toString());

            GroceryListItem gIem = new GroceryListItem(itemName,quant,unitPrice);

            allGroceries.add(gIem);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
