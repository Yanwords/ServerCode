package com.nju.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nju.beans.Friend;
import com.nju.beans.Permission;
import com.nju.beans.ShareExperience;
import com.nju.beans.TravelRecord;
import com.nju.beans.User;
import com.nju.service.IUserService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

//                           customerService
	@RequestMapping("/login.do")
	@ResponseBody
	public Object login(HttpServletRequest req, HttpServletResponse response) throws IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		Map<String, Object> json = new HashMap<String, Object>();
		byte[] jsonBytes;
		/*
		 * int pId = 0; if(pId == 0){ pId =
		 * Integer.parseInt(req.getParameter("permission")); }
		 */
		System.out.println("Controller/username:" + userName);
		User user = userService.getUserByName(userName);

		if (user == null) {
			System.out.println("login fail");
			// return "loginFail";
			json.put("login", "error");
			// return user;

		} else {
			System.out.println("user is not null");
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {// &&
																								// (user.getpId()==pId)){
				// session.setAttribute("user", user);
				System.out.println("set Attribute");
				if (user.getpId() < 3) {
					List<User> list = userService.display();
					// model.addAttribute("list", list);
					// return "displaySucc";
					// return user;
					json.put("login", "success");
//        			json.put("gender", user.getGender());
				} else {

					// model.addAttribute("list", list);
					// return "custDisplay";
					// return user;
					json.put("login", "success");
				}
				// json.put("user", user.toString());
			} else {
				json.put("login", "wrongps!");
			}
		}
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/test.do")
	@ResponseBody
	public Object test(HttpServletRequest req, HttpServletResponse response) throws IOException {

		String userName = req.getParameter("username");
		Map<String, Object> json = new HashMap<String, Object>();
		byte[] jsonBytes;
		/*
		 * int pId = 0; if(pId == 0){ pId =
		 * Integer.parseInt(req.getParameter("permission")); }
		 */
		System.out.println("Controller/username:" + userName);
		json.put("test", "success in controller");
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public User login(String userName, String password, HttpServletRequest req,
	 * HttpSession session, Model model){ if(userName == null){ userName =
	 * req.getParameter("username"); } if(password == null){ password =
	 * req.getParameter("password"); } int pId = 0; if(pId == 0){ pId =
	 * Integer.parseInt(req.getParameter("permission")); }
	 * System.out.println("Controller/username:"+userName); User user =
	 * userService.getUserByName(userName);
	 * 
	 * if(user == null){ System.out.println("login fail"); //return "loginFail";
	 * return user; } else{ System.out.println("user is not null");
	 * if(user.getUserName().equals(userName) && user.getPassword().equals(password)
	 * && (user.getpId()==pId)){ session.setAttribute("user", user);
	 * System.out.println("set Attribute"); if(user.getpId() < 3) { List<User> list
	 * = userService.display(); model.addAttribute("list", list); //return
	 * "displaySucc"; return user; } else { List<Customer> list =
	 * userService.displayCustomer(user.getId()); for(Customer cust:list){
	 * cust.setUserName(user.getUserName()); } model.addAttribute("list", list);
	 * //return "custDisplay"; return user; } } else { return user; //return
	 * "loginFail"; } } }
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public Object insert(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// int id;
		String userName = req.getParameter("username");
		;
		String password = req.getParameter("password");
		;
		String gender = req.getParameter("gender");
		// gender = URLDecoder.decode(req.getParameter("gender"),"utf-8");
		// gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
		int age = Integer.parseInt(req.getParameter("age"));
		int pId = 1;
		System.out.println("register/gender" + gender);
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		User user = userService.getUserByName(userName);
		if (user == null) {
			user = new User();
			// user.setUserId(id);
			user.setUserName(userName);
			user.setPassword(password);
			user.setpId(pId);
			user.setGender(gender);
			user.setAge(age);
			Permission permission = new Permission();
			permission.setpId(pId);
			switch (pId) {
			case 1:
				permission.setpName("USER");
				break;
			case 2:
				permission.setpName("TOURIST");
				break;
			default:
				json.put("register", "permissionerror");
				return null;
			}
			user.setPermission(permission);
			int status = userService.insert(user);
			if (status == 1) {
				json.put("register", "success");
				json.put("gender", gender);
			} else {
				json.put("register", "registerfail");
			}
		} else {
			json.put("register", "useralreadyexist!");
		}

		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/update.do")
	@ResponseBody
	public String update(String username, String password, int age, HttpServletRequest req) {
		username = req.getParameter("username");
		password = req.getParameter("password");
		age = Integer.parseInt(req.getParameter("age"));
		if (username == null) {
			return "updateFail";
		} else {
			User user = userService.getUserByName(username);
			if (user == null) {
				return "updateFail";
			} else {
				if (!password.equals(user.getPassword())) {
					user.setPassword(password);
				}

				int status = userService.updateByPrimaryKey(user);
				if (status > 0)
					return "updateSucc";
				else
					return "updateFail";
			}
		}
	}

	@RequestMapping("/modifyname.do")
	@ResponseBody
	public Object modifyname(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String newname = req.getParameter("newname");
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		if (username == null || newname == null) {
			json.put("modifyname", "modifyFail");
//			return "updateFail";
		} else {
			User user = userService.getUserByName(username);
			if (user == null) {
//				return "updateFail";
				json.put("modifyname", "userdoesnotexist");
			} else {
				if (!password.equals(user.getPassword())) {
//					user.setPassword(password);
					json.put("mdofifyname", "passwordisnotcorrect");
				}
				user.setUserName(newname);
				int status = userService.updateByPrimaryKey(user);
				if (status > 0) {
					json.put("modifyname", "success");
				} else
					json.put("modifyname", "modifyfail");
			}
		}
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/modifypassword.do")
	@ResponseBody
	public Object modifypassword(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String newpassword = req.getParameter("newpassword");
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		if (username == null || newpassword == null) {
			json.put("modifypassword", "modifyFail");
//			return "updateFail";
		} else {
			User user = userService.getUserByName(username);
			if (user == null) {
//				return "updateFail";
				json.put("modifypassword", "userdoesnotexist");
			} else {
				if (!password.equals(user.getPassword())) {
//					user.setPassword(password);
					json.put("mdofifypassword", "passwordisnotcorrect");
				}
				user.setPassword(newpassword);
				int status = userService.updateByPrimaryKey(user);
				if (status > 0) {
					json.put("modifypassword", "success");
				} else
					json.put("modifypassword", "modifyfail");
			}
		}
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/reset.do")
	@ResponseBody
	public Object forgetpassword(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String username = req.getParameter("username");
		String newpassword = req.getParameter("newpassword");
		String gender = req.getParameter("gender");
		// gender = URLDecoder.decode(req.getParameter("gender"),"utf-8");
		// gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
		int age = Integer.parseInt(req.getParameter("age"));
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		if (username == null || newpassword == null) {
			json.put("reset", "resetFail");
//			return "updateFail";
		} else {
			User user = userService.getUserByName(username);
			if (user == null) {
//				return "updateFail";
				json.put("reset", "userdoesnotexist");
			} else {
				user.setPassword(newpassword);
				int status = userService.updateByPrimaryKey(user);
				if (status > 0) {
					json.put("reset", "success");
				} else
					json.put("reset", "resetfail");
			}
		}
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(int id, HttpServletRequest req) {
		id = Integer.parseInt(req.getParameter("id"));
		int status = userService.deleteByPrimaryKey(new Integer(id));
		if (status > 0) {
			return "deleteSucc";
		}
		return "deleteFail";
	}

	@RequestMapping("/display.do")
	@ResponseBody
	public String display(Model model) {
		List<User> list = userService.display();
		model.addAttribute("list", list);
		return "displaySucc";
//    	return "displayFail";
	}

	@RequestMapping("/friend.do")
	@ResponseBody
	public String friend(HttpServletRequest req, HttpServletResponse response, Model model) throws IOException {
		String name = req.getParameter("name");
		User user = userService.getUserByName(name);
		Map<String, Object> json = new HashMap<String, Object>();
		byte[] jsonBytes;
		if (user != null) {
			List<Friend> list = userService.friend(user.getUserId());
			model.addAttribute("list", list);
			System.out.println("frienddisplay length:" + list.size());
			JSONArray array = JSONArray.fromObject(list);
			if (list.size() > 0) {
				json.put("friend", "success");
				json.put("data", array);
				System.out.println("content of list:" + json.get("data"));

			} else {
				json.put("friend", "nofriend");
			}
		} else {
			json.put("friend", "failure");
		}
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@RequestMapping("/remove.do")
	@ResponseBody
	public Object remove(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String myName = req.getParameter("myname");
		String friendName = req.getParameter("friendname");
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		if (myName == null || friendName == null) {
			json.put("remove", "removefriendfail");
		} else {
			User me = userService.getUserByName(myName);
			User friend = userService.getUserByName(friendName);
			if (friend == null || me == null) {
				json.put("remove", "userdoesnotexist");
			} else {
				Friend f = new Friend();
				f.setUserId(me.getUserId());
				f.setFriendId(friend.getUserId());
				int status = userService.removeFriend(f);
				if (status > 0)
//					return "updateSucc";
					json.put("remove", "success");
				else
//					return "updateFail";
					json.put("remove", "removefriendfail");
			}
		}
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/insertTravel.do")
	@ResponseBody
	public Object insertTravel(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// int id;
		String userName = req.getParameter("username");
		String travelInfo = req.getParameter("travelinfo");
		String travelDate = req.getParameter("traveldate");
		System.out.println("travelInsert/userName:" + userName);
		System.out.println("travelInfo:" + travelInfo);
		System.out.println("travelDate:" + travelDate);
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		User user = userService.getUserByName(userName);
		TravelRecord travelRecord = null;
		if (user != null && user.getUserName().equals(userName)) {
			travelRecord = new TravelRecord();
			travelRecord.setUser(user);
			travelRecord.setTravelContent(travelInfo);
			travelRecord.setTravelDate(travelDate);
			travelRecord.setUserId(user.getUserId());
			int status = userService.insertTravelRecord(travelRecord);
			if (status == 1) {
				json.put("travel", "success");
			} else {
				json.put("travel", "insertfail");
			}
		} else {
			json.put("travel", "userdoesnotexist!");
		}

		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/insertExperience.do")
	@ResponseBody
	public Object insertExperience(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// int id;
		String userName = req.getParameter("username");
		String experInfo = req.getParameter("experinfo");
		String experDate = req.getParameter("experdate");
		System.out.println("experienceInsert/userName:" + userName);
		System.out.println("experInfo:" + experInfo);
		System.out.println("experDate:" + experDate);
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		User user = userService.getUserByName(userName);
		ShareExperience shareExperience = null;
		if (user != null && user.getUserName().equals(userName)) {
			shareExperience = new ShareExperience();
			shareExperience.setExperContent(experInfo);
			shareExperience.setExperDate(experDate);
			shareExperience.setUserId(user.getUserId());
			shareExperience.setUser(user);
			int status = userService.insertShareExperience(shareExperience);
			if (status == 1) {
				json.put("experience", "success");
			} else {
				json.put("experience", "insertfail");
			}
		} else {
			json.put("experience", "userdoesnotexist!");
		}

		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/addFriend.do")
	@ResponseBody
	public Object addFriend(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// int id;
		String userName = req.getParameter("username");
		String friendName = req.getParameter("friendname");
		System.out.println("addFriend/userName:" + userName);
		System.out.println("FriendName:" + friendName);
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		User user = userService.getUserByName(userName);
		User friend = userService.getUserByName(friendName);
		Friend isFriend = null;
		if (user != null && user.getUserName().equals(userName) && friend != null
				&& friend.getUserName().equals(friendName)) {
			isFriend = new Friend();
			isFriend.setUserId(user.getUserId());
			isFriend.setFriendId(friend.getUserId());
			isFriend.setFriendName(friend.getUserName());
			isFriend.setFriendGender(friend.getGender());
			isFriend.setFriendAge(friend.getAge());
			int status = userService.addFriend(isFriend);
			if (status == 1) {
				json.put("friend", "success");
			} else {
				json.put("friend", "addfriendfail");
			}
		} else {
			json.put("experience", "userdoesnotexist!");
		}

		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//customer update,delete,display

	@RequestMapping("/registerCustomer.do")
	public String insertCustomer(int id, String customerName, String customerStatus, HttpServletRequest req) {
		if (id == 0) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		if (customerName == null) {
			customerName = req.getParameter("custname");
		}
		int userId = 0;
		if (userId == 0) {
			userId = Integer.parseInt(req.getParameter("uid"));
		}
		if (customerStatus == null) {
			customerStatus = req.getParameter("status");
		}
		return "";

	}

	@RequestMapping("/updateCustomer.do")
	public String updateCustomer(String customerName, String customerStatus, HttpServletRequest req) {
		customerName = req.getParameter("custname");
		customerStatus = req.getParameter("status");
		int userId = Integer.parseInt(req.getParameter("uid"));
		if (customerName == null) {
			return "updateCustFail";
		} else {
			return "";
		}
	}

	@RequestMapping("/deleteCustomer.do")
	public String deleteCustomer(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		// int status = userService.deleteCustomer(new Integer(id));
		int status = 0;
		if (status > 0) {
			return "deleteCustSucc";
		}
		return "deleteCustFail";
	}

	@RequestMapping("/displayCustomer.do")
	public String displayCustomer(HttpServletRequest req, HttpSession session, Model model) {
		int id = Integer.parseInt(req.getParameter("userId"));
		System.out.println("/user/dispalycustid" + id);
		return "";
	}

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "spring mvc");
		return mv;
	}

	// selectCustomerById has been tested

}
