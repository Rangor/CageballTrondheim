package no.cageball.manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cageball extends Activity {
	
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void startMyEvents(View target) {
        startActivity(new Intent(Cageball.this, MyEvents.class));
    }

    public void startCageBallEvents(View target) {
        startActivity(new Intent(Cageball.this, CageballEvents.class));
    }

}
