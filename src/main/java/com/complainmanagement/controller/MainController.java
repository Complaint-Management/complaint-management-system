package com.complainmanagement.controller;


import com.complainmanagement.pojo.Complaint;
import com.complainmanagement.pojo.Student;
import com.complainmanagement.pojo.Teacher;
import com.complainmanagement.repository.ComplainRepository;
import com.complainmanagement.repository.StudentRepository;
import com.complainmanagement.repository.TeacherRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/complaint")
@CrossOrigin
public class MainController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestBody String request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final JSONObject obj = new JSONObject(request);
        System.out.println(obj);
        Integer RollNo = obj.getInt("RollNo");
        String Name = obj.getString("Name");
        Integer Age = obj.getInt("Age");
        Integer MentorId = obj.getInt("MentorId");

        Student student = new Student();
        student.setRollNumber(RollNo);
        student.setName(Name);
        student.setAge(Age);
        student.setMentorId(MentorId);
        studentRepository.save(student);
        return "Saved";
    }
    @PostMapping(path="/add/teacher")
    public @ResponseBody String addNewTeacher (@RequestBody String request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final JSONObject obj = new JSONObject(request);
        System.out.println(obj);
        String Name = obj.getString("Name");

        Teacher teacher = new Teacher();
        teacher.setName(Name);
        teacherRepository.save(teacher);
        return "Saved";
    }

    @PostMapping(path="/add/complain")
    public @ResponseBody String addComplain (@RequestBody String request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final JSONObject obj = new JSONObject(request);
        System.out.println(obj);
        Integer rollNumber = Integer.parseInt(obj.getString("roll"));
        String name = obj.getString("name");
        String complaint = obj.getString("complain");

        Complaint complain = new Complaint();
        complain.setRollNumber(rollNumber);
        complain.setName(name);
        complain.setComplain(complaint);
        complain.setResolved(0);
        complainRepository.save(complain);
        return "Saved Successfully";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        return studentRepository.findAll();
    }

    @GetMapping(path="/all/teachers")
    public @ResponseBody Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping(path="/all/complaint/open/{roll}")
    public @ResponseBody Iterable<Complaint> getAllComplaintNotResolved(@PathVariable String roll) {
        Integer rollno = Integer.parseInt(roll);
        return complainRepository.findByRollNumber(rollno);
    }

    @GetMapping(path="/all/complaint/history/{roll}")
    public @ResponseBody Iterable<Complaint> getAllComplaintResolved(@PathVariable String roll) {
        Integer rollno = Integer.parseInt(roll);
        return complainRepository.findByRollNumberAndResolved(rollno);
    }


}
