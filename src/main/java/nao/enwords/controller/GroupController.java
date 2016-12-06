package nao.enwords.controller;

import nao.enwords.model.Group;
import nao.enwords.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    private GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET, produces = "application/json")
    public List<Group> groups() {
        return groupRepository.findAll();
    }

}
