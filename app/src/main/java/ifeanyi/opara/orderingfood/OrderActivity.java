package ifeanyi.opara.orderingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ifeanyi.opara.orderingfood.adapter.OrderAdapter;
import ifeanyi.opara.orderingfood.adapter.SwallowPlateAdapter;
import ifeanyi.opara.orderingfood.model.Order;
import ifeanyi.opara.orderingfood.model.Seller;
import ifeanyi.opara.orderingfood.model.SwallowOrder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private LinearLayout normal,swallow,normalLayout, swallowLayout, normalButtonLayout, swallowButtonLayout;
    private EditText descriptionSwallow;
    private TextView user, motto;
    private ArrayList<Order> orderList;
    private List<SwallowOrder> swallowOrderList;
    private List<Seller> sellerList = new ArrayList<>();
    private Button add, addSwallow, done,cancel,swallowDone,swallowCancel;
    private View normal_view, swallow_view;
    private TextView normal_txt, swallow_txt;
    public String item, worth;
    public String item_swallow, worth_swallow;


    Intent intent;
    String  sellerName, sellerSlogan;

    RecyclerView recyclerView,recyclerViewSwallow;
//    Plates plates = platesList.get(platesList.size()-1);
    Order order;
//    Seller seller = sellerList.get(sellerList.size()-1);
    SwallowOrder swallowOrder;

    OrderAdapter orderAdapter;
    SwallowPlateAdapter swallowPlateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        sellerName = intent.getStringExtra("sellerName");
        sellerSlogan = intent.getStringExtra("sellerSlogan");

        recyclerView = findViewById(R.id.order_recycler_view);
        recyclerViewSwallow = findViewById(R.id.order_recycler_view_swallow);

        orderList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        orderAdapter = new OrderAdapter(getApplicationContext(), orderList);
        recyclerView.setAdapter(orderAdapter);


        add = findViewById(R.id.add);
        done = findViewById(R.id.done);
        cancel = findViewById(R.id.cancel);
        swallowDone = findViewById(R.id.swallow_done);
        swallowCancel = findViewById(R.id.swallow_cancel);
        user = findViewById(R.id.user);
        motto = findViewById(R.id.motto);
        normal = findViewById(R.id.normal);
        swallow = findViewById(R.id.swallow);
        normalButtonLayout = findViewById(R.id.normal_button_layout);
        swallowButtonLayout = findViewById(R.id.swallow_button_layout);
        descriptionSwallow = findViewById(R.id.descriptionSwallow);
        normalLayout = findViewById(R.id.normal_layout);
        swallowLayout = findViewById(R.id.swallow_layout);
        normal_view = findViewById(R.id.normal_view);
        swallow_view = findViewById(R.id.swallow_view);
        normal_txt = findViewById(R.id.normal_txt);
        swallow_txt = findViewById(R.id.swallow_txt);
        addSwallow = findViewById(R.id.addSwallow);

        user.setText(sellerName);
        motto.setText(sellerSlogan);


        final Spinner spinnerItem = findViewById(R.id.spinnerItem);
        final String[] items = new String[]{"", "Rice", "Beans", "dodo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerItem.setAdapter(adapter);

        final Spinner worthItem = findViewById(R.id.spinnerWorth);
        String[] worths = new String[]{"", "100", "200", "300"};
        ArrayAdapter<String> adapterWorth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, worths);
        worthItem.setAdapter(adapterWorth);

        final Spinner spinnerItemSwallow = findViewById(R.id.spinnerItemSwallow);
        final String[] itemSwallow = new String[]{"", "Amala", "Fufu", "Eba"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemSwallow);
        spinnerItemSwallow.setAdapter(arrayAdapter);

        final Spinner spinnerWorthSwallow = findViewById(R.id.spinnerWorthSwallow);
        String[] worthSwallow = new String[]{"", "100", "200", "300"};
        ArrayAdapter<String> adapterWorthSwallow = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, worthSwallow);
        spinnerWorthSwallow.setAdapter(adapterWorthSwallow);


        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normal_txt.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                swallow_txt.setTextColor(getResources().getColor(R.color.grey));
                normalLayout.setVisibility(View.VISIBLE);
                normal_view.setVisibility(View.VISIBLE);
                swallowLayout.setVisibility(View.GONE);
                swallow_view.setVisibility(View.GONE);
                normalButtonLayout.setVisibility(View.VISIBLE);
                swallowButtonLayout.setVisibility(View.GONE);
                orderList = new ArrayList<>();
                recyclerView.setVisibility(View.VISIBLE);
                recyclerViewSwallow.setVisibility(View.GONE);

                orderList = new ArrayList<>();
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                orderAdapter = new OrderAdapter(getApplicationContext(), orderList);
                recyclerView.setAdapter(orderAdapter);
            }
        });

        swallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swallow_txt.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                swallowLayout.setVisibility(View.VISIBLE);
                normalLayout.setVisibility(View.GONE);
                normal_txt.setTextColor(getResources().getColor(R.color.grey));
                swallow_view.setVisibility(View.VISIBLE);
                normal_view.setVisibility(View.GONE);
                normal_view.setVisibility(View.GONE);
                normalButtonLayout.setVisibility(View.GONE);
                swallowButtonLayout.setVisibility(View.VISIBLE);

                recyclerView.setVisibility(View.GONE);
                recyclerViewSwallow.setVisibility(View.VISIBLE);

                recyclerViewSwallow.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerViewSwallow.setLayoutManager(linearLayoutManager);
                swallowOrderList = new ArrayList<>();
                swallowPlateAdapter = new SwallowPlateAdapter(swallowOrderList,getApplicationContext());
                recyclerViewSwallow.setAdapter(swallowPlateAdapter);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = spinnerItem.getSelectedItem().toString();
                worth = worthItem.getSelectedItem().toString();

