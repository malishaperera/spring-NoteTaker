package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.UserDTO;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public String saveNote(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean updateNote(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteNote(String userId) {
        return false;
    }

    @Override
    public UserDTO getSelectedNote(String userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllNotes() {
        return null;
    }
}
