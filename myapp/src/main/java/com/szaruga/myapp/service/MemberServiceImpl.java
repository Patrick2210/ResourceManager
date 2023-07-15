package com.szaruga.myapp.service;

import com.szaruga.myapp.dao.MembersRepository;
import com.szaruga.myapp.entity.Members;
import com.szaruga.myapp.myenum.MyEnumString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MembersService {

    private MembersRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MembersRepository theMemberRepository) {
        memberRepository = theMemberRepository;
    }

    @Override
    public List<Members> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Members findById(int theId) {
        Optional<Members> result = memberRepository.findById(theId);
        Members theMember;

        if (result.isPresent()) {
            theMember = result.get();
        } else {
            throw new RuntimeException(MyEnumString.MEMBER.myString +
                    MyEnumString.ID_NOT_FOUND.myString + theId);
        }
        return theMember;
    }

    @Override
    public Members save(Members theMember) {
        return memberRepository.save(theMember);
    }

    @Override
    public void deleteById(int theId) {
        memberRepository.deleteById(theId);
    }
}