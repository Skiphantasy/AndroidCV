/**
 * Author: Skipha
 * Date: 26 Oct 2018
 */

package com.skipha.cv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Details extends Activity {
    String[] titles;
    private Person person;
    ArrayList<String> skills;
    String[][]multi = new String[4][];
    ListView listView;
    int[] images = {R.drawable.tanita, R.drawable.education, R.drawable.work_logo, R.drawable.skills};
    MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        titles =  getResources().getStringArray(R.array.listview);
        listView = findViewById(R.id.finallist);
        skills = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        person = (Person) bundle.get("parcel_data");
        skills = bundle.getStringArrayList("skills");
        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
        multi[0] = new String[]{person.getName(), person.getAddress(), person.getSex(), person.getEmail(), person.getPhone()};
        multi[1] = new String[person.getEducations().size()];

        for (int i = 0; i < multi[1].length; i++) {
            multi[1][i] =  person.getEducations().get(i).getYear() + " - "
                    + person.getEducations().get(i).getNameTitle() + " - "
                    +  person.getEducations().get(i).getSchool();
        }

        multi[2] = new String[person.getWorks().size()];

        for (int i = 0; i < multi[2].length; i++) {
            multi[2][i] = person.getWorks().get(i).getDate() + " - "
                    + person.getWorks().get(i).getRole();
        }

        multi[3] = new String[skills.size()];

        for (int i = 0; i < multi[3].length; i++) {
            multi[3][i] = skills.get(i);
        }

        adapter = new MyAdapter(this, titles, multi, images);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
