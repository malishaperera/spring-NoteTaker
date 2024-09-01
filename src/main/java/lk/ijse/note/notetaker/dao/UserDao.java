package lk.ijse.note.notetaker.dao;

import lk.ijse.note.notetaker.entity.NoteEntity;
import lk.ijse.note.notetaker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {
}
