package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dao.NoteDao;
import lk.ijse.note.notetaker.dto.NoteDTO;
import lk.ijse.note.notetaker.util.AppUtil;
import lk.ijse.note.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public  class NoteServiceIMPL implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private Mapping mapping;





    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteID());
        var noteEntity = mapping.convertToEntity(noteDTO);
        noteDao.save(noteEntity);
        return "Saved successfully in Service layer";
    }

    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {


    }


    @Override
    public boolean deleteNote(String noteId) {
//       return noteDao.deleteById(noteId);
        if (noteDao.existsById(noteId)){
            noteDao.deleteById(noteId);
            return true;
        }
        return false;

    }



    @Override
    public NoteDTO getSelectedNote(String noteId) {
        return mapping.convertToDTO(noteDao.getReferenceById(noteId));


    }


    @Override
    public List<NoteDTO> getAllNotes() {
       return mapping.convertToDTO(noteDao.findAll());
    }
}