package ifeanyi.opara.orderingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.google.android.material.resources.TextAppearance;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout normal,swallow,normalLayout, swallowLayout;
    private EditText descriptionSwallow;
    private TextView orders;
    private List<Plates> platesList;
    private Button add, addSwallow, done;
    private View normal_view, swallow_view;
    private TextView normal_txt, swallow_txt;
    public String item, worth;
    private boolean a = true;

    RecyclerView recyclerView;
//    Plates plates = platesList.get(platesList.size()-1);
    Plates plates;

    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.order_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        platesList = new ArrayList<>();
        orderAdapter = new OrderAdapter(getApplicationContext(), platesList);
        recyclerView.setAdapter(orderAdapter);


        add = findViewById(R.id.add);
        done = findViewById(R.id.done);
        normal = findViewById(R.id.normal);
        swallow = findViewById(R.id.swallow);
        normalLayout = findViewById(R.id.normal_layout);
        swallowLayout = findViewById(R.id.swallow_layout);
        normal_view = findViewById(R.id.normal_view);
        swallow_view = findViewById(R.id.swallow_view);
        normal_txt = findViewById(R.id.normal_txt);
        swallow_txt = findViewById(R.id.swallow_txt);

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
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = spinnerItem.getSelectedItem().toString();
                worth = worthItem.getSelectedItem().toString();

//                orders.append(item);
//                orders.append("(" + worth + ")" + " " +"|" + " ");

                plates = new Plates(item, worth);
                platesList.add(plates);
                orderAdapter.setList(platesList);


            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, PlatesActivity.class);
//
//                intent.putExtra("item", orders.getText().toString().trim());
//                intent.putExtra("worth", orders.getText().toString().trim());
//                startActivity(intent);
//
//                Plates plates = new Plates(item, worth);
//                platesList = new ArrayList<>();
//                platesList.add(plates);

//                String item1 = plates.getOrder();
//                String amount1 = plates.getAmount();

                Log.d("item", plates.getOrder());
                Log.d("amount", plates.getAmount());
            }
        });



    }
}