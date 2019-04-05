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

import com.nju.beans.ScenicEvaluation;
import com.nju.beans.ScenicSpot;
import com.nju.beans.User;
import com.nju.service.IScenicSpotService;
import com.nju.service.IUserService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/scenic")
public class ScenicSpotController {
	@Resource
	private IScenicSpotService scenicService;
	@Resource
	private IUserService userService;

//                           customerService
	@RequestMapping("/select.do")
	@ResponseBody
	public Object login(HttpServletRequest req, HttpServletResponse response) throws IOException {

		String scenicName = req.getParameter("scenicname");
		Map<String, Object> json = new HashMap<String, Object>();
		byte[] jsonBytes;
		/*
		 * int pId = 0; if(pId == 0){ pId =
		 * Integer.parseInt(req.getParameter("permission")); }
		 */
		System.out.println("Controller/scenicname:" + scenicName);
		ScenicSpot scenic = scenicService.getScenicByName(scenicName);

		if (scenic == null) {
			System.out.println("select fail");
			// return "loginFail";
			json.put("select", "error");
			// return user;

		} else {
			System.out.println("scenic is not null");
			if (scenic.getScenicName().equals(scenicName)) {// && (user.getpId()==pId)){
				// session.setAttribute("user", user);
				System.out.println("set Attribute");
				json.put("select", "success");
			} else {
				json.put("select", "wrong");
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

	@RequestMapping("/insert.do")
	@ResponseBody
	public Object insert(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// int id;
		String scenicName = req.getParameter("scenicname");
		String scenicInfo = req.getParameter("scenicinfo");
		float scenicScore = Float.parseFloat(req.getParameter("scenicscore"));
//    	float score = Float.parseFloat(req.getParameter("score"));
		// gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("float:" + scenicScore);
		System.out.println("insert/scenicName:" + scenicName);
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		ScenicSpot scenic = scenicService.getScenicByName(scenicName);
		if (scenic == null) {
			scenic = new ScenicSpot();
			// user.setUserId(id);
			scenic.setScenicName(scenicName);
			scenic.setScenicInfo(scenicInfo);
			scenic.setScenicScore(scenicScore);
			int status = scenicService.insert(scenic);
			if (status == 1) {
				json.put("insert", "success");
			} else {
				json.put("insert", "insertfail");
			}
		} else {
			json.put("insert", "scenicalreadyexist!");
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
	public Object update(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String scenicName = req.getParameter("scenicname");
		String scenicInfo = req.getParameter("scenicinfo");
		float score = Float.parseFloat(req.getParameter("scenicscore"));
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		if (scenicName == null) {
//         	return "updateFail";
			json.put("update", "scenicupdatefail");
		} else {
			ScenicSpot ss = scenicService.getScenicByName(scenicName);
			if (ss == null) {
//				return "updateFail";
				json.put("update", "scenicspotdoesnotexist");
			} else {
				ss.setScenicName(scenicName);
				ss.setScenicInfo(scenicInfo);
				ss.setScenicScore(score);
				int status = scenicService.updateByPrimaryKey(ss);
				if (status > 0)
//					return "updateSucc";
					json.put("update", "success");
				else
//					return "updateFail";
					json.put("update", "updatefail");
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

	@RequestMapping("/setscore.do")
	@ResponseBody
	public Object setscore(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String scenicName = req.getParameter("scenicname");
		String scenicInfo = req.getParameter("scenicinfo");
		float score = Float.parseFloat(req.getParameter("scenicscore"));
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		if (scenicName == null) {
			json.put("set score", "scenicsetscorefail");
		} else {
			ScenicSpot ss = scenicService.getScenicByName(scenicName);
			if (ss == null) {
				json.put("setscore", "scenicspotdoesnotexist");
			} else {
				ss.setScenicScore(score);
				int status = scenicService.updateByPrimaryKey(ss);
				if (status > 0)
//					return "updateSucc";
					json.put("setscore", "success");
				else
//					return "updateFail";
					json.put("setscore", "updatefail");
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
		int status = scenicService.deleteByPrimaryKey(new Integer(id));
		if (status > 0) {
			return "deleteSucc";
		}
		return "deleteFail";
	}

	@RequestMapping("/display.do")
	@ResponseBody
	public String display(HttpServletRequest req, HttpServletResponse response, Model model) throws IOException {
		String scenicScore = req.getParameter("scenicscore");
		float score = Float.parseFloat(scenicScore);
		List<ScenicSpot> list = scenicService.display(score);
		model.addAttribute("list", list);
		System.out.println("display length:" + list.size());

		Map<String, Object> json = new HashMap<String, Object>();
		byte[] jsonBytes;
		JSONArray array = JSONArray.fromObject(list);

		if (list.size() > 0) {
			json.put("display", "success");
			json.put("data", array);
			System.out.println("content of list:" + json.get("data"));

		} else {
			json.put("display", "fail");
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

		// return "displaySucc";
		return "";
//    	return "displayFail";
	}

	@RequestMapping("/insertEvaluation.do")
	@ResponseBody
	public Object insertEvaluation(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// int id;
		String userName = req.getParameter("username");
		String evalInfo = req.getParameter("evalinfo");
		String evalDate = req.getParameter("evaldate");
		String scenicName = req.getParameter("scenicname");
		System.out.println("evaluationInsert/scenicName:" + scenicName);
		System.out.println("evaluationInsert/userName:" + userName);
		System.out.println("evalInfo:" + evalInfo);
		System.out.println("evalDate:" + evalDate);
		Map<String, String> json = new HashMap<String, String>();
		byte[] jsonBytes;
		ScenicSpot scenic = scenicService.getScenicByName(scenicName);
		System.out.println("scenic:" + scenic.getScenicId());
		User user = userService.getUserByName(userName);
		ScenicEvaluation scenicEvaluation = null;
		if (user != null && user.getUserName().equals(userName) && scenic != null
				&& scenic.getScenicName().equals(scenicName)) {
			scenicEvaluation = new ScenicEvaluation();
			scenicEvaluation.setEvalContent(evalInfo);
			scenicEvaluation.setEvalDate(evalDate);
			scenicEvaluation.setScenicId(scenic.getScenicId());
			scenicEvaluation.setScenicSpot(scenic);
			scenicEvaluation.setUserId(user.getUserId());
			scenicEvaluation.setUser(user);
			int status = scenicService.insertScenicEvaluation(scenicEvaluation);
			if (status == 1) {
				json.put("evaluation", "success");
			} else {
				json.put("evaluation", "insertfail");
			}
		} else {
			json.put("evaluation", "userdoesnotexist!");
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
		// int status = scenicService.deleteCustomer(new Integer(id));
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
