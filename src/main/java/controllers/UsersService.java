package controllers;


import repositories.UsersRepo;
import entities.Users;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private ModelMapper mapper;
    public final UsersRepo repo;

    public UsersService(UsersRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    public Users deleteUser(Long id) {
        Optional<Users> userToDeleteOptional = this.repo.findById(id);
        if (!userToDeleteOptional.isPresent()) {
            return null;
        }
        Users userToDelete = userToDeleteOptional.get();
        this.repo.delete(userToDelete);
        return userToDelete;
    }

    public Users updateUser(Long id, Users users) {
        Optional<Users> userToUpdateOptional = this.repo.findById(id);
        if (!userToUpdateOptional.isPresent()) {
            return null;
        }

        // Since isPresent() was true, we can .get() the Person object out of the Optional
        Users userToUpdate = userToUpdateOptional.get();

        if (users.getName() != null) {
            userToUpdate.setName(users.getName());
        }

        if (users.getEmail() != null) {
            userToUpdate.setEmail(users.getEmail());
        }


        Users updatedUser = this.repo.save(userToUpdate);
        return updatedUser;
    }

    public Users createUser(Users users) {
        Users newUser = this.repo.save(users);
        return newUser;
    }
    public List<Users> getAllUsers() {
        return this.repo.findAll();
    }

}