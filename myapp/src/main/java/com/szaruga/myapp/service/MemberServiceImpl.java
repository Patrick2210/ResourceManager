package com.szaruga.myapp.service;

import com.szaruga.myapp.dao.MembersRepository;
import com.szaruga.myapp.entity.Members;
import com.szaruga.myapp.myenum.MyStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Members> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Members findMemberById(int theId) {
        Optional<Members> result = memberRepository.findById(theId);
        Members theMember;

        if (result.isPresent()) {
            theMember = result.get();
        } else {
            throw new RuntimeException(MyStrings.MEMBER.myString +
                    MyStrings.ID_NOT_FOUND.myString + theId);
        }
        return theMember;
    }

    @Override
    @Transactional
    public Members saveMember(Members theMember) {
        return memberRepository.save(theMember);
    }

    @Override
    @Transactional
    public void deleteMemberById(int theId) {
        memberRepository.deleteById(theId);
    }
}