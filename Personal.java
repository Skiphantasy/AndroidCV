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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Personal extends Activity {
    private Button button;
    private ArrayList<EditText> editTexts;
    private RelativeLayout relLay;
    private Person person;
    private RadioGroup radioGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);
        relLay = findViewById(R.id.relay1);
        radioGroup = findViewById(R.id.radiogroup);
        editTexts = new ArrayList<>();

        for (int i = 0; i < relLay.getChildCount(); i++) {
            if(relLay.getChildAt(i) instanceof EditText) {
                editTexts.add((EditText)relLay.getChildAt(i));
            }
        }

        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex = "Hombre";

                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    if (radioGroup.getCheckedRadioButtonId() == radioGroup.getChildAt(i).getId()) {
                        RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i);
                        sex = radioButton.getText().toString();
                    }
                }

                person = new Person(editTexts.get(3).getText().toString(), sex,
                        editTexts.get(2).getText().toString(), editTexts.get(1).getText().toString(),
                        editTexts.get(0).getText().toString());
                Intent intent = new Intent(v.getContext(),Studies.class);
                intent.putExtra("parcel_data", person);
                startActivity(intent);
                //finish();
            }
        });
    }
}
