package com.example.nguyen.tourist_app;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.provider.CallLog;

import com.example.nguyen.tourist_app.dataModel.QueryResponse;
import com.example.nguyen.tourist_app.dataModel.WikipediaPage;
import com.example.nguyen.tourist_app.dataModel.WikipediaResponse;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.Calls;

public class PlacesViewModelTest {
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    @Test
    public void testGetTouristSiteṣ̣̣̣̣(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://en.wikipedia.org")
//                .build();

        //PlacesViewModel viewModel = new PlacesViewModel(retrofit);
        MockWikipediaService mockWikipediaService=new MockWikipediaService();
        PlacesRepository placesRepository = new PlacesRepository(mockWikipediaService);
        PlacesViewModel.PlacesViewModelFactory factory= new PlacesViewModel.PlacesViewModelFactory(placesRepository);
        PlacesViewModel viewModel = factory.create(PlacesViewModel.class);

        LiveData<List<WikipediaPage>> touristSite = viewModel.getPlacesList();

        Assert.assertEquals("Statue",touristSite.getValue().get(0).getTitle());
    }
}
