package com.szaruga.myapp.rest;

import com.szaruga.myapp.entity.Members;
import com.szaruga.myapp.myenum.MyStrings;
import com.szaruga.myapp.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MembersRestController {

    private MembersService memberService;

    @Autowired
    public MembersRestController(MembersService theMemberService) {
        memberService = theMemberService;
    }

    @GetMapping("/members")
    public List<Members> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/members/{membersId}")
    public Members getMember(@PathVariable int membersId) {
        Members theMember = memberService.findById(membersId);
        if (theMember == null) {
            throw new RuntimeException(MyStrings.MEMBER.myString +
                    MyStrings.ID_NOT_FOUND.myString + membersId);
        }
        return theMember;
    }

    @PostMapping("/members")
    public Members addMember(@RequestBody Members theMember) {
        theMember.setId(0);
        return memberService.save(theMember);
    }

    @DeleteMapping("/members/{membersId}")
    public String deleteMember(@PathVariable int membersId) {
        Members theUser = memberService.findById(membersId);
        if (theUser == null) {
            throw new RuntimeException(MyStrings.MEMBER.myString +
                    MyStrings.ID_NOT_FOUND.myString + membersId);
        }
        memberService.deleteById(membersId);
        return MyStrings.USER_DELETE.myString + membersId;
    }
}
