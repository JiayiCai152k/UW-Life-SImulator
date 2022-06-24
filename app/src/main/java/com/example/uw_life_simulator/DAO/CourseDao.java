package com.example.uw_life_simulator.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.uw_life_simulator.data.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Query("SELECT * FROM course")
    List<Course> getAll();

    @Query("SELECT code FROM course")
    List<String> getCourseCode();

    @Query("SELECT * FROM course WHERE code = :courseCode")
    List<Course> getCourseWithCode(String courseCode);

    @Insert
    void insertAll(Course course);

    @Delete
    void delete(Course course);

    // update the isChecked column, given a course Code
    @Query("UPDATE Course SET isChecked = 1 WHERE code = :CourseCode")
    void update_check(String CourseCode);

    // clear the table
    @Query("DELETE FROM Course")
    void deleteAll();

    // Uncheck all courses
    @Query("UPDATE Course SET isChecked = 0 WHERE isChecked = 1")
    void update_uncheckAll();


}
