package lk.ijse.note.notetaker.bo;

import lk.ijse.note.notetaker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteBo permits NoteBOIMPL{
    String saveData(NoteDTO noteDTO);
    boolean updateNote(String noteId,NoteDTO noteDTO);
    boolean deleteNote(String noteId);
    NoteDTO getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
