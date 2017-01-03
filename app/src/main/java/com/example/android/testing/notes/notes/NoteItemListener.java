package com.example.android.testing.notes.notes;

import com.example.android.testing.notes.data.Note;

/**
 * Listener for clicks on notes in the RecyclerView.
 */
public interface NoteItemListener {

    void onNoteClick(Note clickedNote);
}