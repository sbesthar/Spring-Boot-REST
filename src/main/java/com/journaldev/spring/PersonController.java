package com.journaldev.spring;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.spring.entity.ApiResponse;
import com.journaldev.spring.entity.Employee;
import com.journaldev.spring.entity.User;
import com.journaldev.spring.entity.UserDto;
import com.journaldev.spring.service.EmployeeService;
import com.journaldev.spring.service.UserService;

@RestController
//@CrossOrigin(value = "http://localhost:3000")
@RequestMapping({"/person"})
public class PersonController {
	
	@Autowired
	private EmployeeService employeeService;

    @Autowired
    private UserService userService;
    
//	@Autowired
//	private Person person;
//	
//	@RequestMapping("/")
//	public String healthCheck() {
//		return "OK";
//	}
//	
//	@RequestMapping("/person/get")
//	public Person getPerson(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
//		person.setName(name);
//		return person;
//	}
//	
////	@RequestMapping(value="/person/update", method=RequestMethod.POST)
////	public Person updatePerson(@RequestParam(name="name", required=true) String name) {
////		person.setName(name);
////		return person;
////	}
//	
//	@RequestMapping(value="/person/update", method=RequestMethod.POST, consumes = "application/json")
//	public Person updatePerson(@RequestBody Person p) {
//		person.setName(p.getName());
//		return person;
//	}
	@PostMapping("/upload")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		System.out.println("inputStream: " + inputStream);
		System.out.println("originalName: " + originalName);
		System.out.println("name: " + name);
		System.out.println("contentType: " + contentType);
		System.out.println("size: " + size);
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(">>>>>>>>>> "+originalName, HttpStatus.OK);
	}	
	
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadErrorData() throws Exception {
		List<Employee> employees = employeeService.getEmployees();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(employees);
		byte[] isr = json.getBytes();
		String fileName = "employees.json";
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentLength(isr.length);
		respHeaders.setContentType(new MediaType("text", "json"));
		respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		return new ResponseEntity<byte[]>(isr, respHeaders, HttpStatus.OK);
	}	
    @PostMapping("/save")
    public ApiResponse saveUser(@RequestBody UserDto user){
        return new ApiResponse(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GetMapping("/user")
    public ApiResponse listUser(){
        return new ApiResponse(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable int id){
        return new ApiResponse(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse update(@RequestBody UserDto userDto) {
        return new ApiResponse(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse(HttpStatus.OK.value(), "User deleted successfully.", null);
    }	
}
