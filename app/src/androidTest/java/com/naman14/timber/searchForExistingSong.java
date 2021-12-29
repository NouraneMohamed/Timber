package com.naman14.timber;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.KeyEvent;
import android.widget.EditText;

import androidx.test.espresso.Root;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.naman14.timber.activities.MainActivity;

import org.hamcrest.CustomMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class searchForExistingSong {

    static final String songName_EXIST = "Your Power - PagalNew";

    @Rule
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkForExistingSong() {
        onView(withContentDescription(R.string.search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText(songName_EXIST));
        pressKey(KeyEvent.KEYCODE_SEARCH);
        onView(withText(songName_EXIST)).check(matches(isDisplayed()));
    }

}
