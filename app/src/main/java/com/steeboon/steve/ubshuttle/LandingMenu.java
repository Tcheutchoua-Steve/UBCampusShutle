package com.steeboon.steve.ubshuttle;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class LandingMenu extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_menu_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.anding_menu, menu);
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
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.landing_menu_fragment, container, false);
            String[] list = getResources().getStringArray(R.array.mainMenu);

           // .setListAdapter(new ArrayAdapter<String>(this, R.layout.landing_menu_fragment, R.id.landMenuItem, list));
            //Relates to the values array in the value folder


            ListView lv = new ListView(getActivity().getApplicationContext());

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String opt = ((TextView) view).getText().toString();
                    // Identifying the different options
                    if (opt.equals("General Information")){
                        //call the corresponding activity
                        Intent i = new Intent(getActivity().getApplicationContext(), GenInfo.class);
                        startActivity(i);
                    }
                    else if (opt.equals("Bus Schedules")){
                        Intent i = new Intent(getActivity().getApplicationContext(), BusSchedule.class);
                        startActivity(i);
                    }
                    else if (opt.equals("Drivers Profile")){
                        Intent i = new Intent(getActivity().getApplicationContext(),Drivers.class);
                        startActivity(i);
                    }
                }
            });

            return rootView;
        }
    }
}
