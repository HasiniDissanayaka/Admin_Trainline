package com.example.admintrainline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.example.admintrainline.databinding.ActivityTimetableBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Timetable extends AppCompatActivity  {


   private EditText time,number,start,end;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ActivityTimetableBinding binding;
    private Button save;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        binding = ActivityTimetableBinding.inflate(getLayoutInflater());

        start = findViewById(R.id.sstation);
        end = findViewById(R.id.estation);
        time = findViewById(R.id.time);
        number = findViewById(R.id.number);
        save = findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Timetable");

                String  Time = time.getText().toString().trim();
                String  Number = number.getText().toString().trim();
                String  Start = start.getText().toString().trim();
                String  End = end.getText().toString().trim();

                TimeHelper timeHelper = new TimeHelper(Time,Number,Start,End);
                reference.child(Number).setValue(timeHelper);

            }
        });


    }



}
