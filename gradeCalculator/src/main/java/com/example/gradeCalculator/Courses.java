package com.example.gradeCalculator;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public  double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
//        double multepliedCreditAndCourseGrade = 0;
//        for (Course course : courses){
//            multepliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//        return multepliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

    }
}
