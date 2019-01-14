package com.codecool.foodswap.service;

import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void add(Group group) {
        User creator = group.getUsers().stream().findFirst().get();
        creator.joinGroup(group, true);
        groupRepository.save(group);
    }

    public void remove(Group group){
        groupRepository.delete(group);
    }

    public List<Group> findByName(String name) {
        List<Group> foundGroups = groupRepository.findAllByName(name);
        return !foundGroups.isEmpty()? null: foundGroups;
    }

    public void addUserToGroup(User user, Group group) {
        Group groupFromDb = findById(group.getId());
        groupFromDb.addUser(user, true);
        groupRepository.save(groupFromDb);
    }


    public Group findById(int id) {
        Optional<Group> foundGroup = groupRepository.findById(id);
        return foundGroup.isPresent()? foundGroup.get(): null;
    };
//    public List<Group> getAllGroupByUserId(int Id) {
//        User user =
//    };
}
