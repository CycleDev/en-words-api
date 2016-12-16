package nao.enwords.controller;

import nao.enwords.model.Group;
import nao.enwords.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.GET, produces = "application/json")
    public Group group(@PathVariable long groupId) {
        return groupRepository.findOne(groupId);
    }

    @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable long groupId) {
        groupRepository.delete(groupId);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Group save(@RequestBody Group group) {
        return groupRepository.save(group);
    }
}
