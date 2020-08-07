package ifeanyi.opara.orderingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PlatesActivity extends AppCompatActivity {

    List<Plates> platesList;
    Plates plates;
    PlatesAdapter platesAdapter;

    String item, worth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plates);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        Bundle extras = getIntent().getExtras();

        if(extras != null){
            item = extras.getString("item");
            worth = extras.getString("worth");
            plates = new Plates(item,worth);
            platesList = new ArrayList<>();
            platesList.add(plates);

            platesAdapter = new PlatesAdapter(getApplicationContext(),platesList);
            recyclerView.setAdapter(platesAdapter);
        }

//           if (platesList != null){
//               platesAdapter = new PlatesAdapter(getApplicationContext(),platesList);
//               recyclerView.setAdapter(platesAdapter);
//           }


    }
}