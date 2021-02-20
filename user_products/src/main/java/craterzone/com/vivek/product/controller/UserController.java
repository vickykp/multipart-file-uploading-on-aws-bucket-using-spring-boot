package craterzone.com.vivek.product.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import craterzone.com.vivek.product.model.User;
import craterzone.com.vivek.product.service.UserService;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

	@Autowired
	private UserService service;
	
	
	
	
	
	@Value("${endpointUrl}")
	private String endpointUrl;
  
    @Value("${bucketName}")
	private String bucketName;
	

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user,@RequestPart(value = "file") MultipartFile file) {

		User user1 = service.saveUser(user,file);
		if (!java.util.Objects.isNull(user1)) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}
	
	
	@PutMapping()
	public ResponseEntity<User> update(@RequestBody User user, Long id,MultipartFile file){
     
		User user1 = service.updateUser(user, id,file);
		if (!java.util.Objects.isNull(user1)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(user);

	}
	
	@PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile multipartFile) {

    	String fileUrl = "";
    	String  status = null;
    	try {

    		//converting multipart file to file
    		File file = service.convertMultiPartToFile(multipartFile);

    		//filename
    		String fileName = multipartFile.getOriginalFilename();

    		fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;

    		status = service.uploadFileTos3bucket(fileName, file);

    		file.delete();

    	} catch (Exception e) {

    		return "UploadController().uploadFile().Exception : " + e.getMessage();

    	}

    	return status + " " +  fileUrl;
    }

   
    
}


