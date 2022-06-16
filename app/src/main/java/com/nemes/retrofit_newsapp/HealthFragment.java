package com.nemes.retrofit_newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {

    String api_key = "df61a47b5ba347439110cde09f5d2b70";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    String category = "health";
    RecyclerView recyclerView_health;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.health_fragment,null);

        recyclerView_health = view.findViewById(R.id.recyclerview_health);

        modelClassArrayList = new ArrayList<>();
        recyclerView_health.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerView_health.setAdapter(adapter);

        //find news method
        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api_key)
                .enqueue(new Callback<MainNews>() {
                    @Override
                    public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                        if (response.isSuccessful()){
                            modelClassArrayList.addAll(response.body().getArticles());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<MainNews> call, Throwable t) {

                    }
                });
    }
}
