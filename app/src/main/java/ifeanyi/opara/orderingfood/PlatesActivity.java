package ifeanyi.opara.orderingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ifeanyi.opara.orderingfood.adapter.PlatesAdapter;
import ifeanyi.opara.orderingfood.model.Order;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlatesActivity extends AppCompatActivity {

    ArrayList<Order> orderList;
    Order order;
    PlatesAdapter platesAdapter;

    private TextView normal_item, normal_worth;

    //    Intent intent;
    Bundle extras;
    String normalItem, normalWorth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plates);

        normal_item = findViewById(R.id.normal_item);
        normal_worth = findViewById(R.id.normal_worth);

//        intent = getIntent();
//        normalItem = intent.getStringExtra("normalItem");
//        normalWorth = intent.getStringExtra("normalWorth");


//        Bundle bundleObject = getIntent().getExtras();
//        assert bundleObject != null;
//        orderList = (ArrayList<Order>) bundleObject.getSerializable("order");
//        assert orderList != null;
//        for (Order a : orderList){
//            Log.d("item", String.valueOf(a));
//        }
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager);

//        for(Order order1 : orderList){
//
//            String getOrder = order1.getOrder();
//            String getAmount = order1.getAmount();
//
//            normal_item.setText(getOrder);
//            normal_worth.setText(getAmount);
//
//        }

        extras = getIntent().getExtras();

//        if (extras != null){
//
//            for (String fetchList1 : getIntent().getStringExtra("normalItem")){
//                Log.d("item", fetchList1);
//            }
//        }

//        if(extras != null){
//            ArrayList[] ab = new ArrayList[Integer.parseInt(String.valueOf(extras.getStringArrayList("normalItem")))];
//            for (ArrayList a : ab){
//                Log.d("item", String.valueOf(a));
//            }
////            String[] order = {normalItem};
////            for (String a : ab){
////                Log.d("item", String.valueOf(a));
////            }
////            normal_item.setText(normalItem);
////            normal_worth.setText(normalWorth);
//
//        }
//
////           if (platesList != null){
////               platesAdapter = new PlatesAdapter(getApplicationContext(),platesList);
////               recyclerView.setAdapter(platesAdapter);
////           }
//
//
//    }
    }
}