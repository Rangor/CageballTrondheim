package no.cageball.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by A2BSoft
 * User: martinmi
 * Date: 23.08.11
 * Time: 21.16
 * To change this template use File | Settings | File Templates.
 */
public class CreateCageballEvent extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_cageball_event);
    }
    
    public void createEventClick(View target){
    	Context context = getApplicationContext();
    	CharSequence text = "Cageball event laget";
    	int duration = Toast.LENGTH_SHORT;

    	Toast toast = Toast.makeText(context, text, duration);
    	toast.show();
    	finish();
    }
    
    public void cancelButtonClick(View target){
    	finish();
    }
}
