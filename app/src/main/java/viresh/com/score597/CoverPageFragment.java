package viresh.com.score597;



import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.view.Gravity;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import viresh.com.score597.R;
import viresh.com.score597.Soccer.SoccerRecyclerviewFragment;


public class CoverPageFragment extends Fragment {


    private OnButtonSelectedListener mListener;
    private SliderLayout sliderShow;


    public static CoverPageFragment newInstance(String param1, String param2) {
        CoverPageFragment fragment = new CoverPageFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;

    }

    public CoverPageFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }



    }

    Button button;
    TextView textView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.fragment_cover, container, false);

        SliderLayout sliderShow = (SliderLayout) rootView.findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(getActivity());
        textSliderView
                .description("U-17 Suriname ingedeeld 2e ronde CFU WK-kwalificatie")
                .image("http://svb.sr/sites/default/files/slideshow/Suriname-U-17.png");
        sliderShow.addSlider(textSliderView);
        TextSliderView textSliderView1 = new TextSliderView(getActivity());
        textSliderView1
                .description("Suriname vrijwel zeker van volgende ronde U-17 voetbal")
                .image("http://svb.sr/sites/default/files/slideshow/IMG-20160720-WA009.jpg");
        sliderShow.addSlider(textSliderView1);
        TextSliderView textSliderView2 = new TextSliderView(getActivity());
        textSliderView2
                .description("Bekerkampioen Nishaan 42 heeft zondagavond in het André Kamperveen Stadion met 1-0")
                .image("http://svb.sr/sites/default/files/slideshow/DSC_6293.png");
        sliderShow.addSlider(textSliderView2);

        button = (Button) rootView.findViewById(R.id.btnbasketbal);
        textView = (TextView) rootView.findViewById(R.id.textView2);



//        blink(textView);


        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int id = view.getId();
                switch (id){

                    case R.id.btnbasketbal:
                        AlertDialog.Builder alert= new AlertDialog.Builder(getContext());
                        alert.setMessage("Coming Soon");
                        alert.setNegativeButton("OK", null);
                        AlertDialog dialog = alert.show();
                        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
                        messageText.setGravity(Gravity.CENTER);
                        dialog.show();
                        break;

                    case R.id.btnsoccer:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, SoccerRecyclerviewFragment.newInstance(0)).addToBackStack(null).commit();
                        break;

                    default:
                        break;
                }


            }
        };
        (rootView.findViewById(R.id.btnbasketbal)).setOnClickListener(onClickListener);
        (rootView.findViewById(R.id.btnsoccer)).setOnClickListener(onClickListener);
        return rootView;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnButtonSelectedListener {
        public void onButtonItemSelected(int position);
    }

//    private void blink(final TextView textView){
//        final Handler handler = new Handler();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int timeToBlink = 1000;    //in milissegunds
//                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //TextView txt = (TextView) rootViewfindViewById(R.id.usage);
//                        if(textView.getVisibility() == View.VISIBLE){
//                            textView.setVisibility(View.INVISIBLE);
//                        }else{
//                            textView.setVisibility(View.VISIBLE);
//                        }
//                        blink(textView);
//                    }
//                });
//            }
//        }).start();
//    }
}
