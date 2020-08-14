package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.viewHolder> {
    ArrayList<Person> people;
    itemClicked activity;

    public interface itemClicked {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list) {
        activity = (itemClicked) context;
        people = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitems, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
//        holder.imageView.setTag(people.get(position));

        holder.name.setText(people.get(position).getName());
        holder.surname.setText(people.get(position).getSurname());
        if (people.get(position).getPrefrence().equals("Bus")) {
            holder.imageView.setImageResource(R.drawable.bus);
        } else {
            holder.imageView.setImageResource(R.drawable.plane);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, surname;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView2);
            surname = itemView.findViewById(R.id.textView);

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    activity.onItemClicked(people.indexOf((Person) view.getTag()));
                activity.onItemClicked(people.indexOf(view.getTag()));
                }
            });*/
        }
    }
}
