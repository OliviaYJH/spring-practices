package fileupload.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping({ "/", "/form" })
	public String form() {
		return "form";
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam("email") String email, @RequestParam("file") MultipartFile file) {
		 if (file == null || file.isEmpty()) {
		        System.out.println("No file uploaded or file is empty.");
		        return "form"; // 폼으로 다시 이동
		    }
		 
		try {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			System.out.println(file.getBytes().length);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return "result";
	}
}
