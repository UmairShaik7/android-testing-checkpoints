package com.example.android.testing.notes.notes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.testing.notes.R;
import com.example.android.testing.notes.data.Note;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Note> mNotes;
    private NoteItemListener mItemListener;

    public NotesAdapter(List<Note> notes, NoteItemListener itemListener) {
        setList(notes);
        mItemListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.item_note, parent, false);

        return new ViewHolder(noteView, mItemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Note note = mNotes.get(position);

        viewHolder.title.setText(note.getTitle());
        viewHolder.description.setText(note.getDescription());
    }

    public void replaceData(List<Note> notes) {
        setList(notes);
        notifyDataSetChanged();
    }

    private void setList(List<Note> notes) {
        mNotes = checkNotNull(notes);
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public Note getItem(int position) {
        return mNotes.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;

        public TextView description;
        private NoteItemListener mItemListener;

        public ViewHolder(View itemView, NoteItemListener listener) {
            super(itemView);
            mItemListener = listener;
            title = (TextView) itemView.findViewById(R.id.note_detail_title);
            description = (TextView) itemView.findViewById(R.id.note_detail_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Note note = getItem(position);
            mItemListener.onNoteClick(note);

        }
    }
}
