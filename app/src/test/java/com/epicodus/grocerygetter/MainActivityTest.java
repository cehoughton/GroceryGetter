package com.epicodus.grocerygetter;

import android.content.Intent;
import android.os.Build;
import android.widget.EditText;

import com.epicodus.grocerygetter.ui.MainActivity;
import com.epicodus.grocerygetter.ui.ProfileActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;


@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        EditText nameEditText = (EditText) activity.findViewById(R.id.nameEditText);
        assertTrue("name".equals(nameEditText.getHint().toString()));
    }

    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.recipeButton).performClick();
        Intent expectedIntent = new Intent(activity, ProfileActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
