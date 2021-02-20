package craterzone.com.vivek.product.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import craterzone.com.vivek.product.dao.UserDao;
import craterzone.com.vivek.product.mapper.UserMapper;
import craterzone.com.vivek.product.model.User;
import craterzone.com.vivek.product.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private AmazonS3 s3client;
	
	
	@Value("${bucketName}")
	private String bucketName;

	@Transactional
	public User saveUser(User user, MultipartFile file) {
		Optional<UserDao> userExists = repository.findByEmail(user.getEmail());
		if (userExists.isPresent()) {
			return null;
		}
		UserDao userDB = repository.save(UserMapper.maptoUserDao(user, file));
		return UserMapper.mapToUser(userDB);
	}

	
	@Transactional
	public User updateUser(User userForUpdate, Long id, MultipartFile file) {

		Optional<UserDao> userExists = repository.findById(id);
		if (userExists.isPresent()) {
			UserDao userDb = repository.save(UserMapper.maptoUserDao(userForUpdate, file));

			return UserMapper.mapToUser(userDb);
		}
		return null;
	}

	/*
	 * @Override public String saveimage(String uploadDirectory, MultipartFile file)
	 * throws FileNotFoundException {
	 * 
	 * try {
	 * 
	 * new File(uploadDirectory).mkdir(); String imagename =
	 * file.getOriginalFilename(); byte[] imagedata = file.getBytes();
	 * 
	 * String imagepath = uploadDirectory + "//" + imagename; FileOutputStream
	 * output = new FileOutputStream(new File(imagepath)); output.write(imagedata);
	 * output.close(); } catch (Exception e) { System.out.println(e); } return
	 * "Data and image Save Successfully"; }
	 */
	@Transactional
	public File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	@Transactional
	public String uploadFileTos3bucket(String fileName, File file) {
		try {
			s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
		} catch (AmazonServiceException e) {
			return "uploadFileTos3bucket().Uploading failed :" + e.getMessage();
		}
		return "Uploading Successfull -> ";
	}

}
