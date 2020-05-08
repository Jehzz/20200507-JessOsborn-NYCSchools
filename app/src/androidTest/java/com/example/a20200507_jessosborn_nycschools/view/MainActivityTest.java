package com.example.a20200507_jessosborn_nycschools.view;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.a20200507_jessosborn_nycschools.R;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testUI() {

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_schools_list)).check(matches(isDisplayed()));

        //TODO: Test Recyclerview contents
        //TODO: Test detailview fragment launch via onClick on the recyclerview
        //TODO: Test detailview fragment textviews
    }

    @After
    public void tearDown() throws Exception {
    }
}