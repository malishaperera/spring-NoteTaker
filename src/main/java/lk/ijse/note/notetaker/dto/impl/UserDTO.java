package lk.ijse.note.notetaker.dto.impl;

import lk.ijse.note.notetaker.cutomObj.UserResponse;
import lk.ijse.note.notetaker.dto.SuperDTO;
import lk.ijse.note.notetaker.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO, UserResponse {

    private String userId;
    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private String profilePicture;
    private List<NoteEntity> notes;
}
