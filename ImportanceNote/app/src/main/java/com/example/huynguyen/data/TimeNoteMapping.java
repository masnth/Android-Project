package com.example.huynguyen.data;

import java.util.HashMap;

/**
 * Created by Huy Nguyen on 6/18/2018.
 */

public class TimeNoteMapping {
    private HashMap<String, ListNote> timenote_map = new HashMap<String, ListNote>();

    public TimeNoteMapping() {
        for (int i = 0; i < 24; i++) {
            String timeString = (i < 10)?("0" + Integer.toString(i) + ":00"):
                                    (Integer.toString(i) + ":00");
            timenote_map.put(timeString, new ListNote());
        }
    }


}
