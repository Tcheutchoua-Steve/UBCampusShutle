package com.steeboon.steve.ubshuttle;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class LandMenu extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.land_menu);
        String[] myMenu = getResources().getStringArray(R.array.mainMenu);

        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.land_menu, R.id.land, myMenu));

        //Create listview for the regions
        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opt = ((TextView)view).getText().toString();

                //Identifying the deferent items clicked
                if (opt.equals("General Information")){
                    Intent i = new Intent(getApplicationContext(), GenInfo.class);
                    startActivity(i);
                }
                else if (opt.equals("Bus Schedules")){
                    Intent i = new Intent(getApplicationContext(), BusSchedule.class);
                    startActivity(i);
                }
                else if (opt.equals("Drivers Profile")){
                    Intent i = new Intent(getApplicationContext(), Drivers.class);
                    startActivity(i);
                }
            }
        });

    }


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.land_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
