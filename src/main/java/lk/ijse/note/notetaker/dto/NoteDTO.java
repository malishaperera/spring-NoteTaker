package lk.ijse.note.notetaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO implements Serializable {
    private String  noteId;
    private String  noteTitle;
    private String  noteDesc;
    private String  priorityLevel;
    private String createDate;
}
