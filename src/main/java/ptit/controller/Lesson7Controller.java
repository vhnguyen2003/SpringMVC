package ptit.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.UserModel;

@Controller
@RequestMapping("Lesson7/")
public class Lesson7Controller {

	@RequestMapping("index")
	public String showFormLogin(@ModelAttribute("user") UserModel user) {

		return "Lesson7/validation";
	}

	@RequestMapping("index")
	public String index1(ModelMap model, @ModelAttribute("user") UserModel user, BindingResult errors)
			throws IOException {

		if (errors.hasErrors()) {
			if (user.getId().trim().isBlank() || user.getId().trim().isEmpty()) {
				errors.rejectValue("id", "user", "Nhập tên đăng nhập");
			}
			if (user.getPassword().trim().isBlank() || user.getPassword().trim().isEmpty()) {
				errors.rejectValue("password", "user", "Nhập mật khẩu");
			}
		}

		return "Lesson7/validation";
	}

}
