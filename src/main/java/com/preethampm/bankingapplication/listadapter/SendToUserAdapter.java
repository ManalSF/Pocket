package com.preethampm.bankingapplication.listadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.preethampm.bankingapplication.R;
import com.preethampm.bankingapplication.data.Client;

import java.util.ArrayList;

public class SendToUserAdapter extends RecyclerView.Adapter<SendToUserAdapter.ViewHolder> {
    private ArrayList<Client> clientArrayList;
    private OnUserListener onUserListener;

    public SendToUserAdapter(ArrayList<Client> clientArrayList, OnUserListener onUserListener) {
        this.clientArrayList = clientArrayList;
        this.onUserListener = onUserListener;
    }

    @NonNull
    @Override
    public SendToUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup, false);
        return new SendToUserAdapter.ViewHolder(view, onUserListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SendToUserAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(clientArrayList.get(position));
        viewHolder.userName.setText(clientArrayList.get(position).getLastName());
        viewHolder.userAccountBalance.setText(String.format("%d", clientArrayList.get(position).getBalance()));
    }

    @Override
    public int getItemCount() {
        return clientArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userName, userAccountBalance;
        OnUserListener onUserListener;

        public ViewHolder(@NonNull View itemView, OnUserListener onUserListener) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            userAccountBalance = itemView.findViewById(R.id.amount);
            this.onUserListener = onUserListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserListener.onUserClick(getAdapterPosition());
        }
    }

    public interface OnUserListener {
        void onUserClick(int position);
    }
}
