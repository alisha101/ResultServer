package com.outbottle.controllers;

import com.user.User;
import com.user.DALUser;
import com.questions.Questions;
import com.questions.DALQuestions;
import com.result.Result;
import com.result.DALResult;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author alisha
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class ResultController {
    
   @RequestMapping(value = "/rest", method = RequestMethod.GET)
   @ResponseBody
   public String index(ModelMap map) {
       map.put("msg", "Hello Spring 4 Web MVC!");
       return "index";
   }
   
   @RequestMapping(value = "/rest1", method = RequestMethod.GET)
   public String index1(ModelMap map) {
       map.put("msg", "Hello Spring 4 Web MVC!");
       return "index";
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/getResultById/{id}", method = RequestMethod.GET)
   @ResponseBody
   public ArrayList<Result> getResultById(@PathVariable("id") String userid) throws SQLException {
       DALResult du = new DALResult();
       
       return du.getAllResultByUserId(userid);
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
   @ResponseBody
   public ArrayList<User> getAllUsers() throws SQLException {
       DALUser du = new DALUser();
       System.out.println(du.getAllUsers());
       return du.getAllUsers();
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/getAllQuestions", method = RequestMethod.GET)
   @ResponseBody
   public ArrayList<Questions> getAllQuestions() throws SQLException {
       DALQuestions dq = new DALQuestions();
       System.out.println(dq.getAllQuestions());
       return dq.getAllQuestions();
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/getAllResult", method = RequestMethod.GET)
   @ResponseBody
   public ArrayList<Result> getAllResult() throws SQLException {
       DALResult rs = new DALResult();
       System.out.println(rs.getAllResult());
       return rs.getAllResult();
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
   @ResponseBody
   public boolean  registerUsers(@RequestBody User u) throws SQLException {
       DALUser ru = new DALUser();
       return ru.registerUsers(u);
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
   @ResponseBody
   public boolean addQuestion(@RequestBody Questions q) throws SQLException {
	   System.out.println("hello");
	   System.out.println(q);
       DALQuestions que = new DALQuestions();
       return que.addQuestion(q);
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/addResult", method = RequestMethod.POST)
   @ResponseBody
   public boolean addResult(@RequestBody Result r) throws SQLException {
	   System.out.println("hello");
	   System.out.println(r);
       DALResult dr = new DALResult();
       return dr.addResult(r);
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   @ResponseBody
   public User login(@RequestBody User u) throws SQLException {
	   System.out.println("login");
	   System.out.println(u);
       DALUser user = new DALUser();
       return user.login(u);
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/getQuestionById", method = RequestMethod.GET)
   @ResponseBody
   public ArrayList<Questions> getQuestionById() throws SQLException {
       DALQuestions que = new DALQuestions();
       que.getQuestionById();
       return que.getQuestionById();
   }
   
   @Produces("application/json")
   @RequestMapping(value = "/deleteQuestionById", method = RequestMethod.POST)
   @ResponseBody
   public void deleteQuestionById(@RequestBody int id) throws SQLException {
       DALQuestions que = new DALQuestions();
       que.deleteQuestionById(id);
   }
   
}