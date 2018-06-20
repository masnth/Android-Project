package com.example.huynguyen.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Huy Nguyen on 6/19/2018.
 */

// this is the class to hold list of notes
// the maximum level is 20 (potentially)


public class ListNote{

    private Map<Integer, ArrayList<String>> ListNote;
    private SortedSet<Integer> keySet; // set that contains all key

/*    Comparator<ArrayList<Note>> arraylistNoteComparator = new Comparator<ArrayList<Note>>() {
        @Override
        public int compare(ArrayList<Note> a1, ArrayList<Note> a2) {
            if (a1 == null & a2 == null) {
                return 0;
            }
            else if (a1 == null) {
                return -1;
            }
            else if (a2 == null) {
                return 1;
            }
            return a1.get(0).compareTo(a2.get(0));
        }
    };*/

    public ListNote() {
        ListNote = new HashMap<Integer, ArrayList<String>>(40);
        keySet = new TreeSet<Integer>();
    }

    public void addNote(int imLevel, String newNote) {
        if (ListNote.containsKey(imLevel)) {
            ListNote.get(imLevel).add(newNote);
        }
        else {
            ArrayList<String> tempArrayList = new ArrayList<String>();
            tempArrayList.add(newNote);
            ListNote.put(imLevel, tempArrayList);
        }
        keySet.add(imLevel);
    }

    public ArrayList<String> getNote() {
        // retrieve the most important note
        return ListNote.get(keySet.last());
    }

    public boolean removeMax(String note) {
        return ListNote.get(keySet.last()).remove(note);
    }

    public int getSize() {
        // get the size of notes
        return ListNote.size();
    }


}
