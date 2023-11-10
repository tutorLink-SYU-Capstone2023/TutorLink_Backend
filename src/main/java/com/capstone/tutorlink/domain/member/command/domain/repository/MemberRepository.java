package com.capstone.tutorlink.domain.member.command.domain.repository;

import com.capstone.tutorlink.domain.member.command.domain.aggregate.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByMemberIdAndMemberCurrentStatus(String memberId, String memberCurrentStatus);
    Member findByMemberNo(int memberNo);

    @Query("SELECT m FROM Member m JOIN m.memberRoleList r WHERE r.authority.authorityName = 'ROLE_TUTEE'")
    Page<Member> findAllTutee(org.springframework.data.domain.Pageable pageable);

    @Query("SELECT m FROM Member m JOIN m.memberRoleList r WHERE r.authority.authorityName = 'ROLE_TUTOR'")
    Page<Member> findAllTutor(org.springframework.data.domain.Pageable pageable);

}
