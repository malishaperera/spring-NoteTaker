package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveNote(UserDTO userDTO);
    boolean updateNote(String userId, UserDTO userDTO);
    boolean deleteNote(String userId);
    UserDTO getSelectedNote(String userId);
    List<UserDTO> getAllNotes();
}
