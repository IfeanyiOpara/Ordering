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
import ifeanyi.opara.orderingfood.R;
import ifeanyi.opara.orderingfood.model.SwallowOrder;

public class SwallowPlateAdapter extends RecyclerView.Adapter<SwallowPlateAdapter.ViewHolder> {

    private List<SwallowOrder> swallowOrderList = new ArrayList<>();
    private Context mContext;

    public SwallowPlateAdapter(List<SwallowOrder> swallowOrderList, Context mContext) {
        this.swallowOrderList = swallowOrderList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.swallow_plate, parent,false);
        return new SwallowPlateAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        SwallowOrder swallowOrder = swallowOrderList.get(position);
        holder.swallow.setText(swallowOrder.getSwallowItem());
        holder.swallowAmount.setText(swallowOrder.getWorthItem());
        holder.descriptionSwallow.setText(swallowOrder.getDescription());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.deleteItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return swallowOrderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView swallow, swallowAmount, descriptionSwallow;
        private ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            swallow = itemView.findViewById(R.id.swallow);
            swallowAmount = itemView.findViewById(R.id.swallow_amount);
            descriptionSwallow = itemView.findViewById(R.id.description_swallow);
            delete = itemView.findViewById(R.id.deletSwallow);
        }

        public void deleteItem(){
            swallowOrderList.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
        }
    }

    public void setList(List<SwallowOrder> swallowOrderList1){
        this.swallowOrderList = swallowOrderList1;
        notifyDataSetChanged();
    }
}
