package viresh.com.score597;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import viresh.com.score597.R;

import java.util.HashMap;



public class ScheduleDetailFragment extends Fragment {
    private static final String ARG_Match = "match";
    private static HashMap<String,?> match;
    private ShareActionProvider mShareActionProvider;
    private Intent intentShare;

    public static ScheduleDetailFragment newInstance(HashMap<String,?> match) {
        ScheduleDetailFragment fragment = new ScheduleDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_Match, match);
        fragment.setArguments(args);
        return fragment;
    }

    public ScheduleDetailFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if(getArguments() != null)
            match = (HashMap<String,?>)getArguments().getSerializable(ARG_Match);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_detailview03, container, false);



        TextView series = (TextView) rootView.findViewById(R.id.series);
        TextView match1date = (TextView) rootView.findViewById(R.id.match1date);
        TextView match1venue = (TextView) rootView.findViewById(R.id.match1venue);
        TextView match2date = (TextView) rootView.findViewById(R.id.match2date);
        TextView match2venue = (TextView) rootView.findViewById(R.id.match2venue);
        TextView match3date = (TextView) rootView.findViewById(R.id.match3date);
        TextView match3venue = (TextView) rootView.findViewById(R.id.match3venue);
        TextView match4date = (TextView) rootView.findViewById(R.id.match4date);
        TextView match4venue = (TextView) rootView.findViewById(R.id.match4venue);
        TextView match5date = (TextView) rootView.findViewById(R.id.match5date);
        TextView match5venue = (TextView) rootView.findViewById(R.id.match5venue);
        TextView match1 = (TextView) rootView.findViewById(R.id.match1);
        TextView match2 = (TextView) rootView.findViewById(R.id.match2);
        TextView match3 = (TextView) rootView.findViewById(R.id.match3);
        TextView match4 = (TextView) rootView.findViewById(R.id.match4);
        TextView match5 = (TextView) rootView.findViewById(R.id.match5);

        series.setText((String) match.get("series"));
        match1date.setText((String) match.get("match1"));
        String s1 = (String) match.get("match1");
        if(!(s1.isEmpty())){
            match1.setText("1");
        }
        match1venue.setText((String) match.get("venue1"));
        match2date.setText((String) match.get("match2"));
        String s2 = (String) match.get("match2");
        if(!(s2.isEmpty())){
            match2.setText("2");
        }
        match2venue.setText((String) match.get("venue2"));
        match3date.setText((String) match.get("match3"));
        String s3 = (String) match.get("match3");
        if(!(s3.isEmpty())){
            match3.setText("3");
        }
        match3venue.setText((String) match.get("venue3"));
        match4date.setText((String) match.get("match4"));
        String s4 = (String) match.get("match4");
        if(!(s4.isEmpty())){
            match4.setText("4");
        }
        match4venue.setText((String) match.get("venue4"));
        match5date.setText((String) match.get("match5"));
        String s5 = (String) match.get("match5");
        if(!(s5.isEmpty())){
            match5.setText("5");
        }
        match5venue.setText((String) match.get("venue5"));

        return rootView;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                System.exit(0);
                break;
            default: break;
        }    return true;

    }



}
