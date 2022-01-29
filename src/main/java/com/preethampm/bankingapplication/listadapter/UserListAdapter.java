package com.preethampm.bankingapplication.listadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.preethampm.bankingapplication.R;
import com.preethampm.bankingapplication.data.Client;
import com.preethampm.bankingapplication.UserData;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private ArrayList<Client> clientArrayList;

    public UserListAdapter(Context context, ArrayList<Client> list) {
        clientArrayList = list;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userAccountBalance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.username);
            userAccountBalance = itemView.findViewById(R.id.amount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // still to be implemented
                }
            });
        }
    }

    @NonNull
    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.itemView.setTag(clientArrayList.get(position));
        viewHolder.userName.setText(clientArrayList.get(position).getLastName());
        viewHolder.userAccountBalance.setText(String.format("%d", clientArrayList.get(position).getBalance()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserData.class);
                intent.putExtra("NAME", clientArrayList.get(position).getLastName());
                intent.putExtra("EMAIL", clientArrayList.get(position).getEmail());
                intent.putExtra("BALANCE", String.valueOf(clientArrayList.get(position).getBalance()));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientArrayList.size();
    }
}
