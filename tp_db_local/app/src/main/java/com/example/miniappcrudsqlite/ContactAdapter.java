package com.example.miniappcrudsqlite;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    public Context context;
        public List<Contact> listeContact;

    public ContactAdapter(Context context, List<Contact> listeContact) {
            this.context = context;
            this.listeContact = listeContact;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent,false);
        ContactViewHolder ContactViewHolder = new ContactViewHolder(view);
        return ContactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder,@SuppressLint("RecyclerView") int position) {
        Contact contact = listeContact.get(position);
        holder.Name.setText(contact.getName());
        holder.Num.setText(contact.getNum());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,listeContact.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Confirmation suppression");
                        builder.setMessage("Voulez vous vraiement supprimer définetivement les infos de ce contact");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int positionStart=holder.getAdapterPosition();
                                ContactBDD db=new ContactBDD(context);
                                db.deleteContact(listeContact.get(positionStart));
                                Toast.makeText(context, "Suppression du contact"+listeContact.get(position).getName(), Toast.LENGTH_SHORT).show();
                                listeContact.remove(positionStart);
                                notifyItemRemoved(positionStart);
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        return false;
                    }
                });
    }

    @Override
    public int getItemCount() {
        if(!listeContact.isEmpty()){return listeContact.size();}
        else{
            return 0;
        }
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        TextView Num;
        public ContactViewHolder(@NonNull View itemView){
            super(itemView);
            Name=itemView.findViewById(R.id.nametext);
            Num = itemView.findViewById(R.id.numtext);
        }
    }
}
