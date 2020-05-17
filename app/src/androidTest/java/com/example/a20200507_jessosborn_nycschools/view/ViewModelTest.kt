package com.example.a20200507_jessosborn_nycschools.view

import android.app.Application
import android.content.Context
import androidx.lifecycle.Observer
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolViewModel
import com.example.a20200507_jessosborn_nycschools.model.data.SchoolSATData
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*

class ViewModelTest {

    @Mock private lateinit var viewModel: SchoolViewModel
    @Mock private lateinit var context: Application

    private lateinit var fakeEmptyList:List<SchoolSATData>
    private lateinit var fakeList:List<SchoolSATData>


    @Before
    fun setup() {
        viewModel= SchoolViewModel()
        mockData()
        setupObservers()
    }

    @Test
    fun retrieveFreshViewModel(){
        with(viewModel){
            //Assign observers here
        }
        //Assert expected results here
        Assert.assertTrue(viewModel != null)
        Assert.assertTrue(viewModel.listOfSchools.value == null)
    }


    private fun mockData(){
        fakeEmptyList= emptyList()
        val mockList:MutableList<SchoolSATData>  = mutableListOf()
        //TODO: create constructor for SchoolSATData and pass in actual data to test against
        mockList.add(SchoolSATData())
        fakeList= mockList
    }


    private fun setupObservers(){
        //Mock observers here
        //example: isObserver = mock(Observer::class.java) as Observer<Boolean>
    }

}