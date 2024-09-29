package lk.ijse.note.notetaker.controller;


import lk.ijse.note.notetaker.exception.DataPersistFailedException;
import lk.ijse.note.notetaker.exception.NoteNotFound;
import lk.ijse.note.notetaker.service.NoteService;
import lk.ijse.note.notetaker.dto.impl.NoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("api/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;

    @GetMapping("/health")
    public String healthCheck(){
       return "Note Taker is running";

    }


    //To Do CRUD Operation

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){

        if (note == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {

            try {

                //Todo: Handle with Service

                noteService.saveNote(note);
                return new ResponseEntity<>(HttpStatus.CREATED);

            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @GetMapping(value = "allNotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {

        return noteService.getAllNotes();
    }



    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId)  {

        return noteService.getSelectedNote(noteId);
    }


//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){

        try {
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoteNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {

        return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}