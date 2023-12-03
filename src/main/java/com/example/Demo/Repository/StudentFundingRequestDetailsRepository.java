package com.example.Demo.Repository;

import com.example.Demo.Entity.UserFundingRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentFundingRequestDetailsRepository extends JpaRepository<UserFundingRequestDetails, Long> {

    @Modifying
    @Transactional
    @Query("Update UserFundingRequestDetails s set s.Status= :uniVerified  where s.username= :username")
    void updateVerifiedStatus( @Param("username") String username, @Param("uniVerified")  String uniVerified);

    @Query("From UserFundingRequestDetails s where s.username IN :emailIds")
    List<UserFundingRequestDetails> findAllByusername(@Param("emailIds") List<String> emailIds);

    @Transactional
    @Modifying
    @Query("update UserFundingRequestDetails ue set ue.Status = :Status where ue.username IN :username")
    void updateStausToApproved(@Param("Status") String Status,@Param("username") List<String> username);


    @Query("select e from  UserFundingRequestDetails e where e.Status=:Status")
    List<UserFundingRequestDetails> findAllByStatus(@Param("Status") String Status);
}
