package com.example.meinrechner;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList id;
    private ArrayList op1;
    private ArrayList operator;
    private ArrayList op2;
    private ArrayList result;
    private ArrayList time;

    public MyAdapter(Context context, ArrayList id, ArrayList op1, ArrayList operator, ArrayList op2, ArrayList result, ArrayList time) {
        this.context = context;
        this.id = id;
        this.op1 = op1;
        this.operator = operator;
        this.op2 = op2;
        this.result = result;
        this.time = time;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.op1.setText(String.valueOf(op1.get(position)));
        holder.operator.setText(String.valueOf(operator.get(position)));
        holder.op2.setText(String.valueOf(op2.get(position)));
        holder.result.setText(String.valueOf(result.get(position)));
        holder.time.setText(String.valueOf(time.get(position)));
        holder.id.setText(String.valueOf(id.get(position)));

        holder.itemView.setTag(id.get(position));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView op1,operator,op2,result,time, id;
        ImageButton delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            op1 = itemView.findViewById(R.id.op1);
            operator = itemView.findViewById(R.id.operator);
            op2 = itemView.findViewById(R.id.op2);
            result = itemView.findViewById(R.id.result);
            time = itemView.findViewById(R.id.timestamp);
            id = itemView.findViewById(R.id.id);
        }
    }

}
