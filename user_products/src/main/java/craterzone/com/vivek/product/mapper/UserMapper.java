package craterzone.com.vivek.product.mapper;

import org.springframework.web.multipart.MultipartFile;

import craterzone.com.vivek.product.dao.UserDao;
import craterzone.com.vivek.product.model.User;

public class UserMapper {
	
	public static User mapToUser(UserDao userDao) {

		return new User();
	}
	
	public static UserDao maptoUserDao(User user,MultipartFile file) {

		UserDao use = new UserDao();
		
		String imagename = file.getOriginalFilename();

		use.setId(user.getId());
		use.setEmail(user.getEmail());
		use.setFirstName(user.getFirstName());
		use.setLastName(user.getLastName());
		use.setDob(user.getDob());
		use.setMobileNo(user.getMobileNo());
		use.setMobileCc(user.getMobileCc());
		use.setPassword(user.getPassword());
		use.setDateJoined(user.getDateJoined());
		use.setDateModified(user.getDateModified());
		use.setType(user.getType());
		use.setActive(user.isActive());
		use.setRole(user.getRole());
		user.setFile(imagename);
		

		return use;
	}

}
