package ifeanyi.opara.orderingfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ifeanyi.opara.orderingfood.model.Order;
import ifeanyi.opara.orderingfood.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context mContext;
    private List<Order> orderList = new ArrayList<>();

    public OrderAdapter(Context mContext, List<Order> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.order_row,parent, false);
        return new OrderAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.food.setText(order.getOrder());
        holder.amount.setText(order.getAmount());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.deleteItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
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
            orderList.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
        }

    }

    public void setList(List<Order> orderList1){
        this.orderList = orderList1;
        notifyDataSetChanged();
    }
}
