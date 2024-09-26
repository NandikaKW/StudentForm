/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Db.DBConnection;
import dto.studentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaweesha
 */
public class StudentModel {
    public  ArrayList<studentDto> getAllStudent() throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM students";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
           ResultSet set=preparedStatement.executeQuery();
        ArrayList<studentDto> studentDtos=new ArrayList<>();

        while(set.next()){
            studentDto dto=new studentDto();
            dto.setStudentId(set.getString(1));
            dto.setName((set.getString(2)));
            dto.setEmail(set.getString(3));
            dto.setCourse(set.getString(4));
            studentDtos.add(dto);

        }
        return studentDtos;



    }
    public  String saveStudent( studentDto dto) throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getInstance().getConnection();
        String sql="INSERT INTO students  VALUES(?,?,?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,dto.getStudentId());
        statement.setString(2,dto.getName());
        statement.setString(3,dto.getEmail());
        statement.setString(4,dto.getCourse());

          int rst=statement.executeUpdate();
          return rst> 0 ? "Suceesfully Saved!":"Cannot Be Saved!";




    }
    public  studentDto searchStudent( String id) throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM students WHERE studentID=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,id);

        ResultSet rst=statement.executeQuery();

        while(rst.next()){
            studentDto dto=new studentDto();
            dto.setStudentId(rst.getString(1));
            dto.setName(rst.getString(2));
            dto.setEmail(rst.getString(3));
            dto.setCourse(rst.getString(4));

            return dto;




        }
        return null;

    }
    public  String deleteStudent( String id) throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getInstance().getConnection();
        String sql="DELETE FROM students WHERE studentID=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,id);
        int resp=statement.executeUpdate();
        return resp>0 ? "Delete Sucess!":"Student is not Deleted !";

    }
    public  String updateStudent( studentDto dto) throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getInstance().getConnection();
        String sql="UPDATE students SET name=?,email=?,course=? WHERE studentID=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,dto.getName());
        statement.setString(2,dto.getEmail());
        statement.setString(3,dto.getCourse());
        statement.setString(4,dto.getStudentId());

        int resp=statement.executeUpdate();
        return resp>0 ? " Order  Update Sucessfully!":"Order Not Updated !";


    }
}
