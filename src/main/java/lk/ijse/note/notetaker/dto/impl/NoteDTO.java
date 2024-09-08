package lk.ijse.note.notetaker.dto.impl;

import lk.ijse.note.notetaker.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO implements SuperDTO {
    private String  noteId;
    private String  noteTitle;
    private String  noteDesc;
    private String  priorityLevel;
    private String createDate;
    private String userId;
}
