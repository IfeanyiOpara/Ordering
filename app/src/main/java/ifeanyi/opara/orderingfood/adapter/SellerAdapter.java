package ifeanyi.opara.orderingfood.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ifeanyi.opara.orderingfood.OrderActivity;
import ifeanyi.opara.orderingfood.R;
import ifeanyi.opara.orderingfood.model.Seller;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.ViewHolder> {

    private Context mContext;
    private List<Seller> sellerList = new ArrayList<>();

    public SellerAdapter(Context mContext, List<Seller> sellerList) {
        this.mContext = mContext;
        this.sellerList = sellerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.seller_row,parent,false);
        return new SellerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Seller seller = sellerList.get(position);
        holder.seller_name.setText(seller.getSeller());
        holder.slogan.setText(seller.getMotto());

        if (seller.getStatus() == 0){
            holder.status_online.setVisibility(View.VISIBLE);
            holder.status_offline.setVisibility(View.GONE);
        }
        else {
            holder.status_online.setVisibility(View.GONE);
            holder.status_offline.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Seller seller1 = sellerList.get(position);

                Intent intent = new Intent(mContext, OrderActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("sellerName", seller1.getSeller());
                intent.putExtra("sellerSlogan", seller1.getMotto());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView seller_name, slogan,status_online, status_offline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            seller_name = itemView.findViewById(R.id.seller_name);
            slogan = itemView.findViewById(R.id.slogan);
            status_online = itemView.findViewById(R.id.status_online);
            status_offline = itemView.findViewById(R.id.status_offline);
        }
    }

    public void setList(List<Seller> sellerList1){
        this.sellerList = sellerList1;
        notifyDataSetChanged();
    }
}
