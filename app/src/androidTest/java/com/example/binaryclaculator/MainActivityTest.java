package com.example.binaryclaculator;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    BinaryNumberCalculator binaryNumberCalculator;

    @Before
    public void setUp() throws Exception {
        binaryNumberCalculator = new BinaryNumberCalculator();
    }

    @Test
    public void add() {
        int a = Integer.parseInt("1111",2);
        int b = Integer.parseInt("1",2);

        String s = binaryNumberCalculator.add(a,b);
        String result = "10000";

        assertEquals(s,result);
    }

    @Test
    public void substract() {
        int a = Integer.parseInt("1111",2);
        int b = Integer.parseInt("1",2);

        String s = binaryNumberCalculator.substract(a,b);
        String result = "1110";

        assertEquals(s,result);
    }

    @Test
    public void typing(){
        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).onChildView(withId(R.id.button_0)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).onChildView(withId(R.id.button_1)).perform(click());

        onView(withId(R.id.textViewFirst)).check(matches(withText("01")));
    }

    @Test
    public void instanceState() throws InterruptedException {
        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).onChildView(withId(R.id.button_0)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).onChildView(withId(R.id.button_1)).perform(click());


        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(1000);
        onView(withId(R.id.textViewFirst)).check(matches(withText("01")));
        for(int i = 0;i<5;i++) {
            onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).onChildView(withId(R.id.button_1)).perform(click());
        }


        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Thread.sleep(1000);
        onView(withId(R.id.textViewFirst)).check(matches(withText("0111111")));


    }

}