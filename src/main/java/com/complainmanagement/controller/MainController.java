package com.complainmanagement.controller;


import com.complainmanagement.pojo.Complaint;
import com.complainmanagement.pojo.Student;
import com.complainmanagement.repository.ComplainRepository;
import com.complainmanagement.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/complaint")
public class MainController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ComplainRepository complainRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestBody String request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final JSONObject obj = new JSONObject(request);
        System.out.println(obj);
        String FirstName = obj.getString("FirstName");
        String LastName = obj.getString("LastName");
        Integer Age = obj.getInt("Age");
        Integer MentorId = obj.getInt("MentorId");

        Student student = new Student();
        student.setFirstName(FirstName);
        student.setLastName(LastName);
        student.setAge(Age);
        student.setMentorId(MentorId);
        studentRepository.save(student);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        return studentRepository.findAll();
    }

    @PostMapping(path="/add/complain")
    public @ResponseBody String addComplain (@RequestBody String request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final JSONObject obj = new JSONObject(request);
        System.out.println(obj);
        Integer rollNumber = obj.getInt("rollNumber");
        String name = obj.getString("name");
        String complaint = obj.getString("complain");

        Complaint complain = new Complaint();
        complain.setRollNumber(rollNumber);
        complain.setName(name);
        complain.setComplain(complaint);
        complainRepository.save(complain);
        return "Saved Successfully";
    }





}
