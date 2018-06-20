package com.example.huynguyen.data;

/**
 * Created by Huy Nguyen on 6/18/2018.
 */
// This is the class to hold the note and its importance level
// Implement the compareTo method to compare its importance level only


public class Note implements Comparable<Note>{
    private int imLevel;
    private String note;

    public Note() {
        imLevel = 0;
        note = "";
    }

    public Note(int imLevelInput, String noteInput) {
        if (imLevelInput > 0) {
            imLevel = imLevelInput;
        }
        else {
            imLevel = 0;
        }

        note = noteInput;
    }

    public int getImportance() {
        return imLevel;
    }

    public String getNote() {
        return note;
    }

    @Override
    public int compareTo(Note other) {
        int result = this.imLevel - other.getImportance();
        return (result < 0) ? -1 : ((result == 0) ? 0 : 1);
    }
}
