package com.firstMaven.controller;

import com.firstMaven.pojo.User;
import com.firstMaven.service.IApkService;

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
@RequestMapping("/apk")
public class ApkController {

    @Autowired
    private IApkService iApkService;

    @RequestMapping(value="/train",method = RequestMethod.POST)
    @ResponseBody
    public String trainApk(@RequestParam String goodUrl,String badUrl){
        System.out.println("goodUrl:"+goodUrl);
        String result=iApkService.doPractice(goodUrl,badUrl);
        return "success";
    }
}
