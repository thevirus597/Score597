package viresh.com.score597;

import java.util.HashMap;

import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.Gravity;
import android.widget.TextView;


import viresh.com.score597.R;
import viresh.com.score597.Soccer.SoccerDetailFragment;
import viresh.com.score597.Soccer.SoccerRecyclerviewFragment;
import viresh.com.score597.Soccer.SoccerScheduleRecyclerviewFragment;


public class MainActivity extends ActionBarActivity implements viresh.com.score597.CoverPageFragment.OnButtonSelectedListener, SoccerRecyclerviewFragment.OnRecyclerViewItemSelectedListener,SoccerScheduleRecyclerviewFragment.OnRecyclerViewItemSelectedListener{
    private RelativeLayout mDrawer;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private  DrawerRecyclerAdapter mDrawerRecyclerViewAdapter;
    ImageView logo;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Score597");

        logo = (ImageView) findViewById(R.id.header);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        logo.startAnimation(animation);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawer = (RelativeLayout) findViewById(R.id.drawer);
        mDrawerList = (RecyclerView) findViewById(R.id.drawer_list);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));
        mDrawerRecyclerViewAdapter = new DrawerRecyclerAdapter(this,  (new DrawerData()).getDrawerList());
        mDrawerRecyclerViewAdapter.SetOnItemClickListener(new DrawerRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                selectItem(position);
            }

        });
        mDrawerList.setAdapter(mDrawerRecyclerViewAdapter);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                mToolbar,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        switch(position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CoverPageFragment()).commit();
                break;
            case 1:
                AlertDialog.Builder alert= new AlertDialog.Builder(this);
                alert.setMessage("Coming Soon");
                alert.setNegativeButton("OK", null);
                AlertDialog dialog = alert.show();
                TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
                messageText.setGravity(Gravity.CENTER);
                dialog.show();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, SoccerScheduleRecyclerviewFragment.newInstance(0)).addToBackStack(null).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CoverPageFragment()).addToBackStack(null).commit();
                break;
        }
        mDrawerLayout.closeDrawer(mDrawer);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onButtonItemSelected(int id){
        Intent intent;

    }


    @Override
    public void onItemSelected4(int position, HashMap<String, ?> match) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ScheduleDetailFragment.newInstance(match))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onItemSelected1(int position, HashMap<String, ?> match) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SoccerDetailFragment.newInstance(match))
                .addToBackStack(null)
                .commit();
    }



    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";


        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            int option= (Integer)getArguments().get(ARG_SECTION_NUMBER);
            switch(option) {
                case 0:
                    rootView = inflater.inflate(R.layout.about_me, container, false);
                    break;


                default:
                    rootView = inflater.inflate(R.layout.about_me, container, false);
                    break;


            }
            return rootView;
        }
    }
}
