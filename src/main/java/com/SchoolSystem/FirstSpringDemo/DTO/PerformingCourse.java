package com.SchoolSystem.FirstSpringDemo.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class PerformingCourse {
    String schoolName;
    String courseName;
}
