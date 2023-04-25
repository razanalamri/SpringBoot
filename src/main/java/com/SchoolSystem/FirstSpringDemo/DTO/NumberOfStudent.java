package com.SchoolSystem.FirstSpringDemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@AllArgsConstructor
@Setter
public class NumberOfStudent {
    String schoolName;
    Integer numberOfStudents;
}

