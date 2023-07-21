package com.szaruga.myapp;

import com.szaruga.myapp.dao.ItemsRepository;
import com.szaruga.myapp.dao.MembersRepository;
import com.szaruga.myapp.entity.Items;
import com.szaruga.myapp.entity.Members;
import com.szaruga.myapp.myenum.MyStrings;
import com.szaruga.myapp.myinput.ItemsInput;
import com.szaruga.myapp.myinput.MembersInput;
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
    public CommandLineRunner commandLineRunner(ItemsRepository itemsRepository, MembersRepository membersRepository) {
        return runner -> {
            createMemberWithItems(itemsRepository, membersRepository);
        };
    }

    private void createMemberWithItems(ItemsRepository itemsRepository, MembersRepository membersRepository) {
        Members member = MembersInput.memberOne();
        Items itemOne = ItemsInput.itemOne();
        Items itemTwo = ItemsInput.itemTwo();

        System.out.println(MyStrings.SAVING_MEMBER.myString + member);
        membersRepository.save(member);

        System.out.println(MyStrings.THE_ITEM.myString + itemOne.getItemName());
        itemsRepository.save(itemOne);

        System.out.println(MyStrings.THE_ITEM.myString + itemTwo.getItemName());
        itemsRepository.save(itemTwo);

        System.out.println(MyStrings.DONE.myString);
    }
}
