package com.example.notekeeper;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static org.hamcrest.Matchers.*;
import static androidx.test.espresso.Espresso.pressBack;


@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    //add DataManager static field
    static DataManager sDataManager;
    //initialize DataManager instance
    @BeforeClass
    public static void classSetup() {
        sDataManager = DataManager.getInstance();
    }
    //launch Test Activity
    @Rule
    public ActivityScenarioRule<NoteListActivity> mNoteListActivity =
            new ActivityScenarioRule<>(NoteListActivity.class);

    @Test
    public void createNewNote() {
        //Let's get a reference to our variables
        final CourseInfo course = sDataManager.getCourse("java_lang");
        final String noteTitle = "This is the note Title";
        final String noteText = "This is the body of the text";

//        ViewInteraction fabNewNote = onView(withId(R.id.fab));
//        fabNewNote.perform(click());

        //we can also write the above class this way
        onView(withId(R.id.fab)).perform(click());

        //let's perform a click on our spinner before selecting our course with onData
        onView(withId(R.id.spinner_courses)).perform(click());

        //expanding our test to make use of the onData method and the pressBack method
        //we use the onData method to select a course from the spinner
        //When we use the onData method, rather than use view matchers, we use the hamcrest view matchers instead
        onData(allOf(instanceOf(CourseInfo.class), equalTo(course))).perform(click());//look through the AdapterView on this activity and then find the one that holds CourseInfo instance who is equal to our course variable. That will then go into our spinner and find the course that correspond.

        onView(withId(R.id.text_note_title)).perform(typeText(noteTitle));
        onView(withId(R.id.text_note_text)).perform(typeText(noteText), closeSoftKeyboard());


        //we use the pressBack method to return from NoteActivity to our NoteListActivity when we are done creating our new note
        pressBack();



    }

}