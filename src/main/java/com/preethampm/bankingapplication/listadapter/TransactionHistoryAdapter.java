package com.preethampm.bankingapplication.listadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.preethampm.bankingapplication.R;
import com.preethampm.bankingapplication.data.Transfer;

import java.util.ArrayList;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {
    private ArrayList<Transfer> transferArrayList;

    public TransactionHistoryAdapter(Context context, ArrayList<Transfer> list) {
        transferArrayList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fromName, toName, amountTransferred, date, time;
        CardView cardView;
        LinearLayout toUserInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fromName = itemView.findViewById(R.id.t_from_name);
            toName = itemView.findViewById(R.id.t_to_name);
            amountTransferred = itemView.findViewById(R.id.t_amount);
            cardView = itemView.findViewById(R.id.transaction_card_view);
            toUserInfo = itemView.findViewById(R.id.to_user_info);
            date = itemView.findViewById(R.id.t_date);
            time = itemView.findViewById(R.id.t_time);

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
    public TransactionHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.transaction_history_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(transferArrayList.get(position));
        viewHolder.fromName.setText(transferArrayList.get(position).getClientDonneurTele());
        viewHolder.toName.setText(transferArrayList.get(position).getClientBeneficiaireTele());
        viewHolder.amountTransferred.setText(String.format("%d", transferArrayList.get(position).getMontantOperation()));


        if (true) {
            viewHolder.cardView.setCardBackgroundColor(Color.argb(100, 105, 187, 105));
        }
        else {
            viewHolder.cardView.setCardBackgroundColor(Color.argb(100, 239, 100, 100));
        }
    }

    @Override
    public int getItemCount() {
        return transferArrayList.size();
    }
}
