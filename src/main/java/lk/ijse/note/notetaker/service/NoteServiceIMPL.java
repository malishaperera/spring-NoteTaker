package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dao.NoteDao;
import lk.ijse.note.notetaker.dto.impl.NoteDTO;
import lk.ijse.note.notetaker.entity.NoteEntity;
import lk.ijse.note.notetaker.exception.DataPersistFailedException;
import lk.ijse.note.notetaker.exception.NoteNotFound;
import lk.ijse.note.notetaker.util.AppUtil;
import lk.ijse.note.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public  class NoteServiceIMPL implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private Mapping mapping;





    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteID());
        var noteEntity = mapping.convertToEntity(noteDTO);
        var saveNoted = noteDao.save(noteEntity);
        if (saveNoted == null) {
            throw new DataPersistFailedException("Can't save note");
        }

//        return "Saved successfully in Service layer";
    }





    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {
        Optional<NoteEntity> tmpNoteEntity = noteDao.findById(noteId);     //null handel
        if (!tmpNoteEntity.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            tmpNoteEntity.get().setNoteDesc(incomeNoteDTO.getNoteDesc());
            tmpNoteEntity.get().setNoteTitle(incomeNoteDTO.getNoteTitle());
            tmpNoteEntity.get().setCreateDate(incomeNoteDTO.getCreateDate());
            tmpNoteEntity.get().setPriorityLevel(incomeNoteDTO.getPriorityLevel());
        }

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