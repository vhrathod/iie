package com.example.Demo.Repository;

import com.example.Demo.Entity.UniversityToUniversityEMailMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityTouniversityEmailMapperRepository extends JpaRepository<UniversityToUniversityEMailMapper,String> {
}
