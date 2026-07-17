package com.example.assignment_recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> products;
    TextView TxtName, TxtPrice;
    ImageView viewImage;

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            viewImage = itemView.findViewById(R.id.productImage);
            TxtName = itemView.findViewById(R.id.productName);
            TxtPrice = itemView.findViewById(R.id.productPrice);
        }
    }
    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view, null);
        return new ProductViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        viewImage = holder.itemView.findViewById(R.id.productImage);
        TxtName = holder.itemView.findViewById(R.id.productName);
        TxtPrice = holder.itemView.findViewById(R.id.productPrice);

        Product product = products.get(position);

        viewImage.setImageResource(product.getProductImage());
        TxtName.setText(product.getProductName());
        TxtPrice.setText(product.getProductPrice() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductDetails.class);
                intent.putExtra("product", product);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}