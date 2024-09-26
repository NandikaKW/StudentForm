/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentform;

import view.studentview;
import javax.swing.text.View;
import java.sql.SQLException;

/**
 *
 * @author Kaweesha
 */
public class StudentForm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      studentview view=new studentview();
      view.setVisible(true);
    }
    
}
