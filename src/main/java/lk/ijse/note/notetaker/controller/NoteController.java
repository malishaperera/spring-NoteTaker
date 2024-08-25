package lk.ijse.note.notetaker.controller;


import lk.ijse.note.notetaker.service.NoteService;
import lk.ijse.note.notetaker.dto.NoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        NoteDTO selectedNote = noteService.getSelectedNote(noteId);
        if (selectedNote != null){
            return noteService.getSelectedNote(noteId);
        }else {
            return null;
        }
    }


    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){

          noteService.updateNote(noteId, note);
          return ResponseEntity.ok("updatedNote:");

    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteNote(@PathVariable ("noteId") String noteId) {

         noteService.deleteNote(noteId);
    }


//    @GetMapping(value ="allNotes",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<NoteDTO> getAllNotes(){
//        return null;
//    }

}