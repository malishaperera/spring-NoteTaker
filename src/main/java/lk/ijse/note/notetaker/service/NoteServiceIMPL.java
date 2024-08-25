package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.NoteDTO;
import lk.ijse.note.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        saveNoteTemp.add(noteDTO);
        System.out.println(noteDTO);

        return "Saved successfully in BO layer";
    }


    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {

        ListIterator<NoteDTO> updatedList = saveNoteTemp.listIterator();
        while (updatedList.hasNext()) {
            NoteDTO noteDTO = updatedList.next();
            if (noteId.equals(noteDTO.getNoteId())) {
                incomeNoteDTO.setNoteId(noteDTO.getNoteId());
                updatedList.set(incomeNoteDTO);
                break;
            }
        }
    }


    @Override
    public void deleteNote(String noteId) {

//        for (NoteDTO noteDTO :saveNoteTemp){
//            if (noteDTO.getNoteId().equals(noteId)){
//                saveNoteTemp.remove(noteDTO);
//                return true;
//            }
//        }
//        return false;
        ListIterator<NoteDTO> tmpList = saveNoteTemp.listIterator();
        while (tmpList.hasNext()) {
            NoteDTO noteDTO = tmpList.next();
            if (noteId.equals(noteDTO.getNoteId())) {
                tmpList.remove();
            }
        }
    }



    @Override
    public NoteDTO getSelectedNote(String noteId) {

        for (NoteDTO noteDTO:saveNoteTemp){
            if (noteDTO.getNoteId().equals(noteId)){
                return noteDTO;
            }
        }
        return null;
    }


    @Override
    public List<NoteDTO> getAllNotes() {
        return saveNoteTemp;
    }
}