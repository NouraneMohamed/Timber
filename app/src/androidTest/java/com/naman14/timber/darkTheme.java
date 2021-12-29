package com.naman14.timber;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.naman14.timber.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class darkTheme {

    @Rule
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void applyDarkTheme() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open()).check(matches(isOpen()));
        onView(withText("Settings")).perform(click());
        // Don't know how to specify the checkbox, they're all with the same ID
        onView(withId(R.id.checkbox)).check(matches(isChecked())).perform(scrollTo(), click());
    }

}
