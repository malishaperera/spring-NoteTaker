package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteService permits NoteServiceIMPL {
    String saveData(NoteDTO noteDTO);
    boolean updateNote(String noteId,NoteDTO noteDTO);
    boolean deleteNote(String noteId);
    NoteDTO getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
