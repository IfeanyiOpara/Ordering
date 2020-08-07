package ifeanyi.opara.orderingfood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlatesAdapter extends RecyclerView.Adapter<PlatesAdapter.ViewHolder> {

    private Context mContext;
    private List<Plates> platesList;

    public PlatesAdapter(Context mcontext, List<Plates> platesList) {
        this.mContext = mcontext;
        this.platesList = platesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.plates_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plates plates = platesList.get(position);
        holder.orders.append(plates.getOrder());
        holder.orders.append("(" + plates.getAmount() + ")" + " " +"|" + " ");

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                platesList.remove(getAdapterPosition());
//                notifyItemRemoved(getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return platesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView orders, delete, edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orders = itemView.findViewById(R.id.plates_order);
            delete = itemView.findViewById(R.id.delet1);
            edit = itemView.findViewById(R.id.edit1);
        }

    }
}
