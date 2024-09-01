package lk.ijse.note.notetaker.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.note.notetaker.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userId;
    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private String profilePicture;
    private List<NoteEntity> notes;
}
