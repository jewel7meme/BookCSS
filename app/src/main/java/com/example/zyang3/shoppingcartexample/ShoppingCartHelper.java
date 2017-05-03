package com.example.zyang3.shoppingcartexample;

/**
 * Created by zyang3 on 5/1/2017.
 */
import java.util.List;
import java.util.Vector;
import android.content.res.Resources;
public class ShoppingCartHelper {
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(Resources res){
        if(catalog == null){
            catalog = new Vector<Product>();
            catalog.add(new Product("Cell Biology",
                    "BIO 3600", "Cell Biology",
                    "by Alberts; Bruce", 6,
                    "9780815344322", 29.99, "Tracy Yang"));
        }//end of if
        return catalog;
    }//end of getCatalog

    public static List<Product> getCart(){
        if(cart == null){
            cart = new Vector<Product>();
        }//end of if
        return cart;
    }//end of getCart
}//end of class
