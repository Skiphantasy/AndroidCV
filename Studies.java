/**
 * Author: Skipha
 * Date: 26 Oct 2018
 */

package com.skipha.cv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Studies extends Activity {
    private TableLayout tableLay;
    private Button button, button1;
    private Person person;
    private ArrayList<Education> educations;
    private Spinner spinner;
    private EditText editText, editText1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studies);
        tableLay = findViewById(R.id.tablerow);
        button = findViewById(R.id.button4);
        button1 = findViewById(R.id.button3);
        educations = new ArrayList<>();
        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.editTextcenter);
        editText1 = findViewById(R.id.editText5);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            person = (Person)bundle.get("parcel_data");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setEducations(educations);
                Intent intent = new Intent(v.getContext(),Experience.class);
                intent.putExtra("parcel_data", person);
                startActivity(intent);
                //finish();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = spinner.getSelectedItem().toString();
                String date = editText1.getText().toString();
                String center = editText.getText().toString();
                Education education = new Education(title, date, center);
                educations.add(education);
                TextView textView = new TextView(v.getContext());
                textView.setText(date + " - " + title + " - " + center);
                tableLay.addView(textView);
            }
        });
    }
}
