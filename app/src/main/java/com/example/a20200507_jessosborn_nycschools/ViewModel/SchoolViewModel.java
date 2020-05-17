package com.example.a20200507_jessosborn_nycschools.ViewModel;

import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20200507_jessosborn_nycschools.model.data.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.model.network.Network;
import com.example.a20200507_jessosborn_nycschools.model.repository.Repository;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.a20200507_jessosborn_nycschools.utils.Constant.BASEURL;

public class SchoolViewModel extends ViewModel implements Filterable {

    private String TAG = "SchoolViewModel";

    private Repository schoolRepository = new Repository();

    //Get data from Repo. Repo automatically fetches over network since it is not stored yet
    public LiveData<List<SchoolSATData>> getListOfSchools() {
        return schoolRepository.getListOfSchools();
    }

    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public LiveData<String> getError() {
        return errorMessage;
    }


    @Override
    public Filter getFilter() {
        //TODO: Implement Filter object, and its performFiltering(), and publishResults() methods
        //I can do this in Kotlin, unsure of how to implement the 'return object : Filter(){... in Java
        return null;
    }
}
