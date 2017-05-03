package com.example.zyang3.shoppingcartexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;

public class ShoppingCartActivity extends AppCompatActivity {

    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);
        //setContentView(R.layout.content_shopping_cart);
        mCartList = ShoppingCartHelper.getCart();

        //Make sure to clear the selections
        for(int i = 0; i<mCartList.size(); i++){
            mCartList.get(i).selected = false;
        }//end of for statement

        //Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter((ListAdapter) mProductAdapter);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product selectedProduct = mCartList.get(position);
                if(selectedProduct.selected == true)
                    selectedProduct.selected = false;
                else
                    selectedProduct.selected = true;
                mProductAdapter.notifyDataSetInvalidated();
            }
        });

        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
        removeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Loop through and remove all the products that are selected
                //Loop backwards so that the remove works correctly
                for(int i = mCartList.size()-1; i>=0; i--){
                    if(mCartList.get(i).selected){
                        mCartList.remove(i);
                    }//end of if
                }//end of loop
                mProductAdapter.notifyDataSetChanged();
            }
        });
    }

}
