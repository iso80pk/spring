package pl.softsystem.wyklad1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.wyklad1.model.UserModel;
import pl.softsystem.wyklad1.repositoty.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel insertNewUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Transactional
    public UserModel updateUserById(Long id, UserModel userModel) {
        UserModel model = getOne(id);
        model.setName(userModel.getName());
        model.setLogin(userModel.getLogin());
        return model;
    }
}
