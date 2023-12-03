package com.example.Demo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="University_EMAIL_MAPPER")
public class UniversityToUniversityEMailMapper {

    @Id
    private String universityName;
    private String universityEmail;
}
