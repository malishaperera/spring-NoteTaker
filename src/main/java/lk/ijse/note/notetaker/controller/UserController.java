package lk.ijse.note.notetaker.controller;


import lk.ijse.note.notetaker.dto.UserDTO;
import lk.ijse.note.notetaker.entity.NoteEntity;
import lk.ijse.note.notetaker.service.UserService;
import lk.ijse.note.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {


    @Autowired
    private UserService userService;

    //Save user
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sveUser(

        @RequestPart("firstName") String firstName,
        @RequestPart("lastName") String lastName,
        @RequestPart("email") String email,
        @RequestPart("password") String password,
        @RequestPart("profilePicture") String profilePicture)
    {

        //Handle profile picture
        String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePicture);

        //build the user object
        UserDTO builduUserDTO = new UserDTO();
        builduUserDTO.setFirstName(firstName);
        builduUserDTO.setLastName(lastName);
        builduUserDTO.setEmail(email);
        builduUserDTO.setPassword(password);
        builduUserDTO.setProfilePicture(profilePicture);


        //send to the service layer
        return new ResponseEntity<>(userService.saveUser(builduUserDTO), HttpStatus.CREATED);




    }










}
