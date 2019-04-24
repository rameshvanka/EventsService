package me.samarthya.EventsServices.controllers;

import me.samarthya.EventsServices.ldap.model.UserModel;
import me.samarthya.EventsServices.ldap.repository.ApacheDSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ControllerOne {

    @Autowired
    ApacheDSRepository apacheDSRepository;

    @GetMapping("/")
    @ResponseBody
    public String bonsoir(@RequestParam(name = "id", required = false) String id, HttpServletRequest request) {
        if (id != null)
            return "Bonsoir " + id + " !";
        else
            return "Bonsoir!";
    }

    @ResponseBody
    @GetMapping("/error")
    public String errorMessage(HttpServletRequest request) {
        return "Error occurred, please see the server logs.";
    }


    @ResponseBody
    @GetMapping("/users")
    public Iterable<UserModel> getAllUsers() {
        return apacheDSRepository.findAll();
    }
}
