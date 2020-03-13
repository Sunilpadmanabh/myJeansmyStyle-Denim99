package com.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Customer;
import com.model.EmailAndPasswordToken;
import com.model.User;
import com.service.CustomerService;
import com.service.EmailAndPasswordService;
import com.service.UserService;
import com.util.HashCode;

@Controller
public class EmailAndPasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	HashCode hashCode;

	@Autowired
	private EmailAndPasswordService passwordResetService;

	// Display forgotPassword page
	@RequestMapping(value = "**/forgotpassword", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		String email = "";
		return new ModelAndView("forgotpassword", "email", email);
	}

	// Process form submission from forgotPassword page
	@RequestMapping(value = "/sendresettoken", method = RequestMethod.POST)
	public String processForgotPasswordForm(Map<String, Object> modelMap, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redir) {

		String userEmail = (String) request.getParameter("email");
		// Lookup user in database by e-mail
		User user = userService.getUserByEmail(userEmail);

		if (user == null) {
			return "forgotpassword";
		}

		if (user != null && !user.isEnabled()) {
			redir.addFlashAttribute("error", "Email verification link already sent.please verify your email first");
			return "redirect:login";
		}

		// Generate random 36-character string token for reset password
		EmailAndPasswordToken token = passwordResetService.getUserByEmail(userEmail);

		if (token != null) {
			passwordResetService.deletePasswordResetToken(token);
		}
		token = new EmailAndPasswordToken();
		token.setToken(UUID.randomUUID().toString());
		token.setEmail(userEmail);
		// Save token to database
		int flag = passwordResetService.saveUserToken(token);

		String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
				+ "/MyJeansMyStyle";

		// Email message
		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("myjeansmystyle@outlook.com");
		passwordResetEmail.setTo(token.getEmail());
		passwordResetEmail.setSubject("Password Reset Request");
		passwordResetEmail.setText(
				"To reset your password, click the link below:\n" + appUrl + "/reset?token=" + token.getToken());

		passwordResetService.sendMail2(passwordResetEmail);
		// Add success message to view
		redir.addFlashAttribute("error", "A password reset link has been sent to your registered email.");

		return "redirect:login";

	}

	@RequestMapping(value = "/verifyemail", method = RequestMethod.GET)
	public String sendVerifyEmail(@ModelAttribute("email") String userEmail, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redir) {

		// Lookup user in database by e-mail
		User user = userService.getUserByEmail(userEmail);

		EmailAndPasswordToken token = new EmailAndPasswordToken();
		token.setToken(UUID.randomUUID().toString());
		token.setEmail(userEmail);
		// Save token to database
		int flag = passwordResetService.saveUserToken(token);

		String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
				+ "/MyJeansMyStyle";

		// Email message
		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("myjeansmystyle@outlook.com");
		passwordResetEmail.setTo(token.getEmail());
		passwordResetEmail.setSubject("Verify your account");
		passwordResetEmail.setText(
				"To verify your account, click the link below:\n" + appUrl + "/emailverify?token=" + token.getToken());

		passwordResetService.sendMail2(passwordResetEmail);
		// Add success message to view
		redir.addFlashAttribute("error", "Account verification link has been sent to your email.");

		return "redirect:login";

	}

	// Display form to reset password
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, HttpServletRequest request,
			@RequestParam("token") String token, RedirectAttributes redir) {

		EmailAndPasswordToken passwordResetToken = passwordResetService.getUserByToken(token);
		if (passwordResetToken != null) {
			String email = passwordResetToken.getEmail();

			if (email != null) { // Token found in DB
				modelAndView.addObject("email", email);
				modelAndView.setViewName("resetpassword");
				return modelAndView;
			}

		} // Token not found in DB
		redir.addFlashAttribute("error", "Oops!  This is an invalid password reset link.");
		modelAndView.setViewName("redirect:login");
		return modelAndView;
	}

	@RequestMapping(value = "/emailverify", method = RequestMethod.GET)
	public ModelAndView verifyEmail(ModelAndView modelAndView, HttpServletRequest request,
			@RequestParam("token") String token, RedirectAttributes redir) {

		EmailAndPasswordToken passwordResetToken = passwordResetService.getUserByToken(token);
		if (passwordResetToken != null) {
			String email = passwordResetToken.getEmail();

			if (email != null) { // Token found in DB
				User user = userService.getUserByEmail(email);
				if (user != null) {
					if (!user.isEnabled()) {
						user.setEnabled(true);
						userService.updateUser(user);
						redir.addFlashAttribute("error", "Account verified successfully. kindly login to your account.");
						modelAndView.setViewName("redirect:login");
						return modelAndView;
					}
				}
			}

		} // Token not found in DB
		redir.addFlashAttribute("error", "Oops!  This is an invalid link.");
		modelAndView.setViewName("redirect:login");
		return modelAndView;
	}

	// Process reset password form
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView setNewPassword(ModelAndView modelAndView, HttpServletRequest request,
			RedirectAttributes redir) {

		// Find the user associated with the reset token
		String email = (String) request.getParameter("email");
		EmailAndPasswordToken userToken = passwordResetService.getUserByEmail(email);
		String password = (String) request.getParameter("password");
		String confirmPassword = (String) request.getParameter("confirmPassword");
		if (email != null && !email.equals("") && password.equals(confirmPassword)) {
			User user = userService.getUserByEmail(email);
			Customer customer = user.getCustomer();
			// Set new password
			String hashPassword = hashCode.getHashPassword(password);

			customer.getUsers().setPassword(hashPassword);
			user.setPassword(hashPassword);
			customerService.updateCustomer(customer);
			// Delete from PasswordReset Table
			passwordResetService.deletePasswordResetToken(userToken);

			// Save user
			userService.updateUser(user);

			// In order to set a model attribute on a redirect, we must use
			// RedirectAttributes
			redir.addFlashAttribute("error", "You have successfully reset your password.  You may now login.");

			modelAndView.setViewName("redirect:login");
			return modelAndView;
		} else {
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			modelAndView.setViewName("resetpassword");
		}

		return modelAndView;
	}

	// Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}
}