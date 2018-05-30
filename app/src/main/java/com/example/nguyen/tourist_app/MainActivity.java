package com.example.nguyen.tourist_app;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nguyen.tourist_app.dataModel.WikipediaPage;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PlacesViewModel placesViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
 //   private List<String> touristSites = Arrays.asList("Statue","Scenic Viewpoint","ArtMuseum","City Hall");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        placesViewModel = ViewModelProviders.of(this).get(PlacesViewModel.class);
        LiveData<List<WikipediaPage>> placesData = placesViewModel.getPlacesList();
        placesData.observe(this, new Observer<List<WikipediaPage>>() {
            @Override
            public void onChanged(@Nullable List<WikipediaPage> places) {

                recyclerAdapter= new TouristRecyclerAdapter(places);
                recyclerView.setAdapter(recyclerAdapter);
            }
        });


//        placesViewModel = ViewModelProviders.of(this).get(PlacesViewModel.class);



    }

}
//public class PlacesViewModel extends ViewModel {
//
//    private static final List<String> placesList = Arrays.asList("Statue", "Scenic Overlook", "Art Museum",
//            "Market", "Museum of Natural History", "Temple", "Amusement Park", "City Hall", "Big Bridge");
//    private LiveData<List<String>> placesListData;
//
//    public PlacesViewModel() {
//        final MutableLiveData<List<String>> data = new MutableLiveData<>();
//        data.setValue(placesList);
//        placesListData = data;
//    }
//
//    public LiveData<List<String>> getPlacesList() {
//        return placesListData;
//    }
//}
