package com.mao.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

@Controller
public class GoController implements EnvironmentAware {
    private final Log logger=LogFactory.getLog(GoController.class);

    @RequestMapping(value = "/",method = RequestMethod.HEAD)
    public String head(){
        return "go.jsp";
    }

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String index(Model model){
        logger.info("index ================");
        //测试environment 进入断点
        model.addAttribute("msg","hello spring");

        return "index.jsp";

    }

    @RequestMapping("/handle1")
    public String handl1(@RequestBody String requestBody){
        System.out.println(requestBody);

        return "success.jsp";
    }
@ResponseBody
@RequestMapping(path="handle2/{imageId}")
    public byte[] handle2(@PathVariable("imageId")String imageId)throws IOException{
        System.out.println("load image "+imageId);
        Resource res=new ClassPathResource("/image.jpg");
        byte[] fileData= FileCopyUtils.copyToByteArray(res.getInputStream());
        return fileData;
    }
    private Environment environment;
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
