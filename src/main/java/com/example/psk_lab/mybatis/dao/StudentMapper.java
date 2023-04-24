package com.example.psk_lab.mybatis.dao;

import com.example.psk_lab.mybatis.model.Student;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Mon Apr 24 03:05:35 EEST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Mon Apr 24 03:05:35 EEST 2023
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Mon Apr 24 03:05:35 EEST 2023
     */
    Student selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Mon Apr 24 03:05:35 EEST 2023
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Mon Apr 24 03:05:35 EEST 2023
     */
    int updateByPrimaryKey(Student record);
}