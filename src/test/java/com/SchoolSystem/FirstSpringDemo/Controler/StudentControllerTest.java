package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {
@Autowired
    StudentController studentController;

    @Test
    void getAllStudents() throws  Exception{
        List<Student> allStudents = studentController.getAllStudents();
        assertNotNull(allStudents);
    }

    @Test
    void getStudentByIdWhenId1() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getStudentById(1);
        String studentName=studentToTest.getStudentName();
        assertEquals("razan",studentName);
    }
    @Test
    void getStudentByIdWhenId4() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getStudentById(4);
        String studentName=studentToTest.getStudentName();
        assertEquals("Shiam",studentName);
    }
    @Test
    void getStudentByIdWhenId5() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getStudentById(5);
        String studentName=studentToTest.getStudentName();
        assertEquals("Asaad",studentName);
    }
    @Test
    void getStudentByIdWhenId6() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getStudentById(6);
        String studentName=studentToTest.getStudentName();
        assertEquals("Reem",studentName);
    }

    @Test
    void getByStudentNameRazan() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getByStudentName("razan");
        int id=studentToTest.getId();
        assertEquals(1,id);
    }
    @Test
    void getByStudentNameShiam() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getByStudentName("Shiam");
        int id=studentToTest.getId();
        assertEquals(4,id);
    }

    @Test
    void getByStudentNameAsaad() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getByStudentName("Asaad");
        int id=studentToTest.getId();
        assertEquals(5,id);
    }

    @Test
    void getByStudentNameReem() throws Exception {
        Student studentToTest;
        studentToTest = studentController.getByStudentName("Reem");
        int id=studentToTest.getId();
        assertEquals(6,id);
    }



    @Test
    void getByAge12() throws Exception {

        Student studentToTest;
        studentToTest = studentController.getByAge(12);
        String studentName = studentToTest.getStudentName();
        assertEquals("razan", studentName);
    }

    @Test
    void getByAge13() throws Exception {

        Student studentToTest;
        studentToTest = studentController.getByAge(13);
        String studentName = studentToTest.getStudentName();
        assertEquals("Shiam", studentName);
    }

    @Test
    void getByAge10() throws Exception {

        Student studentToTest;
        studentToTest = studentController.getByAge(10);
        String studentName = studentToTest.getStudentName();
        assertEquals("Asaad", studentName);
    }

    @Test
    void getByAge9() throws Exception {

        Student studentToTest;
        studentToTest = studentController.getByAge(9);
        String studentName = studentToTest.getStudentName();
        assertEquals("Reem", studentName);
    }

    @Test
    void getAllActive() {
        List<Student> activeStudents = studentController.getAllActive();
        assertNotNull(activeStudents);
    }

    @Test
    void getAllInActive() {
        List<Student> InactiveStudents = studentController.getAllInActive();
        assertNotNull(InactiveStudents);
    }

    @Test
    void getLatestRow()throws Exception {
        List<Student> latestRow = studentController.getLatestRow();
        assertNotNull(latestRow);
    }

    @Test
    void getLatestUpdate() throws Exception {
        List<Student> latestUpdate = studentController.getLatestUpdate();
        assertNotNull(latestUpdate);
    }

    @Test
    void getByCreatedDate() {
        Student studentToTest;
        studentToTest = studentController.getByCreatedDate(valueOf("2012-11-02"));
        String studentName=studentToTest.getStudentName();
        assertEquals("razan",studentName);
    }

    @Test
    void getByUpdatedDate() {
        Student studentToTest;
        studentToTest = studentController.getByUpdatedDate(valueOf("2001-03-05"));
        String studentName=studentToTest.getStudentName();
        assertEquals("razan",studentName);
    }


}