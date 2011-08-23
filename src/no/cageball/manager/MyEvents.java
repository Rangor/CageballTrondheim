package no.cageball.manager;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import no.cageball.manager.backend.JSONParser;

import java.util.ArrayList;

public class MyEvents extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cageballevents);

        ArrayList<String> cageballevents = JSONParser.getMyCageBallEvents(this);
        System.out.println("Cageballs " + cageballevents.size());
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.eventitem, cageballevents));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

}
