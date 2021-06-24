package com.example.notekeeper;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {
    //let's add a static member of type DataManager
    static DataManager sDataManager;

    @BeforeClass
    public static void classSetUp() {
        sDataManager = DataManager.getInstance();//Let's acquire a reference to our DataManager and use it throughout the test class
    }


    //This will always run before any test method in this class
    @Before
    public void setUp() {
        sDataManager.getNotes().clear();// clear out the list of notes
        sDataManager.initializeExampleNotes(); //add some example notes to the data manager after clearing it.
        //This will make our test always start out with the same set of notes.
    }

    @Test
    public void createNewNote() {

        //setup test values for our note attributes
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        //creating a new note and putting the values in it
        int noteIndex = sDataManager.createNewNote();
        NoteInfo newNote = sDataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        //we perform the test to get the note and make sure the values that we expect
        //to be there are actually there.
        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
    }

    @Test
    public void findSimilarNotes() {
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText1 = "This is the body text of my test note";
        final String noteText2 = "This is the second body text of my note";


        int noteIndex1 = sDataManager.createNewNote();
        NoteInfo newNote1 = sDataManager.getNotes().get(noteIndex1);
        newNote1.setCourse(course);
        newNote1.setTitle(noteTitle);
        newNote1.setText(noteText1);

        int noteIndex2 = sDataManager.createNewNote();
        NoteInfo newNote2 = sDataManager.getNotes().get(noteIndex2);
        newNote2.setCourse(course);
        newNote2.setTitle(noteTitle);
        newNote2.setText(noteText2);

        //find the note index for the first new note and compare
        int findNoteIndex1 = sDataManager.findNote(newNote1);
        assertEquals(findNoteIndex1, noteIndex1);

        //find the note index for the second new note and compare
        int findNoteIndex2 = sDataManager.findNote(newNote2);
        assertEquals(findNoteIndex2, noteIndex2);
    }

    @Test
    public void createNewNoteOneStepCreation() {
        //data values used to create a new note test
        final CourseInfo course = DataManager.getInstance().getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        //method call for our new note
        int noteIndex = DataManager.getInstance().createNewNote(course, noteTitle, noteText);

        //get back the note at the noteIndex we just created.
        //Using asserts, make sure the note at that position has all the right values.
        NoteInfo compareNote = DataManager.getInstance().getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());

    }
}