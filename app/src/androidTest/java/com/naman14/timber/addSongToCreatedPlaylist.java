package com.naman14.timber;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.assertion.ViewAssertions.selectedDescendantsMatch;
import static androidx.test.espresso.matcher.ViewMatchers.hasFocus;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.widget.EditText;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.naman14.timber.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class addSongToCreatedPlaylist {

    private static final String songName = "Sorry - PagalNew";
    private static final String playlistName = "Favorite";
    private static final String toastMessage = "1 song added to playlist.";

    @Rule
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkToastMessage() {

        // Don't know how to specify the pop-up menu that I want to open from recyclerView
        // as they're all with the same ID
        onView(withText(songName)).perform(click());
        onView(withId(R.id.popup_menu)).perform(click());
        onView(withId(R.id.popup_song_addto_playlist)).perform(click());

        onView(withId(R.id.md_title)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText(playlistName));
        onView(withId(R.id.md_buttonDefaultPositive)).perform(click());
        onView(withText(toastMessage)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

    }

}
