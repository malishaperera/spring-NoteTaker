package lk.ijse.note.notetaker.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "notes")
public class NoteEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;

}
