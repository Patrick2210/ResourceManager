package com.szaruga.myapp;

import com.szaruga.myapp.dao.ItemsRepository;
import com.szaruga.myapp.dao.MembersRepository;
import com.szaruga.myapp.entity.Items;
import com.szaruga.myapp.entity.Members;
import com.szaruga.myapp.myenum.MyStrings;
import com.szaruga.myapp.myinput.ItemsInput;
import com.szaruga.myapp.myinput.MembersInput;
import com.szaruga.myapp.service.ItemsServiceImpl;
import com.szaruga.myapp.service.MemberServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoResourceManagerApp {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoResourceManagerApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ItemsServiceImpl itemsService, MemberServiceImpl memberService) {
        return runner -> {
            /**
             *createMemberWithItems(itemsService, memberService);
             * deleteMemberWithId(memberService);
             * findMemberWithItems(memberService);
             */

        };
    }

    private void findMemberWithItems(MemberServiceImpl memberService) {

        int theId = 2;
        System.out.println(MyStrings.FINDING_MEMBER.myString + theId);
        Members theMember = memberService.findMemberById(theId);
        System.out.println(MyStrings.MEMBER.myString + theMember);
        System.out.println(MyStrings.ASSOCIATED_ITEMS.myString + theMember.getItems());
        System.out.println(MyStrings.DONE.myString);
    }

    private void deleteMemberWithId(MemberServiceImpl memberService) {
        int theId = 1;
        System.out.println(MyStrings.MEMBER_DELETE.myString + theId);
        memberService.deleteMemberById(theId);
        System.out.println(MyStrings.DONE.myString);
    }

    private void createMemberWithItems(ItemsServiceImpl itemsService, MemberServiceImpl memberService) {
        Members member = MembersInput.memberOne();
        Items itemOne = ItemsInput.itemOne();
        Items itemTwo = ItemsInput.itemTwo();

        System.out.println(MyStrings.SAVING_MEMBER.myString + member);
        memberService.saveMember(member);

        System.out.println(MyStrings.THE_ITEM.myString + itemOne.getItemName());
        itemsService.saveItem(itemOne);

        System.out.println(MyStrings.THE_ITEM.myString + itemTwo.getItemName());
        itemsService.saveItem(itemTwo);

        System.out.println(MyStrings.DONE.myString);
    }
}
