package com.example.hosein.store.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hosein.store.R;
import com.example.hosein.store.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> ProductList = new ArrayList<>();

    public ProductAdapter(@NonNull Context context, @LayoutRes ArrayList<Product> list) {
        super(context, 0 , list);
        this.context = context;
        ProductList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);

        Product currentProduct = ProductList.get(position);

        TextView name = (TextView)listItem.findViewById(R.id.txtName);
        name.setText(currentProduct.getName());

        TextView desc = (TextView) listItem.findViewById(R.id.txtDesc);
        desc.setText(currentProduct.getDesc());

        TextView price = (TextView) listItem.findViewById(R.id.txtPrice);
        price.setText(currentProduct.getPrice());

        return listItem;
    }
}
