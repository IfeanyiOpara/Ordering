package ifeanyi.opara.orderingfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ifeanyi.opara.orderingfood.model.Order;
import ifeanyi.opara.orderingfood.R;

public class PlatesAdapter extends RecyclerView.Adapter<PlatesAdapter.ViewHolder> {

    private Context mContext;
    private List<Order> orderList;

    public PlatesAdapter(Context mcontext, List<Order> orderList) {
        this.mContext = mcontext;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.plates_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.orders.append(order.getOrder());
        holder.orders.append("(" + order.getAmount() + ")" + " " +"|" + " ");

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
        return orderList.size();
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
