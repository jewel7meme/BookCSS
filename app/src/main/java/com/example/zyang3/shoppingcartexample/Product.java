package com.example.zyang3.shoppingcartexample;

/**
 * Created by zyang3 on 5/1/2017.
 */
import android.graphics.drawable.Drawable;

public class Product {
    public String title;
    //public Drawable productImage;
    public String courseNumber;
    public String courseName;
    public String author;
    public int edition;
    public String isbn;
    public double price;
    public boolean selected;
    public String sellerName;

        /*public Product(String title, Drawable productImage,
                       String courseNumber, String courseName,
                       String author, int edition,
                       String isbn, double price, String sellerName){
            this.title = title;
            this.productImage = productImage;
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.author = author;
            this.edition = edition;
            this.isbn = isbn;
            this.price = price;
            this.sellerName = sellerName;
        }*/

    public Product(String title,
                   String courseNumber, String courseName,
                   String author, int edition,
                   String isbn, double price, String sellerName){
        this.title = title;
        //this.productImage = productImage;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
        this.price = price;
        this.sellerName = sellerName;
    }

}
