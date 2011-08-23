package no.cageball.manager;

import java.util.ArrayList;

import no.cageball.manager.backend.JSONParser;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by A2BSoft
 * User: martinmi
 * Date: 23.08.11
 * Time: 21.16
 * To change this template use File | Settings | File Templates.
 */
public class CageballEventDetail extends Activity{
	
	TextView date;
	TextView place;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        ArrayList<String> cageballevents = JSONParser.getCageBallEvents(this);
        Bundle extras = getIntent().getExtras();
        
        int eventid = 0;
        if(extras.containsKey(Cageball.EVENT_ID)){
        	eventid = extras.getInt(Cageball.EVENT_ID);
        }
        
        String[] cageball = cageballevents.get(eventid).split("Sted:");
        
        setContentView(R.layout.cageball_event_detail);
        
        initViews();
        
        date.setText(cageball[0]);
        place.setText(cageball[1]);
    }
    
    public void initViews(){
    	date = (TextView)findViewById(R.id.date_text);
    	place = (TextView)findViewById(R.id.place_text);
    }

}
