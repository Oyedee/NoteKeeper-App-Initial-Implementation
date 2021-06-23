package com.example.notekeeper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {
    //This will always run before any test method in this class
    @Before
    public void setUp() {
        DataManager dm = DataManager.getInstance(); //get reference to DataManager
        dm.getNotes().clear();// clear out the list of notes
        dm.initializeExampleNotes(); //add some example notes to the data manager after clearing it.
        //This will make our test always start out with the same set of notes.
    }

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

    @Test
    public void findSimilarNotes() {
        DataManager dm = DataManager.getInstance();
        final CourseInfo course = dm.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText1 = "This is the body text of my test note";
        final String noteText2 = "This is the second body text of my note";


        int noteIndex1 = dm.createNewNote();
        NoteInfo newNote1 = dm.getNotes().get(noteIndex1);
        newNote1.setCourse(course);
        newNote1.setTitle(noteTitle);
        newNote1.setText(noteText1);

        int noteIndex2 = dm.createNewNote();
        NoteInfo newNote2 = dm.getNotes().get(noteIndex2);
        newNote2.setCourse(course);
        newNote2.setTitle(noteTitle);
        newNote2.setText(noteText2);

        //find the note index for the first new note and compare
        int findNoteIndex1 = dm.findNote(newNote1);
        assertEquals(findNoteIndex1, noteIndex1);

        //find the note index for the second new note and compare
        int findNoteIndex2 = dm.findNote(newNote2);
        assertEquals(findNoteIndex2, noteIndex2);
    }
}