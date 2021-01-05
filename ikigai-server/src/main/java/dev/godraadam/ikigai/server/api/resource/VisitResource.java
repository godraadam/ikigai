package dev.godraadam.ikigai.server.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.ikigai.common.dto.VisitDTO;
import dev.godraadam.ikigai.server.api.assembler.VisitAssembler;
import dev.godraadam.ikigai.server.service.UserService;

@RestController
public class VisitResource {

    @Autowired
    private UserService userService;

    @Autowired
    private VisitAssembler visitAssembler;

    @GetMapping("api/visit/{username}")
    public List<VisitDTO> getVisitsForUser(@PathVariable("username") String userName) {
        return visitAssembler.createDTOList(userService.getVisitsForUser(userName));
    }
    
}
