package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.NoteDTO;
import lk.ijse.note.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class NoteServiceIMPL implements NoteService {
    List<NoteDTO> saveNoteTemp = new ArrayList<>();

    public NoteServiceIMPL() {
        saveNoteTemp.add(new NoteDTO("NOTE 4f8a0a67-2ebc-41b2-9de6-4e9bcdba65bb", "First Note", "This is the first note","first","2024-08-25"));
        saveNoteTemp.add(new NoteDTO("NOTE 4f8a0a68-2ebc-41b2-9de6-4e9bcdba65bb", "First Note", "This is the first note","first","2024-08-25"));
        saveNoteTemp.add(new NoteDTO("NOTE 4f8a0a69-2ebc-41b2-9de6-4e9bcdba65bb", "First Note", "This is the first note","first","2024-08-25"));
        saveNoteTemp.add(new NoteDTO("NOTE 4f8a0a610-2ebc-41b2-9de6-4e9bcdba65bb", "First Note", "This is the first note","first","2024-08-25"));

    }

    @Override
    public String saveData(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteID());
        System.out.println(noteDTO);

        return "Saved successfully in BO layer";
    }


    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        if (noteId != null && noteDTO != null){
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteNote(String noteId) {

        if (noteId != null){
            return true;
        }
        return false;
    }



    @Override
    public NoteDTO getSelectedNote(String noteId) {
        if (noteId != null){

            return new NoteDTO(
                "NOTE 4f8a0a67-2ebc-41b2-9de6-4e9bcdba65bb",
                "REST services",
                "Explain the REST",
                "P1",
                "20240818"
            );
        }
        return null;
    }


    @Override
    public List<NoteDTO> getAllNotes() {
        List<NoteDTO> notes = new ArrayList<>(  );
        notes.add(new NoteDTO(AppUtil.createNoteID(), "First Note", "This is the first note","first","first-1"));
        notes.add(new NoteDTO(AppUtil.createNoteID(), "Second Note", "This is the second note","second","second-2"));
        notes.add(new NoteDTO(AppUtil.createNoteID(), "Third Note", "This is the third note","third","second-3"));

        return notes;
    }
}