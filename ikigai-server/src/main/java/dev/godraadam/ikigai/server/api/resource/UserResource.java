package dev.godraadam.ikigai.server.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.ikigai.common.dto.UserDTO;
import dev.godraadam.ikigai.server.api.assembler.UserAssembler;
import dev.godraadam.ikigai.server.model.User;
import dev.godraadam.ikigai.server.service.UserService;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

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
}
