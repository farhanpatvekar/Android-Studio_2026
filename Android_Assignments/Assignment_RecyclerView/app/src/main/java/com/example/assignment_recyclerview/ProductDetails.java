package com.example.assignment_recyclerview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetails extends AppCompatActivity {

    Product product;
    Intent i;
    ImageView imageProduct;
    TextView txtViewName, txtViewPrice;
    Button addToCart;
    String name;
    int price, image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        initViews();
        bindViews();
    }

    public void initViews() {
        imageProduct = findViewById(R.id.imageProduct);
        txtViewName = findViewById(R.id.txtViewName);
        txtViewPrice = findViewById(R.id.txtViewPrice);
        addToCart = findViewById(R.id.addToCart);
    }

    public void bindViews() {
        i = getIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            product = i.getSerializableExtra("product", Product.class);
        } else {
            product = (Product) i.getSerializableExtra("product");
        }
        name = product.getProductName();
        price = product.getProductPrice();
        image = product.getProductImage();

        imageProduct.setImageResource(image);
        txtViewName.setText(name);
        txtViewPrice.setText(price + "");

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.cartProducts.add(product);
            }
        });
    }


}
