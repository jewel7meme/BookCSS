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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetails);
        //setContentView(R.layout.content_product_details);
        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<Product> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);

        //Title
        TextView titleTextView = (TextView)findViewById(R.id.textViewTitle);
        titleTextView.setText(selectedProduct.title);
        //Author
        TextView authorTextView = (TextView)findViewById(R.id.textViewAuthor);
        authorTextView.setText(selectedProduct.author);
        //Edition
        TextView editionTextView = (TextView)findViewById(R.id.textViewEdition);
        editionTextView.setText(Integer.toString(selectedProduct.edition));
        //ISBN
        TextView isbnTextView = (TextView)findViewById(R.id.textViewISBN);
        isbnTextView.setText(selectedProduct.isbn);
        //CourseNumber
        TextView cNumberTextView = (TextView)findViewById(R.id.textViewCourseNumber);
        cNumberTextView.setText(selectedProduct.courseNumber);
        //CourseName
        TextView cNameTextView = (TextView)findViewById(R.id.textViewCourseName);
        cNameTextView.setText(selectedProduct.courseName);
        //Price
        TextView priceTextView = (TextView)findViewById(R.id.textViewPrice);
        priceTextView.setText(Double.toString(selectedProduct.price));
        //Seller Name
        TextView sellerNameTextView = (TextView)findViewById(R.id.textViewSellerName);
        sellerNameTextView.setText(selectedProduct.sellerName);

        Button addToCartButton = (Button)findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.add(selectedProduct);
                finish();
            }//end of onClick
        });

        //Disable the add to cart button if the item is already in the cart
        if(cart.contains(selectedProduct)){
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item in Cart");
        }//end of if
    }//end of onCreate

}//end of the class
