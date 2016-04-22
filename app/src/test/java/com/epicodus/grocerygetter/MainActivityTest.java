package com.epicodus.grocerygetter;

import android.os.Build;

import org.junit.runner.RunWith;


@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
}
