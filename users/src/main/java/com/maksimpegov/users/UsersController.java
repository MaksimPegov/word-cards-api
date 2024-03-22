package com.maksimpegov.users;

import com.maksimpegov.users.models.PasswordEditRequest;
import com.maksimpegov.users.user.UserDto;
import com.maksimpegov.users.user.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Endpoints")
@RequestMapping("/api/users")
public class UsersController {
	final Logger logger = LoggerFactory.getLogger(UsersController.class);

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping(path = "/register")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "New  user registration", notes = "Provide username and password in body")
	public void registerUser(@RequestBody UserDto userDto) {
		logger.info("Register new user with username " + userDto.getUsername());
		usersService.registerUser(userDto);
	}

	@PostMapping(path = "/login")
	@ApiOperation(value = "User login", notes = "Provide username and password in body", response = UserDto.class)
	public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
		logger.info("Login user with username " + userDto.getUsername());
		String response = usersService.loginUser(userDto);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ApiOperation(value = "Get user info", response = UserInfo.class)
	@ApiImplicitParam(name = "userId", value = "The genuine User ID or requester (extracted from the user's JWT token)", required = true, dataType = "String", paramType = "header")
	public ResponseEntity<UserInfo> getUserInfo(@RequestHeader("userId") String secureUserId) {
		logger.info("Get user info for user with id " + secureUserId);
		UserInfo response = usersService.getUserInfo(secureUserId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PatchMapping(path = "/password")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Edit user password", notes = "Provide username, old password and new password in body")
	public void editPassword(@RequestBody PasswordEditRequest editRequest) {
		logger.info("Edit password for user " + editRequest.getUsername());
		usersService.editPassword(editRequest);
	}

	@DeleteMapping
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete user")
	@ApiImplicitParam(name = "userId", value = "The genuine User ID or requester (extracted from the user's JWT token)", required = true, dataType = "String", paramType = "header")
	public void deleteUser(@RequestHeader("userId") String secureUserId) {
		logger.info("Delete user with id " + secureUserId);
		usersService.deleteUser(secureUserId);
	}
}
