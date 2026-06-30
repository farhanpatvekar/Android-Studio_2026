package com.example.demo_10_recyclerviewuserproduct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductandUserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int PRODUCT_VIEW_HOLDER = 1;
    private final static int USER_VIEW_HOLDER = 2;

    ArrayList<User> userArrayList;
    ArrayList<Product> productArrayList;
    TextView txtViewForUsername,txtViewForCity,txtViewProductName,txtViewForProductPrice;

    public ProductandUserAdapter(ArrayList<User> users, ArrayList<Product> products) {
        this.productArrayList = products;
        this.userArrayList = users;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewProductName = itemView.findViewById(R.id.txtViewProductName);
            txtViewForProductPrice = itemView.findViewById(R.id.txtViewForProductPrice);
        }
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewForUsername = itemView.findViewById(R.id.txtViewForUsername);
            txtViewForCity = itemView.findViewById(R.id.txtViewForCity);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View productView = layoutInflater.inflate(R.layout.product_view_holder, null);
            return new ProductViewHolder(productView);
        }else {
            View userView = layoutInflater.inflate(R.layout.user_view_holder,null);
            return new UserViewHolder(userView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductViewHolder) {
            txtViewProductName = holder.itemView.findViewById(R.id.txtViewProductName);
            txtViewForProductPrice = holder.itemView.findViewById(R.id.txtViewForProductPrice);

            Product product = productArrayList.get(position/2);
            txtViewProductName.setText(product.getProductName());
            txtViewForProductPrice.setText(product.getProductPrice() + "");
        }
        if (holder instanceof  UserViewHolder){
            txtViewForUsername = holder.itemView.findViewById(R.id.txtViewForUsername);
            txtViewForCity  = holder.itemView.findViewById(R.id.txtViewForCity);

            User user = userArrayList.get((position-1)/2);
            txtViewForUsername.setText(user.getUsername());
            txtViewForCity.setText(user.getUserCity());
        }
    }

    @Override
    public int getItemCount() {
        return userArrayList.size() + productArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return PRODUCT_VIEW_HOLDER;
        } else {
            return USER_VIEW_HOLDER;
        }
    }
}
