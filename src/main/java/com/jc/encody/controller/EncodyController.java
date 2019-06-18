package com.jc.encody.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class EncodyController {


    @RequestMapping("/encody")
    public void getEncody(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String data = request.getParameter("data");
        int size = data.length();
        char[] arr =new char[size];
        for(int i=0;i<size;i++){
            arr[i] = data.charAt(i);
        }
        //加密
        data = Encody(arr,1);
        JSONObject obj = new JSONObject();
        obj.put("data",data);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(obj.toString());
    }


    //加密|解密
    public String Encody(char[] arr,int a){
        for(int i=0;i<8;i++){
            arr[i]=((char)(arr[i]^a));
        }
        for(int i=8;i<arr.length;i++){
            arr[i]= arr[i];
        }
        return String.valueOf(arr);
    }


}
