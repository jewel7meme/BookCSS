package com.example.zyang3.shoppingcartexample;

/**
 * Created by zyang3 on 5/1/2017.
 */
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter{
    private List<Product> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;

    public ProductAdapter(List<Product> list, LayoutInflater inflater, boolean showCheckbox){
        mProductList = list;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }//end of ProductAdapter

    @Override
    public int getCount(){
        return mProductList.size();
    }//end of getCount

    @Override
    public Object getItem(int position){
        return mProductList.get(position);
    }//end of getItem

    @Override
    public long getItemId(int position){
        return position;
    }//end of getItemId

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewItem item;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item, null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView.findViewById(R.id.ImageViewItem);
            item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem);
            item.productCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        }//end of if
        else{
            item = (ViewItem) convertView.getTag();
        }//end of else
        Product curProduct = mProductList.get(position);
        //item.productImageView.setImageDrawable(curProduct.productImage);
        item.productTitle.setText(curProduct.title);

        if(!mShowCheckbox){
            item.productCheckbox.setVisibility(View.GONE);
        }//end of if
        else{
            if(curProduct.selected == true)
                item.productCheckbox.setChecked(true);
            else
                item.productCheckbox.setChecked(false);
        }//end of else
        return convertView;
    }//end of getView

    private class ViewItem{
        ImageView productImageView;
        TextView productTitle;
        CheckBox productCheckbox;
    }//end of ViewItem
}//end of ProductAdapter
