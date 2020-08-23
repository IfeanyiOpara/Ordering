package ifeanyi.opara.orderingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ifeanyi.opara.orderingfood.adapter.OrderAdapter;
import ifeanyi.opara.orderingfood.adapter.SellerAdapter;
import ifeanyi.opara.orderingfood.model.Seller;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SellerActivity extends AppCompatActivity {

    private List<Seller> sellerList;
    private RecyclerView recyclerView;
    private SellerAdapter sellerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        recyclerView = findViewById(R.id.seller_recycler_view);

        sellerList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        Seller seller = new Seller("Mama Ire", "..." + "healthy food brings life" + "...",1);
        Seller seller1 = new Seller("Mama Henry", "..." + "food is ready" + "...",0);
        Seller seller2 = new Seller("Mama John", "..." + "food plenty well well" + "...",1);
        Seller seller3 = new Seller("Mama Cass", "..." + "u go lick ur plate" + "...",1);
        Seller seller4 = new Seller("Mama Standard", "..." + "jollof rice sweet wella" + "...",0);

        sellerList.add(seller);
        sellerList.add(seller1);
        sellerList.add(seller2);
        sellerList.add(seller3);
        sellerList.add(seller4);

//        sellerAdapter.setList(sellerList);

        Log.d("sellers", String.valueOf(sellerList));

//        sellerAdapter.setList(sellerList);

        sellerAdapter = new SellerAdapter(getApplicationContext(), sellerList);
        recyclerView.setAdapter(sellerAdapter);
    }
}