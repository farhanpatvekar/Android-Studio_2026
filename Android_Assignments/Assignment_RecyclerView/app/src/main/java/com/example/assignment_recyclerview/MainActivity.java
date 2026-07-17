package com.example.assignment_recyclerview;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Product> products;
    public static ArrayList<Product> cartProducts;
    Toolbar toolbar;
    Intent intent;
    private View menuView;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBarMenu);
        setSupportActionBar(toolbar);
        initProducts();
        initCart();
        initViews();
    }


    public void initViews() {

        recyclerView = findViewById(R.id.recyclerView);
        productAdapter = new ProductAdapter(products);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                true
        ));
    }

    public void initProducts() {
        products = new ArrayList<Product>();

        products.add(new Product("laptop", 67000, R.drawable.laptop));
        products.add(new Product("SmartWatch", 645, R.drawable.smartwatch));
        products.add(new Product("macBook", 134300, R.drawable.macbook));
        products.add(new Product("Monitor", 10000, R.drawable.moniter));
        products.add(new Product("Phone", 13000, R.drawable.phone));
        products.add(new Product("Mouse", 900, R.drawable.mouse));
        products.add(new Product("Tablet", 45000, R.drawable.tablet));
        products.add(new Product("Watch", 1200, R.drawable.watch));
        products.add(new Product("KeyBoard", 700, R.drawable.keyboard));
        products.add(new Product("HeadPhone", 2300, R.drawable.headphone));
    }

    public void initCart() {
        cartProducts = new ArrayList<Product>();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int i = item.getItemId();

        if (i == R.id.cartOption) {
            intent = new Intent(this, CartView.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
