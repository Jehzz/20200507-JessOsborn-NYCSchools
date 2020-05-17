package com.example.a20200507_jessosborn_nycschools.model.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20200507_jessosborn_nycschools.model.data.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.model.network.Network;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.a20200507_jessosborn_nycschools.utils.Constant.BASEURL;

public class Repository{

    private String TAG = "Repository";

    //TODO: Add local storage, only fetch copy if not already retrieved

    //Dataset
    private MutableLiveData<List<SchoolSATData>> allSchools;
    public LiveData<List<SchoolSATData>> getListOfSchools() {
        if (allSchools == null) {
            allSchools = new MutableLiveData<>();//School's SAT data will not change during a user's session
            loadSchoolsFromAPI();            // so it only needs to be loaded once
        }
        return allSchools;
    }

    //Error message
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public LiveData<String> getError() {
        return errorMessage;
    }


    private void loadSchoolsFromAPI() {
        Network network = new Network(BASEURL);
        Objects.requireNonNull(network.initRetrofit().getSchoolsList())
                .enqueue(new Callback<List<SchoolSATData>>() {
                    @Override
                    public void onResponse(@NotNull Call<List<SchoolSATData>> call, @NotNull Response<List<SchoolSATData>> response) {
                        Log.d(TAG, "onResponse: ");
                        if (response.isSuccessful()) {
                            allSchools.postValue(response.body());
                        } else {
                            Log.d(TAG, "Error Message:  " + response.message());
                            errorMessage.postValue(response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<List<SchoolSATData>> call, @NotNull Throwable t) {
                        Log.d(TAG, "Error Message:  " + t);
                        errorMessage.postValue(t.toString());
                    }
                });
    }
}