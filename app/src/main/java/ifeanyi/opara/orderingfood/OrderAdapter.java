package ifeanyi.opara.orderingfood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context mContext;
    private List<Plates> platesList = new ArrayList<>();

    public OrderAdapter(Context mContext, List<Plates> platesList) {
        this.mContext = mContext;
        this.platesList = platesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.order_row,parent, false);
        return new OrderAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Plates plates = platesList.get(position);
        holder.food.setText(plates.getOrder());
        holder.amount.setText(plates.getAmount());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.deleteItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return platesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView amount,food;
        private ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.amount);
            food = itemView.findViewById(R.id.food);
            delete = itemView.findViewById(R.id.delet1);
        }

        public void deleteItem(){
            platesList.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
        }

    }

    public void setList(List<Plates> platesList1){
        this.platesList = platesList1;
        notifyDataSetChanged();
    }
}
