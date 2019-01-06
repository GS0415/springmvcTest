package com.neuedu.web.controller;

import com.neuedu.web.dao.IUserDao;
import com.neuedu.web.dao.UserDaoImpl;
import com.neuedu.web.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class WebTest {
    private IUserDao dao = new UserDaoImpl();
    @RequestMapping("/a.do")
    public String web(ModelMap maps){
        List<User> lists= dao.sel();
        maps.put("lists",lists);
        return "a";
    }
    @RequestMapping("/update.do")
    public String update(int userId,ModelMap maps){
        User user = dao.selOne(userId);
        maps.put("user",user);
        return "update";
    }
    @RequestMapping("/doupdate.do")
    public String doUpdate(User user){
        dao.update(user);
        System.out.println(user);
        return "redirect:a.do";
    }
    @RequestMapping("/delete.do")
    public String delete(User user){
        dao.del(user.getUserId());
        return "redirect:a.do";
    }
    @RequestMapping("/add.do")
    public String add(){
        return "add";
    }
    @RequestMapping("/doadd.do")
    public String doAdd(User user){
        dao.add(user);
        System.out.println(user);
        return "redirect:a.do";
    }



























}
