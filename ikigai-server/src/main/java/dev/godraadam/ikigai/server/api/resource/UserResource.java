package dev.godraadam.ikigai.server.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.ikigai.common.dto.UserDTO;
import dev.godraadam.ikigai.common.dto.UserRegisterDTO;
import dev.godraadam.ikigai.common.dto.VisitDTO;
import dev.godraadam.ikigai.server.api.assembler.UserAssembler;
import dev.godraadam.ikigai.server.api.assembler.UserRegisterAssembler;
import dev.godraadam.ikigai.server.api.assembler.VisitAssembler;
import dev.godraadam.ikigai.server.model.User;
import dev.godraadam.ikigai.server.model.Visit;
import dev.godraadam.ikigai.server.service.UserService;


@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserRegisterAssembler userRegisterAssembler;

    @Autowired
    private VisitAssembler visitAssembler;

    @GetMapping("/api/user/id/{id}")
    @ResponseBody
	public UserDTO findUserById(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		return userAssembler.createDto(user);
	}
    
    @GetMapping("/api/user/name/{name}")
    @ResponseBody
	public UserDTO findUserByName(@PathVariable("name") String name) {
		User user = userService.getUserByName(name);
		return userAssembler.createDto(user);
    }

    @PostMapping("/api/user/register")
    @ResponseBody
    public HttpStatus registerUser(@RequestBody UserRegisterDTO userDTO) {
        User user = userRegisterAssembler.createModel(userDTO);
        User returnedUser = userService.registerUser(user);
        if (returnedUser == null) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
    
    @PostMapping("/api/user/visit/{name}")
    @ResponseBody
    public HttpStatus saveVisitForUser(@PathVariable("name") String userName, @RequestBody VisitDTO visitDTO) {
        
        User user = userService.getUserByName(userName);
        Visit visit = visitAssembler.createModel(visitDTO);
        user = userService.saveVisitForUser(user, visit);
        if (user == null) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;

    }
    
}
