package com.smart.project.web.home.act;

import com.mysql.cj.protocol.Message;
import com.smart.project.component.CommonCodeComponent;
import com.smart.project.component.data.CodeObject;
import com.smart.project.proc.Test;
import com.smart.project.util.RestAPIUtil;
import com.smart.project.web.home.vo.JoinVO;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeTestAct3 {

    public final Test test;



    @RequestMapping("/index")// <-- address
    public void index() {

    }

    @RequestMapping("/gwang1145")
    public void gwang1145(Model model){



//        log.error("join test");
//
//        JoinVO vo = new JoinVO("ff", "ff");
//        int cnt = test.join(vo);
//        log.error("join==>{}", cnt);
//
//        log.error("login test");

        JoinVO vo = new JoinVO("ff", "ff");
        JoinVO mvo = test.login(vo);
        log.error("test 성공 {}", mvo.getId());
        log.error("test 성공 {}", mvo.getPw());
        log.error("test 성공 {}", mvo.getNick());

        model.addAttribute("gwang", mvo);



//        model.addAttribute("gwang",starJ[0]);
//        model.addAttribute("gwang1",vo.get(0).getId());

    }

    @RequestMapping("/login")
    public void login() {


    }










}
