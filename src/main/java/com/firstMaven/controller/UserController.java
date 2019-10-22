package com.firstMaven.controller;

import com.firstMaven.pojo.User;
import com.firstMaven.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;



    @RequestMapping(value="/select",method=RequestMethod.POST)
    @ResponseBody
    public String selectUser(@RequestParam String ObjectJson1,String ObjectJson2) throws Exception{

        JSONArray list_user=JSONArray.fromObject(ObjectJson1);
        JSONObject user=JSONObject.fromObject(ObjectJson2);

        for(int i=0;i<list_user.size();i++){
            User oneOfUser=(User)list_user.getJSONObject(i).toBean(list_user.getJSONObject(i),User.class);
            System.out.println("select1  username:"+oneOfUser.getName()+" password:"+oneOfUser.getPassword());

        }


        User turnUser=(User)JSONObject.toBean(user,User.class);
        int testId = Integer.parseInt(turnUser.getName());
        System.out.println("findUser1:"+testId);
        User findUser=iUserService.findUserById(testId);
        System.out.println("findUser2:"+findUser.getPassword());

        return "success";
    }

    @RequestMapping(value="/varifylogin",method=RequestMethod.POST)
    @ResponseBody
    public String varifyUser(@RequestParam String ObjectJson) throws Exception{
       JSONObject jsonUser=JSONObject.fromObject(ObjectJson);
       User user=(User)JSONObject.toBean(jsonUser,User.class);
       System.out.println("进后台了"+user.getName());
       System.out.println(user.getPassword());
        List<User> userList=iUserService.getUserByUserName(user.getName(),user.getPassword());
        if(userList!=null&&userList.size()>0){
            User user0=userList.get(0);
            System.out.println("查到了"+user0.getName());
            System.out.println("success");
            return "success";
        } else{
            return "false";
        }
    }






}
