package com.example.zyang3.shoppingcartexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CatalogActivity extends AppCompatActivity {
    private List<Product> mProductList;

    /**
     * Called when the activity is first created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);
        //setContentView(R.layout.content_catalog);
        //Obtain a reference to the product catalog
        mProductList = ShoppingCartHelper.getCatalog(getResources());

        //Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        //listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));
        listViewCatalog.setAdapter((ListAdapter) new ProductAdapter(mProductList, getLayoutInflater(), false));
        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }//end of onItemClick
        });

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }//end of onClick
        });
    }

}
