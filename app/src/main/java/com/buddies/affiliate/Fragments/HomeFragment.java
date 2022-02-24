package com.buddies.affiliate.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.buddies.affiliate.Adapter.OfferAdapter;
import com.buddies.affiliate.Adapter.Adapters;
import com.buddies.affiliate.FourCompareActivity;
import com.buddies.affiliate.Model.OfferModel;
import com.buddies.affiliate.Model.SliderModel;
import com.buddies.affiliate.R;
import com.buddies.affiliate.IconActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }
    }

    ViewPager2 sliderView;
    ArrayList<SliderModel> arrayList;
    RecyclerView Offers;
    ArrayList<OfferModel> arrayListO;
    int lists[];
    TextView[] dots;
    LinearLayout fas,ele,shop,food,edu,ent,gro,health,hot,tra,shopping,cabs,foods,hol,dots_container;

    private Handler sliderHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

//        getFragmentManager().beginTransaction().commit()

//        getActivity().getSupportFragmentManager().beginTransaction().commit()

        sliderView = view.findViewById(R.id.image_slider);
        dots_container = view.findViewById(R.id.dots_container);
        Offers = view.findViewById(R.id.Offers);
        fas = view.findViewById(R.id.fas);
        ele = view.findViewById(R.id.ele);
        shop = view.findViewById(R.id.shop);
        food = view.findViewById(R.id.food);
        edu = view.findViewById(R.id.edu);
        ent = view.findViewById(R.id.ent);
        gro = view.findViewById(R.id.gro);
//        layout = view.findViewById(R.id.layout);
        health = view.findViewById(R.id.health);
        hot = view.findViewById(R.id.hot);
        tra = view.findViewById(R.id.tra);
        shopping = view.findViewById(R.id.shopping);
        cabs = view.findViewById(R.id.cabs);
        foods = view.findViewById(R.id.foods);
        hol = view.findViewById(R.id.hol);





        cabs.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FourCompareActivity.class);
            intent.putExtra("cat","cab");
            startActivity(intent);
        });

        shopping.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FourCompareActivity.class);
            intent.putExtra("cat","shopping");
            startActivity(intent);
        });


        foods.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FourCompareActivity.class);
            intent.putExtra("cat","foods");
            startActivity(intent);
        });

        hol.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FourCompareActivity.class);
            intent.putExtra("cat","hol");
            startActivity(intent);
        });


        tra.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Travel");
            startActivity(intent);
        });


        gro.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Grocery");
            startActivity(intent);
        });


        ent.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Entertainment");
            startActivity(intent);
        });


        edu.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Education");
            startActivity(intent);
        });


        food.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Food");
            startActivity(intent);
        });


        shop.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Shopping");
            startActivity(intent);
        });


        ele.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Electric");
            startActivity(intent);
        });


        fas.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Fashion");
            startActivity(intent);
        });


        health.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Health");
            startActivity(intent);
        });


        hot.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconActivity.class);
            intent.putExtra("cat","Hotel");
            startActivity(intent);
        });

        arrayList = new ArrayList<>();


        sliderView.setClipToPadding(false);
        sliderView.setClipChildren(false);
        sliderView.setOffscreenPageLimit(3);
        sliderView.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer(){

            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1- Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        sliderView.setPageTransformer(compositePageTransformer);

        sliderView.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
//                selectedDots(position);
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(slide);
                sliderHandler.postDelayed(slide,2000);

            }
        });



        Loadbanners();
        LoadOffers();
        setIndicators();

        return view;
    }

    private void selectedDots(int position) {

        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setTextColor(getResources().getColor(R.color.app));
            } else {
                dots[i].setTextColor(getResources().getColor(R.color.white));
            }
        }


    }

    private void setIndicators() {

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dots_container.addView(dots[i]);
        }

    }

    private Runnable slide = new Runnable() {
        @Override
        public void run() {
            sliderView.setCurrentItem(sliderView.getCurrentItem() + 1);
        }
    };


    private void LoadOffers() {

        arrayListO = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Offers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayListO.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    OfferModel model = ds.getValue(OfferModel.class);

                    arrayListO.add(model);

                }

                OfferAdapter sliderAdapter = new OfferAdapter(getActivity(),arrayListO);
                Offers.setAdapter(sliderAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void Loadbanners() {

        dots = new TextView[arrayList.size()];
        lists = new int[arrayList.size()];

        arrayList = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Banners").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot ds: snapshot.getChildren()){

                    SliderModel model = ds.getValue(SliderModel.class);

                    arrayList.add(model);
                    Adapters sliderAdapter = new Adapters(getActivity(),arrayList);
//                    sliderAdapter.notifyDataSetChanged();
                    sliderView.setAdapter(sliderAdapter);


                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        Loadbanners();
//        LoadOffers();


    }
}