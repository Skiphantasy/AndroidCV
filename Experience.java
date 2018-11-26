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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Experience extends Activity {
    private Button button, button1;
    ArrayList<CheckBox> checkBoxes;
    ArrayList<String> skills;
    RelativeLayout relLay;
    private ArrayList<Work> works;
    EditText editText, editText1;
    private Person person;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experience);
        Bundle bundle = getIntent().getExtras();
        person = (Person)bundle.get("parcel_data");
        relLay = findViewById(R.id.checkrelay);
        works = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        skills = new ArrayList<>();

        for (int i = 0; i < relLay.getChildCount(); i++) {
            checkBoxes.add((CheckBox)relLay.getChildAt(i));
        }

        editText = findViewById(R.id.textemprole);
        editText1 = findViewById(R.id.textempdate);
        button1 = findViewById(R.id.button5);
        button = findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < relLay.getChildCount(); i++) {
                    if(checkBoxes.get(i).isChecked()) {
                        skills.add(checkBoxes.get(i).getText().toString());
                    }
                }
                person.setWorks(works);
                Intent intent = new Intent(v.getContext(),Details.class);
                intent.putExtra("parcel_data", person);
                intent.putStringArrayListExtra("skills", skills);
                startActivity(intent);
                //finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Work work = new Work(editText.getText().toString(), editText1.getText().toString());
                works.add(work);
            }
        });
    }
}
