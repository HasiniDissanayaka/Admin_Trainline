package com.example.admintrainline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admintrainline.databinding.ActivityPriceChangeBinding;
import com.example.admintrainline.databinding.ActivityTimetableBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PriceChange extends AppCompatActivity {

    private EditText train,firstclass,secondclass,thiredclz;
    private Button add;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ActivityPriceChangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_change);
        binding = ActivityPriceChangeBinding.inflate(getLayoutInflater());

        train = findViewById(R.id.train);
        firstclass = findViewById(R.id.first);
        secondclass = findViewById(R.id.second);
        thiredclz = findViewById(R.id.thired);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("TicketPrices");


                String  Train = train.getText().toString().trim();
                String  First = firstclass.getText().toString().trim();
                String  Second = secondclass.getText().toString().trim();
                String  Thired = thiredclz.getText().toString().trim();

                PriceHelper priceHelper = new PriceHelper(Train,First,Second,Thired);
                reference.child(Train).setValue(priceHelper);


            }
        });


    }

}