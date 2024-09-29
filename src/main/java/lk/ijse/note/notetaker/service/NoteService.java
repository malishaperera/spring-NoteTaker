package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.impl.NoteDTO;

import java.util.List;

public  interface NoteService  {
    void saveNote(NoteDTO noteDTO);
    void updateNote(String noteId, NoteDTO noteDTO);
    boolean deleteNote(String noteId);
    NoteDTO getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
