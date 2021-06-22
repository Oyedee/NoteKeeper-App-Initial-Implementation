package com.example.notekeeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {

    @Test
    public void createNewNote() {

        //setup test values for our note attributes
        DataManager dm = DataManager.getInstance();
        final CourseInfo course = dm.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        //creating a new note and putting the values in it
        int noteIndex = dm.createNewNote();
        NoteInfo newNote = dm.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        //we perform the test to get the note and make sure the values that we expect
        //to be there are actually there.
        NoteInfo compareNote = dm.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
    }
}