package lk.ijse.note.notetaker.controller;


import lk.ijse.note.notetaker.dto.NoteDTO;
import lk.ijse.note.notetaker.dto.UserDTO;
import lk.ijse.note.notetaker.service.UserService;
import lk.ijse.note.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        builduUserDTO.setProfilePicture(base64ProfilePic);


        //send to the service layer
        return new ResponseEntity<>(userService.saveUser(builduUserDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId) {
        return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable ("id") String userId){
        return userService.getSelectedUser(userId);
    }


    @GetMapping(value = "allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();

    }

    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateUser(
            @PathVariable ("id") String id,
            @RequestPart("updateFirstName") String updateFirstName,
            @RequestPart ("updateLastName") String updateLastName,
            @RequestPart ("updateEmail") String updateEmail,
            @RequestPart ("updatePassword") String updatePassword,
            @RequestPart ("updateProfilePic") String updateProfilePic
    ){
        String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(updateProfilePic);
        var updateUser = new UserDTO();
        updateUser.setUserId(id);
        updateUser.setFirstName(updateFirstName);
        updateUser.setLastName(updateLastName);
        updateUser.setPassword(updatePassword);
        updateUser.setEmail(updateEmail);
        updateUser.setProfilePicture(updateBase64ProfilePic);
        return userService.updateUser(updateUser)? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
