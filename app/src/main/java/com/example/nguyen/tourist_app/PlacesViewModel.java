package com.example.nguyen.tourist_app;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.nguyen.tourist_app.dataModel.WikipediaPage;

import java.util.Arrays;
import java.util.List;

public class PlacesViewModel extends ViewModel {
//    private static final List<String> placesList = Arrays.asList("Statue", "Scenic Overlook", "Art Museum",
//            "Market", "Museum of Natural History", "Temple", "Amusement Park", "City Hall", "Big Bridge");
    private LiveData<List<WikipediaPage>> placesListData;
    private PlacesRepository placesRepository;

    public PlacesViewModel() {

        placesRepository = new PlacesRepository();

        placesListData = placesRepository.getPlacesList();
    }

    public LiveData<List<WikipediaPage>> getPlacesList() {
        return placesListData;
    }


}