//                orders.append(item);
//                orders.append("(" + worth + ")" + " " +"|" + " ");

                if(worth.isEmpty()){
                    Toast.makeText(OrderActivity.this, "Please specify the amount!", Toast.LENGTH_SHORT).show();
                    return;
                }

                order = new Order(item, worth);
                orderList.add(order);
                orderAdapter.setList(orderList);


            }
        });

        addSwallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String description;
                item_swallow = spinnerItemSwallow.getSelectedItem().toString();
                worth_swallow = spinnerWorthSwallow.getSelectedItem().toString();

                if (!descriptionSwallow.getText().toString().trim().isEmpty()){
                    description = descriptionSwallow.getText().toString().trim();

                    swallowOrder = new SwallowOrder(item_swallow,worth_swallow,description);
                }
                else {
                    if (worth_swallow.isEmpty()){
                        Toast.makeText(OrderActivity.this, "Please specify the amount", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    swallowOrder = new SwallowOrder(item_swallow,worth_swallow,"NO SOUP");
                }
                swallowOrderList.add(swallowOrder);
                swallowPlateAdapter.setList(swallowOrderList);

            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(OrderActivity.this, PlatesActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("order", orderList);
//                intent.putExtras(bundle);
//                startActivity(intent);

                for(Order order1 : orderList){
//                    Log.d("item", order1.getOrder());
//                    Log.d("amount", order1.getAmount());
                    String[] order = {order1.getOrder()};
                    String[] amount = {order1.getAmount()};



                    for (String value : order) {
                        for (String s : amount) {
                            String a = value + " " + s;
                            Intent intent = new Intent(OrderActivity.this, PlatesActivity.class);
                            intent.putExtra("normalItem", a);
                            startActivity(intent);
//                            Log.d("item", a);
                        }
                    }

//                    Log.d("item",Arrays.toString(order));
//                    Log.d("amount",Arrays.toString(amount));


                }
            }
        });

        swallowDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(SwallowOrder swallowOrder1 : swallowOrderList){
                    Log.d("item", swallowOrder1.getSwallowItem());
                    Log.d("description", swallowOrder1.getDescription());
                    Log.d("amount", swallowOrder1.getWorthItem());
                }
            }
        });


    }
}