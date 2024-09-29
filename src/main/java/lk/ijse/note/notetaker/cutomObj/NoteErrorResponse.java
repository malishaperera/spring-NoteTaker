package lk.ijse.note.notetaker.cutomObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteErrorResponse implements NoteResponse, Serializable {
    private int errorCode;
    public String errorMessage;
}
