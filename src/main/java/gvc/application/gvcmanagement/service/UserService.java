package gvc.application.gvcmanagement.service;

import gvc.application.gvcmanagement.model.Role;
import gvc.application.gvcmanagement.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getAllUser();
}
