package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.DTO.CourseMarkObjectForJasper;
import com.SchoolSystem.FirstSpringDemo.DTO.SchoolStudentObjectForJasper;
import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.CourseRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.MarkRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportServices {
    public static final String pathToReports = "C:\\Users\\user012\\Downloads\\Reports";
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MarkRepository markRepository;

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        var dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";

    }

    public String generateReportForStudent() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<SchoolStudentObjectForJasper> studentObjectForJasperList = new ArrayList<>();
        for (Student student : studentList) {
            String studentName = student.getStudentName();
            String schoolName = student.getSchool().getSchoolName();
            Integer studentId = student.getId();
            SchoolStudentObjectForJasper schoolStudentObjectForJasper = new SchoolStudentObjectForJasper(studentName, schoolName, studentId);
            studentObjectForJasperList.add(schoolStudentObjectForJasper);
        }

        File file = ResourceUtils.getFile("classpath:SchoolStudentReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        var dataSource = new JRBeanCollectionDataSource(studentObjectForJasperList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Students.pdf");
        return "Report generated : " + pathToReports + "\\Students.pdf";


    }

    public String generateReportForCourse() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<CourseMarkObjectForJasper> CourseMarkObjectForJasperList = new ArrayList<>();
        for (Mark mark : markList) {
            String courseName =mark.getCourse().getCourseName();
            Integer obtainedMarks = mark.getObtainedMarks();
            String grade = mark.getGrade();
            CourseMarkObjectForJasper courseMarkObjectForJasper = new CourseMarkObjectForJasper(courseName, obtainedMarks, grade);
            CourseMarkObjectForJasperList.add(courseMarkObjectForJasper);
        }

        File file = ResourceUtils.getFile("classpath:CourseMarkReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        var dataSource = new JRBeanCollectionDataSource(CourseMarkObjectForJasperList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Courses.pdf");
        return "Report generated : " + pathToReports + "\\Courses.pdf";


    }


}