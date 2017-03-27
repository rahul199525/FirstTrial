
package javaapplication4;

import java.sql.DriverManager;
import java.sql.*;


public class JavaApplication4 {

    public static void main(String[] args) {
        
        JavaApplication4 jv=new JavaApplication4();
        //jv.enter();
        jv.show();
        }
    
    
    void show()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","");
        PreparedStatement stmt=co.prepareStatement("Select * from num1 where rollno = ?");
        stmt.setInt(1,61);
        ResultSet rs=stmt.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getString(1)+ "  " +rs.getInt(2));
            
        }
        co.close();
        }
        catch(Exception e){ System.out.println(e);}
    
    }
    void enter()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","");
        Statement stmt=con.createStatement();
        PreparedStatement ps=con.prepareStatement("Insert into num1 (name,rollno)" +"values(?,?)");
        ps.setString(1,"tk");
        ps.setInt(2,74);
        
        ps.executeUpdate();
        con.close();
        
    }
        catch(ClassNotFoundException cnf)
	{
            System.out.println("Cnf Exception");
        }	
        catch(SQLException sql)
        {
           System.out.println(sql);
        }
   }
}
