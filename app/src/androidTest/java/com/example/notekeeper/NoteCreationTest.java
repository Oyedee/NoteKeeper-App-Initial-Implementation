package com.example.notekeeper;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    //launch Test Activity
    @Rule
    public ActivityScenarioRule<NoteListActivity> mNoteListActivity =
            new ActivityScenarioRule<>(NoteListActivity.class);

    @Test
    public void createNewNote() {
//        ViewInteraction fabNewNote = onView(withId(R.id.fab));
//        fabNewNote.perform(click());

        //we can also write the above class this way
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.text_note_title)).perform(typeText("This is the note Title"));
        onView(withId(R.id.text_note_text)).perform(typeText("This is the body of the text"), closeSoftKeyboard());

    }

}