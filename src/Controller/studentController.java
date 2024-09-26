/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dto.studentDto;
import model.StudentModel;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaweesha
 */
public class studentController {
    private static StudentModel model=new StudentModel();


    public static ArrayList<studentDto> getAllStudent() throws ClassNotFoundException, SQLException {
        ArrayList<studentDto> studentDtos=model.getAllStudent();
        return studentDtos;
    }
    public static String saveStudent(studentDto dto) throws SQLException, ClassNotFoundException {
           String resp= model.saveStudent(dto);
           return resp;


    }
    public static studentDto searchStudent(String id) throws SQLException, ClassNotFoundException {
            studentDto dto=model.searchStudent(id);
            return dto;

    }
    public static String deleteStudent(String id) throws SQLException, ClassNotFoundException {
        String resp=model.deleteStudent(id);
        return resp;

    }
    public static String updateStudent(studentDto dto) throws SQLException, ClassNotFoundException {
           String resp=model.updateStudent( dto);
           return resp;


    }
}
