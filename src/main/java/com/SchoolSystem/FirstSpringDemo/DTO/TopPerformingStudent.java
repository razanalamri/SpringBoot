package com.SchoolSystem.FirstSpringDemo.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class TopPerformingStudent {

    String studentName;
    String schoolName;
}
