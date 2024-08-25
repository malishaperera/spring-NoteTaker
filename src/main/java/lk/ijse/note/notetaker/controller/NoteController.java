package lk.ijse.note.notetaker.controller;


import lk.ijse.note.notetaker.service.NoteService;
import lk.ijse.note.notetaker.dto.NoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;


    //To Do CRUD Operation

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){

        //Todo: Handle with BO
        String savedNote = noteService.saveData(note);
        return ResponseEntity.ok(savedNote);
    }


    @GetMapping(value = "allNotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {

        List<NoteDTO> allNotes = new ArrayList<>();
        return noteService.getAllNotes();
    }



    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId)  {

//        NoteDTO selectedNote = noteBo.getSelectedNote(noteId);
        return noteService.getSelectedNote(noteId);

    }


    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){

        boolean updatedNote = noteService.updateNote(noteId, note);
        if (updatedNote){
            System.out.println("updatedNote:");
        }else {
            System.out.println("Note update unsuccessful:");
        }
    }



    @DeleteMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteNote(@PathVariable ("noteId") String noteId) {

        boolean deletedNote = noteService.deleteNote(noteId);
        if (deletedNote){
            System.out.println("deletedNote:");
        }else {
            System.out.println("Note delete unsuccessful:");
        }
    }


//    @GetMapping(value ="allNotes",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<NoteDTO> getAllNotes(){
//        return null;
//    }

}