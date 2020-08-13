package ifeanyi.opara.orderingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView orders;
    private List<Plates> platesList;
    private Button add, done;
    public String item, worth;
    private boolean a = true;

    RecyclerView recyclerView;
    Plates plates;
    String item1 = plates.getOrder();
    String amount1 = plates.getAmount();
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

        final Spinner spinnerItem = findViewById(R.id.spinnerItem);
        final String[] items = new String[]{"Rice", "Beans", "eba"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerItem.setAdapter(adapter);

        final Spinner worthItem = findViewById(R.id.spinnerWorth);
        String[] worths = new String[]{"100", "200", "300"};
        ArrayAdapter<String> adapterWorth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, worths);
        worthItem.setAdapter(adapterWorth);


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



                Toast.makeText(MainActivity.this, item1 + "," + amount1 + ",", Toast.LENGTH_SHORT).show();
            }
        });



    }
}