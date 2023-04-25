package com.SchoolSystem.FirstSpringDemo.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class NumberOfMarks {
    String courseName;
    String grade;
    Integer countOfMarks;
}
