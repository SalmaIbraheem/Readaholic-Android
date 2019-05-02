package com.example.android.readaholic;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import com.example.android.readaholic.books.ReviewActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class ReviewTest {

    @Rule
    public ActivityTestRule<ReviewActivity> activityTestRule =
            new ActivityTestRule<>(ReviewActivity.class);

    @Test
    public void testemptyComment(){
        onView(withId(R.id.writercomment))
                .perform(typeText(""));


        onView(withId(R.id.sendcommentbtn))
                .perform(click());
        ReviewActivity activity = activityTestRule.getActivity();

        onView(withText("Please write something first")).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));

    }

    @Test
    public void testsuccesComment(){



        onView(withId(R.id.writercomment))
                .perform(typeText("good book "));

        onView(withId(R.id.sendcommentbtn))
                .perform(click());
        ReviewActivity activity = activityTestRule.getActivity();

        onView(withText("Something went wrong with the server")).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));

    }

    @Test
    public void testfaildComment(){
        onView(withId(R.id.writercomment))
                .perform(typeText("good book "));

        onView(withId(R.id.sendcommentbtn))
                .perform(click());
        ReviewActivity activity = activityTestRule.getActivity();

        onView(withText("Something went wrong with the server")).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));

    }

    @Test
    public void testWrongpassword(){
        onView(withId(R.id.SignIn_email_edittext))
                .perform(typeText("admin"));
        onView(withId(R.id.SignIn_password_edittext))
                .perform(typeText("123456"));

        onView(withId(R.id.SignIn_signin_btn))
                .perform(click());

        onView(withId(R.id.SignIn_error_textview))
                .check(matches(withText("Please check your email and password")));

    }

    @Test
    public void testEmptyUsername(){
        onView(withId(R.id.SignIn_email_edittext))
                .perform(typeText(""));
        onView(withId(R.id.SignIn_password_edittext))
                .perform(typeText("123456"));

        onView(withId(R.id.SignIn_signin_btn))
                .perform(click());

        onView(withId(R.id.SignIn_error_textview))
                .check(matches(withText("Please fill the username and password fields")));

    }

    @Test
    public void testEmptypassword(){
        onView(withId(R.id.SignIn_email_edittext))
                .perform(typeText("a"));
        onView(withId(R.id.SignIn_password_edittext))
                .perform(typeText(""));

        onView(withId(R.id.SignIn_signin_btn))
                .perform(click());

        onView(withId(R.id.SignIn_error_textview))
                .check(matches(withText("Please fill the username and password fields")));

    }


    @Test
    public void testInvalidCharacterInUsername(){
        onView(withId(R.id.SignIn_email_edittext))
                .perform(typeText("ahmed moh g "));
        onView(withId(R.id.SignIn_password_edittext))
                .perform(typeText("123456"));

        onView(withId(R.id.SignIn_signin_btn))
                .perform(click());

        onView(withId(R.id.SignIn_error_textview))
                .check(matches(withText("UserName or password should not contain spaces")));

    }

    @Test
    public void testInvalidCharacterInPassword(){
        onView(withId(R.id.SignIn_email_edittext))
                .perform(typeText("a12"));
        onView(withId(R.id.SignIn_password_edittext))
                .perform(typeText("12 34 56"));

        onView(withId(R.id.SignIn_signin_btn))
                .perform(click());

        onView(withId(R.id.SignIn_error_textview))
                .check(matches(withText("UserName or password should not contain spaces")));

    }


}


