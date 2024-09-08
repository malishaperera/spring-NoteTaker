package lk.ijse.note.notetaker.dao;

import lk.ijse.note.notetaker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String>  {

}
