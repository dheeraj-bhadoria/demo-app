package com.demoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.demoapp.R;
import com.demoapp.model.User;
import com.demoapp.user_interface.UserRepository;

import java.util.ArrayList;

public class UserRvAdapter extends RecyclerView.Adapter<UserRvAdapter.ViewHolder>{
    private ArrayList<User> listdata;
    private UserRepository userRepository;

    // RecyclerView recyclerView;
    public UserRvAdapter(ArrayList<User> listdata, UserRepository userRepository) {
        this.listdata = listdata;
        this.userRepository = userRepository;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.userName.setText(listdata.get(position).getName());
        holder.userMobile.setText(listdata.get(position).getMobile());

        holder.userEmail.setText(listdata.get(position).getEmail());

        holder.editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //
            }
        });

        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRepository.deleteUser(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView editItem, deleteItem;
        public TextView userName, userEmail, userMobile;

        public ViewHolder(View itemView) {
            super(itemView);
            this.editItem = (ImageView) itemView.findViewById(R.id.iv_edit);
            this.deleteItem = (ImageView) itemView.findViewById(R.id.iv_delete);

            this.userName = (TextView) itemView.findViewById(R.id.tv_Title);
            this.userMobile = (TextView) itemView.findViewById(R.id.tv_MobileNumber);

            this.userEmail = (TextView) itemView.findViewById(R.id.tv_EmailID);

        }
    }
}