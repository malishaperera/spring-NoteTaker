package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    boolean deleteUser(String userId);
    UserDTO getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
}
