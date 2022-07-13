package com.smart.project.web.home.act;

import com.smart.project.web.home.service.MemberService;
import com.smart.project.web.home.vo.JoinVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


@Slf4j
@Controller
@RequiredArgsConstructor
public class KakaoAct {

    private final MemberService ms;

    @RequestMapping(value="/kakaoLogin", method=RequestMethod.GET)
    public String kakaoLogin(@RequestParam("code") String code, Model model) throws Exception {
        log.error("#########" + code);
        String access_Token = ms.getAccessToken(code);
        HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
        log.error("###access_Token#### : " + access_Token);
        log.error("###nickname#### : " + userInfo.get("nickname"));
        log.error("###email#### : " + userInfo.get("email"));
        String email = (String) userInfo.get("email");
        String nick = (String) userInfo.get("nickname");


        model.addAttribute("email", email);
        model.addAttribute("nick", nick);

        return "redirect:/check";
    }

    @RequestMapping("/check")
    public void check(String email, String nick, Model model){
//        log.error(email);
//        log.error(nick);
        model.addAttribute("email", email);
        model.addAttribute("nick", nick);





//        RestAPIUtil.sendMessage();

    }

    @GetMapping("/")
    public String home(){

        return "Logout";
    }


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @RequestMapping("/join")
    public void join(String id, String pw){
        JoinVO vo = new JoinVO(id, pw);

    }

    @RequestMapping("/kakaoTest")
    public String kakaoTest(){

        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id=25a37c50318e2035fbf657a56a6ac6e0&redirect_uri=http://localhost/kakaoLogin&response_type=code";

    }


//
//    @RequestMapping("/test99")
//    public void kakaoTest99(){
//        URL url = new URL("https://kauth.kakao.com/v2/push/register");
//        String postData = "foo1=bar1&foo2=bar2";
//
//        URLConnection conn = url.openConnection();
//        conn.setDoOutput(true);
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setRequestProperty("Authorization", "");
//
//        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
//            dos.writeBytes(postData);
//        }
//
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
//                conn.getInputStream())))
//        {
//            String line;
//            while ((line = bf.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }





}