package controller;

import data.model.student;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@ManagedBean(name = "studentController")

public class studentController {

        public ArrayList<student>getStudent(){
            ArrayList<student>records=new ArrayList<>();
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","std","dip");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select* from students");
                while(rs.next())
                {
                    student stud=new student();
                    stud.setRoll(rs.getInt(1));
                    stud.setName(rs.getString(2));
                    records.add(stud);
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
            return records;
        }

  public String isNextPage(){
        return "success";
  }
}
