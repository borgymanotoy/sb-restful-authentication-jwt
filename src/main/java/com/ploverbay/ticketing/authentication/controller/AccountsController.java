package com.ploverbay.ticketing.authentication.controller;

import com.ploverbay.ticketing.authentication.model.ErrorMessage;
import com.ploverbay.ticketing.authentication.model.User;
import com.ploverbay.ticketing.authentication.model.ValidationResponse;
import com.ploverbay.ticketing.authentication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing accounts
 *
 * @author Eric Jose E. Salip Ahmad
 *
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService m_userService;


    @GetMapping
    public ResponseEntity<?> greetings() {
        List<User> users = m_userService.listUsers();
        return new ResponseEntity<Object>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        logger.debug("Getting user with ID: ", userId);
        return m_userService.findByUserId(userId);
    }

    @GetMapping("/search")
    public User getUserByEmail(@RequestParam("email") String email) {
        logger.debug("Getting user with email: ", email);
        return m_userService.findByEmail(email);
    }

    @GetMapping("/name_search")
    public User getUserByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        logger.debug("Getting user with first name and last name: ", firstName, " ", lastName);
        return m_userService.findByName(firstName, lastName);
    }

    @PostMapping
    public Object addUser(@RequestBody User user, BindingResult bindingResult) {
        logger.debug("Saving user : " + user);
        if (!bindingResult.hasErrors()) {
            return m_userService.saveUser(user);
        } else {
            return handleValidationError(bindingResult);
        }
    }

    @PutMapping("/{userId}")
    public Object updateUser(@PathVariable String userId, @RequestBody User user, BindingResult bindingResult) {
        logger.debug("Saving user : " + user);
        if (!bindingResult.hasErrors()) {
            return m_userService.saveUser(user);
        } else {
            return handleValidationError(bindingResult);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> delete(@PathVariable String userId) {
        m_userService.removeUser(userId);
        return ResponseEntity.ok().build();
    }

    private Object handleValidationError(BindingResult bindingResult) {
        ValidationResponse validationResponse = new ValidationResponse();
        validationResponse.setStatus("FAIL");
        List<FieldError> allErrors = bindingResult.getFieldErrors();
        List<ErrorMessage> errorMesages = new ArrayList<>();
        for (FieldError objectError : allErrors) {
            String errorMssg = objectError.getDefaultMessage();
            errorMesages.add(new ErrorMessage(objectError.getField(), errorMssg));
        }
        validationResponse.setErrorMessageList(errorMesages);
        return validationResponse;
    }

}