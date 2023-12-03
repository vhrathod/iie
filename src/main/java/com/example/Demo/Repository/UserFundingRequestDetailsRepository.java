package com.example.Demo.Repository;

import com.example.Demo.Dto.UserRequestProjection;
import com.example.Demo.Entity.UserFundingRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserFundingRequestDetailsRepository extends JpaRepository<UserFundingRequestDetails, Long> {

    @Modifying
    @Transactional
    @Query("Update UserFundingRequestDetails s set s.status= :uniVerified  where s.username= :username")
    void updateVerifiedStatus( @Param("username") String username, @Param("uniVerified")  String uniVerified);

    @Query("From UserFundingRequestDetails s where s.username IN :emailIds")
    List<UserFundingRequestDetails> findAllByusername(@Param("emailIds") List<String> emailIds);

    @Transactional
    @Modifying
    @Query("update UserFundingRequestDetails ue set ue.status = :Status where ue.username IN :username")
    void updateStausToApproved(@Param("status") String status,@Param("username") List<String> username);


    @Query("select e from  UserFundingRequestDetails e where e.status=:status")
    List<UserFundingRequestDetails> findAllByStatus(@Param("status") String status);


    List<UserRequestProjection> findAllByUsername(String username);

    UserFundingRequestDetails findByNameOfIdeaOrStartup(String nameOfIdeaOrStartup);
    UserFundingRequestDetails findByNameOfIdeaOrStartupAndUuid(String nameOfIdeaOrStartup, UUID uuid);
    UserFundingRequestDetails findByUuid(UUID uuid);
}
