package com.szaruga.myapp.service;

import com.szaruga.myapp.dao.MembersRepository;
import com.szaruga.myapp.entity.Members;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.szaruga.myapp.myenum.MyStringsTest.MANAGER;
import static com.szaruga.myapp.myenum.MyStringsTest.USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MembersServiceTest {
    @Mock
    private MembersRepository membersRepository;

    @InjectMocks
    private MemberServiceImpl memberService;
    private Members member;
    private Members memberTwo;


    @BeforeEach
    public void setup() {
        membersRepository = Mockito.mock(MembersRepository.class);
        memberService = new MemberServiceImpl(membersRepository);
        member = Members.builder()
                .id(1)
                .nickName("JohnDoe")
                .firstName("John")
                .lastName("Doe")
                .creationDate(LocalDateTime.of(2023, 7, 18, 10, 30, 20))
                .modificationDate(LocalDateTime.of(2023, 7, 18, 12, 0, 30))
                .userType(USER.myString)
                .build();

        memberTwo = Members.builder()
                .id(2)
                .nickName("G-Viking")
                .firstName("Norway")
                .lastName("Doe")
                .creationDate(LocalDateTime.of(2022, 7, 18, 10, 30, 20))
                .modificationDate(LocalDateTime.of(2023, 1, 10, 9, 0, 30))
                .userType(MANAGER.myString)
                .build();
    }

    @DisplayName("JUnit test for getAllMembers method")
    @Test
    void givenMembersList_whenGetAllMembers_thenReturnMembersList() {
        given(membersRepository.findAll()).willReturn(List.of(member, memberTwo));
        List<Members> membersList = memberService.findAllMembers();
        assertThat(membersList).isNotNull();
        assertThat(membersList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getAllMembers method (negative scenario)")
    @Test
    void givenMembersList_whenGetAllMembers_thenReturnEmptyMembersList() {
        given(membersRepository.findAll()).willReturn(Collections.emptyList());
        List<Members> membersList = memberService.findAllMembers();
        assertThat(membersList).isEmpty();
    }

    @DisplayName("JUnit test for findMemberById method")
    @Test
    void givenMemberId_whenSaveMember_thenConfirmsNotNull() {
        int memberId = 1;
        given(membersRepository.findById(memberId)).willReturn(Optional.of(member));
        Members saveMember = memberService.findMemberById(member.getId());
        assertThat(saveMember).isNotNull();
    }

    @DisplayName("JUnit test for saveMember method")
    @Test
    void givenMemberObject_whenSaveMember_thenReturnMemberObject() {
        given(membersRepository.save(member)).willReturn(member);
        Members savedMember = memberService.saveMember(member);
        assertThat(savedMember).isNotNull();
    }

    @DisplayName("JUnit test for deleteMemberById method")
    @Test
    void givenMemberId_whenDeleteMember_thenNothing() {
        int memberId = 1;
        willDoNothing().given(membersRepository).deleteById(memberId);
        memberService.deleteMemberById(memberId);
        verify(membersRepository, times(1)).deleteById(memberId);
    }
}