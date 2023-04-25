package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.DTO.*;
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

    @Autowired
    CourseRepository courseRepository;

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

//    public String generateReportForCourse() throws FileNotFoundException, JRException {
//        List<Mark> markList = markRepository.getAllMarks();
//        List<CourseMarkObjectForJasper> CourseMarkObjectForJasperList = new ArrayList<>();
//        for (Mark mark : markList) {
//            String courseName =mark.getCourse().getCourseName();
//            Integer obtainedMarks = mark.getObtainedMarks();
//            String grade = mark.getGrade();
//            CourseMarkObjectForJasper courseMarkObjectForJasper = new CourseMarkObjectForJasper(courseName, obtainedMarks, grade);
//            CourseMarkObjectForJasperList.add(courseMarkObjectForJasper);
//        }
//
//        File file = ResourceUtils.getFile("classpath:CourseMarkReport.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        var dataSource = new JRBeanCollectionDataSource(CourseMarkObjectForJasperList);
//        Map<String, Object> paramters = new HashMap<>();
//        paramters.put("CreatedBy", "Razan");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Courses.pdf");
//        return "Report generated : " + pathToReports + "\\Courses.pdf";
//
//
//    }



    public String averageMarksReport() throws FileNotFoundException, JRException {
        List<Mark> marksList = markRepository.getAllMarks();
        List<CourseMarkObjectForJasper> courseMarkObject = new ArrayList<>();
        Map<String, Integer> courseMapWithMark = new HashMap<>();

        for (Mark m : marksList) {

            String courseName = m.getCourse().getCourseName();

            if (!courseMapWithMark.containsKey(courseName)) {
                courseMapWithMark.put(courseName, m.getObtainedMarks());
            } else {
                Integer previousCourseMark = courseMapWithMark.get(courseName);
                previousCourseMark = previousCourseMark + m.getObtainedMarks();
                courseMapWithMark.put(courseName, previousCourseMark);

            }
        }

        for (String keyCourseName : courseMapWithMark.keySet()) {
            Integer numberOfMarkByCourse = markRepository.getNumberOfMarksByCourseName(keyCourseName);
            Integer marks = courseMapWithMark.get(keyCourseName);
            Integer average = marks / numberOfMarkByCourse;
            CourseMarkObjectForJasper markObject = new CourseMarkObjectForJasper();
            markObject.setAvgMark(average);
            markObject.setCourseName(keyCourseName);
            courseMarkObject.add(markObject);
        }
        File file = ResourceUtils.getFile("classpath:AverageMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkObject);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AverageMarkReport.pdf");
        return "Report generated : " + pathToReports + "\\AverageMarkReport.pdf";
    }


    public String TopPerformingStudentInEachSchool() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<TopPerformingStudent> topPreformingStudentDTOSList = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentsBySchoolId(school.getId());
            Integer TopMark = 0;
            Student studentWithHighestMarks = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarksByStudentId(studentId);
                if (studentTotalMark != null && studentTotalMark > TopMark) {
                    TopMark = studentTotalMark;
                    studentWithHighestMarks = student;
                }
            }
            topPreformingStudentDTOSList.add(new TopPerformingStudent(studentWithHighestMarks.getStudentName(), school.getSchoolName()));
        }

        File file = ResourceUtils.getFile("classpath:TopPerformingStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPreformingStudentDTOSList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPerformingReport.pdf");
        return "Report generated : " + pathToReports + "\\TopPerformingReport.pdf";

    }


    public String OverAllPerformance() throws Exception {
        List<Student> studentList = studentRepository.getAllStudent();
        List<OverallPerformance> studentMarks = new ArrayList<>();
        for (Student student : studentList) {
            String studentName = student.getStudentName();
            String studentEmail = student.getEmail();
            Integer avgOfMarksByStudentId = markRepository.getAvgOfMarksByStudentId(student.getId());
            OverallPerformance studentDto = new OverallPerformance(studentName,studentEmail, avgOfMarksByStudentId);
            studentMarks.add(studentDto);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentMarks);
        File file = ResourceUtils.getFile("classpath:OverAll.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\OverAll.pdf");
        return "Report generated : " + pathToReports + "\\OverAll.pdf";

    }

    public String TotalNumberOfStudentsInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<NumberOfStudent> countOfStudent = new ArrayList<>();
        for (School school : schoolList) {
            Integer schoolId = school.getId();
            String schoolName = school.getSchoolName();
            Integer countOfStudents = studentRepository.getCountOfStudentsBySchoolId(schoolId);
            NumberOfStudent countOfStudentWithSchoolDTO = new NumberOfStudent(schoolName, countOfStudents);
            countOfStudent.add(countOfStudentWithSchoolDTO);
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(countOfStudent);
        File file = ResourceUtils.getFile("classpath:NumberOfStudents.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\NumberOfStudents.pdf");
        return "Report generated : " + pathToReports + "\\NumberOfStudents.pdf";
    }



    public String NumberOfMarks() throws Exception {
        List<String> coursesNames = courseRepository.getAllCoursesNames();
        List<String> listOfUniqueGrades = markRepository.getDistinctGrades();
        List<NumberOfMarks> courseWithGradesDTOS = new ArrayList<>();
        for (String courseName : coursesNames) {
            for (String grade : listOfUniqueGrades) {
                Integer countOfMarksByGradeAndCourseName = markRepository.getCountOfMarksByGradeAndCourseName(grade, courseName);
                courseWithGradesDTOS.add(new NumberOfMarks(courseName,grade,countOfMarksByGradeAndCourseName));
            }
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseWithGradesDTOS);
        File file = ResourceUtils.getFile("classpath:CountOfMarks.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CountOfMarks.pdf");
        return "Report generated : " + pathToReports + "\\CountOfMarks.pdf";
    }

    public String PerformanceCoursesInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        Map<School,Course> schoolCourseMap = new HashMap<>();
        List<PerformingCourse> topPerformingCourseDTOS = new ArrayList<>();
        for (School school : schoolList) {
            Integer schoolId = school.getId();
            List<Course> courseList = courseRepository.getCourseBySchoolId(schoolId);
            Integer highestAverageMarkForCourses = 0;
            Course courseWithHighestMark = new Course();
            for (Course course : courseList) {
                Integer courseId = course.getId();
                Integer averageMarkForCourse = markRepository.averageMarkForCourse(courseId);
                if (averageMarkForCourse != null && averageMarkForCourse > highestAverageMarkForCourses) {
                    highestAverageMarkForCourses = averageMarkForCourse;
                    courseWithHighestMark = course;
                }
                topPerformingCourseDTOS.add(new PerformingCourse(school.getSchoolName(), courseWithHighestMark.getCourseName()));
            }
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPerformingCourseDTOS);
        File file = ResourceUtils.getFile("classpath:TopPerformingCourses.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\PerformingCourse.pdf");
        return "Report generated : " + pathToReports + "\\PerformingCourse.pdf";
    }



    public String generateNewStudentWithHighCourseScore(Integer courseHighestMark) throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<StudentWithHighCourseScore> studentWithHighCourseScores = new ArrayList<>();
        for (School school : schoolList) {
            String schoolName = school.getSchoolName();
            Integer schoolId = school.getId();
            Integer averageOfAllStudentsMarks = markRepository.getAvgOfMarksBySchoolId(schoolId);
            studentWithHighCourseScores.add(new StudentWithHighCourseScore(schoolName, averageOfAllStudentsMarks));
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentWithHighCourseScores);
        File file = ResourceUtils.getFile("classpath:StudentWithHighCourseScore.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPerformingCourse.pdf");
        return "Report generated : " + pathToReports + "\\TopPerformingCourse.pdf";
    }
    }























