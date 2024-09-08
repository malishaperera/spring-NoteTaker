package lk.ijse.note.notetaker.service;

import lk.ijse.note.notetaker.cutomObj.UserResponse;
import lk.ijse.note.notetaker.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    String saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    UserResponse getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
}
