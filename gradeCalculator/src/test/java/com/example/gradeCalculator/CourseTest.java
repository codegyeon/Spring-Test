package com.example.gradeCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {

    @DisplayName("과목(코스) 를 생성")
    @Test
    void createTest(){
        assertThatCode(()-> new Course("OOP" , 3,"A+"))
                .doesNotThrowAnyException();
    }
}
