package pt.joaocruz04.firebasepusher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.p1_add).setOnClickListener(button_action);
        findViewById(R.id.p1_update).setOnClickListener(button_action);
        findViewById(R.id.p1_delete).setOnClickListener(button_action);

        findViewById(R.id.p2_add).setOnClickListener(button_action);
        findViewById(R.id.p2_update).setOnClickListener(button_action);
        findViewById(R.id.p2_delete).setOnClickListener(button_action);

        findViewById(R.id.p3_add).setOnClickListener(button_action);
        findViewById(R.id.p3_update).setOnClickListener(button_action);
        findViewById(R.id.p3_delete).setOnClickListener(button_action);


        events.add(new Event("1", null, new Author("john", "P1")));
        events.add(new Event("2", null, new Author("mike", "P2")));
        events.add(new Event("3", null, new Author("peter", "P3")));

    }


    View.OnClickListener button_action = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = Integer.parseInt((String)v.getTag());
            int id = v.getId();

            if (id==R.id.p1_add || id==R.id.p2_add || id==R.id.p3_add) {
                addEvent(events.get(tag-1));
            } else if (id==R.id.p1_update|| id==R.id.p2_update || id==R.id.p3_update) {
                updateEvent(events.get(tag-1));
            } else if (id==R.id.p1_delete|| id==R.id.p2_delete || id==R.id.p3_delete) {
                deleteEvent(events.get(tag-1));
            }
        }
    };


    private void addEvent(Event e) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("feeds").push();
        e.type = "ADD";
        e.author.displayName = "" + e.author.name + " " + Calendar.getInstance().getTimeInMillis();
        myRef.setValue(e);

    }

    private void updateEvent(Event e) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("feeds").push();
        e.type = "UPDATE";
        e.author.displayName = "" + e.author.name + " " + Calendar.getInstance().getTimeInMillis();
        myRef.setValue(e);
    }

    private void deleteEvent(Event e) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("feeds").push();
        e.type = "DELETE";
        e.author.displayName = "" + e.author.name + " " + Calendar.getInstance().getTimeInMillis();
        myRef.setValue(e);

    }
}
