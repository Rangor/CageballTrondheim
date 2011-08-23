package no.cageball.manager;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import no.cageball.manager.backend.JSONParser;

import java.util.ArrayList;

/**
 * Created by A2BSoft
 * User: martinmi
 * Date: 23.08.11
 * Time: 20.27
 * To change this template use File | Settings | File Templates.
 */
public class CageballEvents extends ListActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.cageballevents);

        ArrayList<String> cageballevents = JSONParser.getCageBallEvents(this);

        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.eventitem, cageballevents));



    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
    	Intent intent = new Intent(CageballEvents.this, CageballEventDetail.class);
    	intent.putExtra(Cageball.EVENT_ID, position);
        startActivity(intent);
    }
}
