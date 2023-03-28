package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Services.SchoolServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static java.sql.Date.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class SchoolControllerTest {

    @Autowired
    SchoolController schoolController;




    @Test
    void getAllSchools() throws Exception {
        List<School> allSchools = schoolController.getAllSchools();
        assertNotNull(allSchools);
    }

    @Test
    void getSchoolByIdWhenId1() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getSchoolById(1);
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("Muscat ",schoolName);

    }

    @Test
    void getSchoolByIdWhenId2() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getSchoolById(2);
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("Seeb ",schoolName);
    }

    @Test
    void getSchoolByIdWhenId3() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getSchoolById(3);
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("NTI ",schoolName);
    }

    @Test
    void getSchoolByIdWhenId4() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getSchoolById(4);
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("TechnoPark ",schoolName);
    }

    @Test
    void getBySchoolNameMuscat() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getBySchoolName("Muscat ");
        int id=schoolToTest.getId();
        assertEquals(1,id);
    }

    @Test
    void getBySchoolNameSeeb() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getBySchoolName("Seeb ");
        int id=schoolToTest.getId();
        assertEquals(2,id);
    }

    @Test
    void getBySchoolNameNTI() throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getBySchoolName("NTI ");
        int id=schoolToTest.getId();
        assertEquals(3,id);
    }

    @Test
    void getBySchoolNameTechnoPark () throws Exception{
        School schoolToTest;
        schoolToTest = schoolController.getBySchoolName("TechnoPark  ");
        int id=schoolToTest.getId();
        assertEquals(4,id);
    }



    @Test
    void getByCreatedDate1() throws Exception{
        School schoolToTest;
        schoolToTest = schoolController.getByCreatedDate(valueOf("2010-10-23"));
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("Muscat ",schoolName);
    }

    @Test
    void getByCreatedDate2() throws Exception{
        School schoolToTest;
        schoolToTest = schoolController.getByCreatedDate(valueOf("2011-03-01"));
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("Seeb ",schoolName);
    }

    @Test
    void getByCreatedDate3() throws Exception{
        School schoolToTest;
        schoolToTest = schoolController.getByCreatedDate(valueOf("2009-04-05"));
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("NTI ",schoolName);
    }

    @Test
    void getByCreatedDate4() throws Exception{
        School schoolToTest;
        schoolToTest = schoolController.getByCreatedDate(valueOf("2012-04-06"));
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("TechnoPark ",schoolName);
    }

    @Test
    void getByUpdatedDateFirstSchool() throws Exception{
       School schoolToTest = schoolController.getByUpdatedDate(valueOf("2020-12-22"));
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("NTI ",schoolName);
    }


@Test
    void getByUpdatedDateSecondSchool()throws Exception {
        School schoolToTest;
        schoolToTest = schoolController.getByUpdatedDate(valueOf("2023-01-01"));
        String schoolName=schoolToTest.getSchoolName();
        assertEquals("TechnoPark ",schoolName);
    }


    @Test
    void getAllActive() throws Exception{
            List<School> activeSchools = schoolController.getAllActive();
            assertNotNull(activeSchools);

    }

    @Test
    void getAllInActive() throws Exception{
        List<School> InActiveSchools = schoolController.getAllInActive();
        assertNotNull(InActiveSchools);

    }

    @Test
    void getLatestRow()throws Exception {
        List<School> latestRow = schoolController.getLatestRow();
        assertNotNull(latestRow);
    }

    @Test
    void getLatestUpdate() throws Exception {
        List<School> latestUpdate = schoolController.getLatestUpdate();
        assertNotNull(latestUpdate);
    }
    
}