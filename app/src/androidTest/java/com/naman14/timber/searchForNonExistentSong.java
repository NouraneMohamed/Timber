package com.naman14.timber;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.KeyEvent;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.naman14.timber.activities.MainActivity;

import org.hamcrest.CustomMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;

@RunWith(AndroidJUnit4ClassRunner.class)

public class searchForNonExistentSong {

    private static final String songName_NOTEXIST = "Jingle Bell Rock - Bobby Helms";
    private static final String nothingFound = "Nothing found ";
    @Rule
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkForNonExistentSong() {
        onView(withContentDescription(R.string.search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText(songName_NOTEXIST));
        pressKey(KeyEvent.KEYCODE_SEARCH);
        onView(withText(nothingFound)).check(doesNotExist());
    }

}
