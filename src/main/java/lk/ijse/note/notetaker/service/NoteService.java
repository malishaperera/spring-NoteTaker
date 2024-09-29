package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.cutomObj.NoteResponse;
import lk.ijse.note.notetaker.dto.impl.NoteDTO;

import java.util.List;

public  interface NoteService  {
    void saveNote(NoteDTO noteDTO);
    void updateNote(String noteId, NoteDTO noteDTO);
    void deleteNote(String noteId);
    NoteResponse getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
