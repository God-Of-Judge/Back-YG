package com.smart.project.web.home.act;

import com.smart.project.web.home.service.MemberService;
import com.smart.project.web.home.vo.JoinVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;

public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @GetMapping("/members/new")
    public String create(MemberForm form){
        JoinVO vo = new JoinVO();
        vo.setName(form.getName());

        memberService.join(vo);
        return "redirect:/";
    }
}
