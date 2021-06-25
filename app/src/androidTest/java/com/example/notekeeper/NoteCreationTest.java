package com.example.notekeeper;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    @Rule
    public ActivityScenarioRule<NoteListActivity> mNoteListActivity =
            new ActivityScenarioRule<>(NoteListActivity.class);

    @Test
    public void createNewNote() {

    }

}