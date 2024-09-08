package lk.ijse.note.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.note.notetaker.dao.UserDao;
import lk.ijse.note.notetaker.dto.UserDTO;
import lk.ijse.note.notetaker.entity.UserEntity;
import lk.ijse.note.notetaker.exception.UserNotFoundException;
import lk.ijse.note.notetaker.util.AppUtil;
import lk.ijse.note.notetaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public String saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity saveUser = userDao.save(mapping.convertToUserEntity(userDTO));

        if (saveUser != null && saveUser.getUserId() != null) {
            return "User saved successfully";

        }else {
            return "Save failed";
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userDTO.getUserId());
        if(!tmpUser.isPresent()){
            throw new UserNotFoundException("User not found");
        }else {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePicture(userDTO.getProfilePicture());
        }
    }


    @Override
    public boolean deleteUser(String userId) {
        if (userDao.existsById(userId)) {
            userDao.deleteById(userId);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public UserDTO getSelectedUser(String userId) {
//        UserEntity userEntitiesByUserId = userDao.getUserEntitiesByUserId(userId) ;
        return mapping.convertToUserDTO(userDao.getUserEntitiesByUserId(userId));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.convertUserToDTOList(userDao.findAll());
    }
}
