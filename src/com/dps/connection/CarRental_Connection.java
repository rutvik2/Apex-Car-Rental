package com.dps.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CarRental_Connection {
    static Connection con=null;
    PreparedStatement psmt=null;
    ResultSet rst=null;
    private static CarRental_Connection crcon=null;
    
    public CarRental_Connection()
    {
        createConnectionDB();
    }
    private void createConnectionDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/carrental_db","root","rutvik"); //connection created with the database
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error in connection");
        }
    }
    
    public Connection getConnectionDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/carrental_db","root","rutvik");                   
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());          
        }
        return con;
    } 
    
    public static CarRental_Connection getInstance()
    {
        if(crcon==null)
        {
            crcon=new CarRental_Connection();
        }
        return crcon;
    }
    
    public int checkLoginDetails(String user,String psd)
    {
        String str="select * from emplist where username=? and password=?";
        PreparedStatement psmt;
        ResultSet rst;
        int id;
        try
        {        
            psmt=con.prepareStatement(str);
            psmt.setString(1,user);
            psmt.setString(2,psd);
            rst=psmt.executeQuery();

            if(rst.next())
            {       
                id=rst.getInt(1);
                return id;
            }
        }
        catch(Exception e)
        {         
            JOptionPane.showMessageDialog(null,"Error in connection");
        }      
        return 0;
      }
    
    public boolean insertEmp(String name,String ad,String gender,String qual,String user,String psd,String dob,String doj,String phone) 
    {
        PreparedStatement psmt;
        try
        {
            ResultSet rst;
            String count="select count(*) from emplist where username=?";
            psmt=con.prepareStatement(count);
            psmt.setString(1, user);
            rst=psmt.executeQuery();
           
            if(rst.next())
            {
                if(rst.getInt(1)>0)
                {
                    return false;
                }
               
            }
            String insert1="insert into empdetails(name,phoneno,address,username,dob,dateofjoin,qualification,gender) values(?,?,?,?,?,?,?,?)" ;
            psmt=con.prepareStatement(insert1);
            
            psmt.setString(1,name);
            psmt.setString(2,phone);
            psmt.setString(3,ad);
            psmt.setString(4,user);
            psmt.setString(5,dob);
            psmt.setString(6,doj);
            psmt.setString(7,qual);
            psmt.setString(8,gender);
          
            psmt.executeUpdate();
            
            String insert2="insert into emplist(username,password) values(?,?)";      
           
            psmt=con.prepareStatement(insert2);
            
            psmt.setString(1,user);
            psmt.setString(2,psd);
           int res=psmt.executeUpdate();
           
           
           return res==1;
       
        }catch(SQLException e)
        {
            System.out.println("Exception in inserting data "+e.getMessage());
        }
       
        return false;  
    }
    public String[] getEmpDetails(String user)
    {
         PreparedStatement psmt;
    ResultSet rst;
        try
    {
    String str="select * from emplist,empdetails where emplist.username=empdetails.username AND emplist.username=?";
   
    String[] details=new String[11];
         
               psmt=con.prepareStatement(str);
               psmt.setString(1,user);
               rst=psmt.executeQuery();
               if(rst.next())
               {     
                  details[0]= rst.getString(5);
                   details[1]= rst.getString(6);
                    details[2]=rst.getString(7);
                    details[3]=rst.getString(8);
                   details[4]= rst.getString(9);
                   details[5]= rst.getString(10);
                    details[6]=rst.getString(11);
                    details[7]=rst.getString(12);
                    details[8]= rst.getString(3);
                    details[9]= rst.getString(1);
                    return details;
               } 
      }
      catch(Exception e)
      {
         
   JOptionPane.showMessageDialog(null,"Error in connection");
   e.printStackTrace();
      }   
            
        return null;
        
    }
    public boolean updateEmpDetails(String name,String phn,String ad,String user,String dob,String doj,String qual,String gender,String id,String psd,String nuser)
    {
          PreparedStatement psmt;
          try{
               
               String str="update empdetails ed,emplist el set ed.name=?,ed.phoneno=?,ed.address=?,ed.username=?,ed.dob=?,ed.dateofjoin=?,ed.qualification=?,ed.gender=?,el.username=?,el.password=? where el.username=ed.username AND el.id=?";
         psmt=con.prepareStatement(str);
             psmt.setString(1,name);
               psmt.setString(2,phn);
               psmt.setString(3,ad);
               psmt.setString(4,nuser);
               psmt.setString(5,dob);
               psmt.setString(6,doj);
               psmt.setString(7,qual);
               psmt.setString(8,gender);
               psmt.setString(9,nuser);
               psmt.setString(10,psd);
               psmt.setString(11,id);
               int res1=psmt.executeUpdate();
               if(res1<=0)
               {
                   return false;
               }
  
               return true;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
    public boolean deleteEmp(String id)
    {
         PreparedStatement psmt;
          try{
               
               String str="delete el,ed from emplist el,empdetails ed where el.username=ed.username AND el.id=?";
         psmt=con.prepareStatement(str);
            
               psmt.setString(1,id);
               int res1=psmt.executeUpdate();
               if(res1<=0)
               {
                   return false;
               }
  
               return true;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
    public boolean addCompany(String company)
    {
         PreparedStatement psmt;
                 ResultSet rst=null;

          try{
               String str="select * from company where company=?";
                psmt=con.prepareStatement(str);
                psmt.setString(1,company);
                rst=psmt.executeQuery();
                if(rst.next())
                {
                    return false;
                }
               String str1="insert into company(company) values(?)";
         psmt=con.prepareStatement(str1);
               psmt.setString(1,company);
               int res1=psmt.executeUpdate();
               if(res1<=0)
               {
                    return false;
               }
               return true;
               
              
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
    public String[] getCompanyList()
    {
        PreparedStatement psmt;
        ResultSet rst = null;
        String[] comp=new String[50];
          try{
               
               String str="select company from company order by company asc";
         psmt=con.prepareStatement(str);
                rst=psmt.executeQuery();
                int i=1;
               while(rst.next())
               {
                   comp[0]=String.valueOf(i);
                   comp[i]=rst.getString(1);
                   ++i;
               }
                 return comp;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return null;
    }
    public boolean addCar(String mod,String comp,String num,String yr,String use,String seat,String eng,String type,String var,String rent)
    {
        PreparedStatement psmt;
            try{
                
               
               String str="insert into servicecars(model,company,carnumber,makeyear,useas,seat_cap,engine_cap,type,varient,rent) values(?,?,?,?,?,?,?,?,?,?)";
         psmt=con.prepareStatement(str);
          psmt.setString(1,mod);
               psmt.setString(2,comp);
               psmt.setString(3,num);
               psmt.setString(4,yr);
               psmt.setString(5,use);
               psmt.setString(6,seat);
               psmt.setString(7,eng);
               psmt.setString(8,type);
               psmt.setString(9,var);
               psmt.setString(10,rent);
                int res=psmt.executeUpdate();
               if(res<=0)
               {
                   return false;
               }    
              
                 return true;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
    
    public boolean addDriver(String name,String gender,String ad,String phn,String exp,String dob,String doj,String path,String carnum)
    {
        
            try{
                PreparedStatement psmt;
               String str="insert into driverdetails(name,gender,address,phoneno,experience,dob,dateofjoin,path,carnumber) values(?,?,?,?,?,?,?,?,?)";
         psmt=con.prepareStatement(str);
          psmt.setString(1,name);
               psmt.setString(2,gender);
               psmt.setString(3,ad);
               psmt.setString(4,phn);
               psmt.setString(5,exp);
               psmt.setString(6,dob);
               psmt.setString(7,doj);
              psmt.setString(8,path);
               psmt.setString(9,carnum);
               
               int res=psmt.executeUpdate();
               
                 if(res<=0)
                 {
                     return false;
                 }
               String str1="update servicecars set driverid=(select driverid from driverdetails where phoneno=?),driver=? where carnumber=?";
                 psmt=con.prepareStatement(str1);
          psmt.setString(1,phn);
               psmt.setString(2,"Yes");
               psmt.setString(3,carnum);
                 int res1=psmt.executeUpdate();
               
               return res1 > 0;
               
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
              e.printStackTrace();
          }
          return false;
    }
    
    public String[] getDriverDetails(String id)
    {
         PreparedStatement psmt;
    ResultSet rst;
        try
    {
    String str="select name,gender,address,phoneno,experience,dob,path from driverdetails where driverid=?";
   
    String[] details=new String[11];
         
               psmt=con.prepareStatement(str);
               psmt.setString(1,id);
               rst=psmt.executeQuery();
               if(rst.next())
               {     
                  details[0]= rst.getString(1);
                   details[1]= rst.getString(2);
                    details[2]=rst.getString(3);
                    details[3]=rst.getString(4);
                   details[4]= rst.getString(5);
                   details[5]= rst.getString(6);
                   details[6] =rst.getString(7);
                    return details;
               } 
      }
      catch(Exception e)
      {
         
   JOptionPane.showMessageDialog(null,"Error in connection");
      }   
        return null;
}
     public boolean updateDriverDetails(String name,String phn,String ad,String dob,String gender,String id,String exp,String path)
    {
          PreparedStatement psmt;
          try{
               
               String str="update driverdetails set name=?,gender=?,address=?,phoneno=?,experience=?,dob=?,path=? where driverid=?";
         psmt=con.prepareStatement(str);
             psmt.setString(1,name);
             psmt.setString(2,gender);
               psmt.setString(3,ad);
               psmt.setString(4,phn);
               psmt.setString(5,exp);
               psmt.setString(6,dob);
               psmt.setString(7,path);
               psmt.setString(8,id);
               int res1=psmt.executeUpdate();
               return res1 > 0;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
      public boolean deleteDriver(String id)
    {
         PreparedStatement psmt;
          try{
               
               String str="delete from driverdetails where driverid=?";
         psmt=con.prepareStatement(str);
            
               psmt.setString(1,id);
               psmt.executeUpdate();
               System.out.println("a");
               String str1="update servicecars set driver='no', driverid=' ' where driverid=?";
               System.out.println("b");
               psmt=con.prepareStatement(str1);
            
               psmt.setString(1,id);
               int res1=psmt.executeUpdate();
               return res1 > 0;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
        public boolean addCustomer(String name,String ad,String gender,String comp,String did,String carnum,int days,int bill,String phone,String bdate) 
    {
        PreparedStatement psmt;
        try
        {
            String insert1="insert into customerdetails(name,gender,address,phoneno,company,driverid,carnumber,rentingdays,bill,bdate) values(?,?,?,?,?,?,?,?,?,?)" ;
            psmt=con.prepareStatement(insert1);
            psmt.setString(1,name);
                        psmt.setString(2,gender);
            psmt.setString(3,ad);

            psmt.setString(4,phone);
            psmt.setString(5,comp);
            psmt.setString(6,did);
            psmt.setString(7,carnum);
            psmt.setInt(8,days);
            psmt.setInt(9,bill);
            psmt.setString(10,bdate);
          
            psmt.executeUpdate();
            
            String insert2="update servicecars set status='"+"Rented' where carnumber=?";      
           
            psmt=con.prepareStatement(insert2);
            
            psmt.setString(1,carnum);
           int res=psmt.executeUpdate();
           
           
           return res>0;
       
        }catch(SQLException e)
        {
            System.out.println("Exception in inserting data "+e.getMessage());
        }
       
        return false;  
    }
         public String[] getCustomerDetails(String id)
    {
         PreparedStatement psmt;
    ResultSet rst;
        try
    {
    String str="select cd.name,cd.gender,cd.address,cd.phoneno,cd.customerid,cd.carnumber,cd.company,cd.bdate,sc.model from customerdetails cd,servicecars sc where sc.carnumber=cd.carnumber AND cd.customerid=? AND rdate is null";
   
    String[] details=new String[11];
         
               psmt=con.prepareStatement(str);
               psmt.setString(1,id);
               rst=psmt.executeQuery();
               if(rst.next())
               {     
                  details[0]= rst.getString(1);
                   details[1]= rst.getString(2);
                    details[2]=rst.getString(3);
                    details[3]=rst.getString(4);
                    details[4]=rst.getString(5);
                    details[5]=rst.getString(6);
                    details[6]=rst.getString(7);
                    details[7]=rst.getString(8);
                    details[8]=rst.getString(9);
                   
                    return details;
               } 
      }
      catch(Exception e)
      {
         
   JOptionPane.showMessageDialog(null,"Error in connection");
   e.printStackTrace();
      }   
        return null;
}
          public boolean updateCustomerDetails(String name,String phn,String ad,String gender,String id)
    {
          PreparedStatement psmt;
          try{
               
               String str="update customerdetails set name=?,gender=?,address=?,phoneno=? where customerid=?";
         psmt=con.prepareStatement(str);
             psmt.setString(1,name);
             psmt.setString(2,gender);
               psmt.setString(3,ad);
               psmt.setString(4,phn);               
               psmt.setString(5,id);
               int res1=psmt.executeUpdate();
               return res1 > 0;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
          public boolean deleteCustomer(String id)
    {
         PreparedStatement psmt;
          try{
               
               String str="delete from customerdetails where customerid=?";
         psmt=con.prepareStatement(str);
            
               psmt.setString(1,id);
               int res1=psmt.executeUpdate();
               return res1 > 0;
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,"Error in connection");
          }
          return false;
    }
       public boolean returnCar(String rdate,String id)
       {
         PreparedStatement psmt;
          try{
         
         String str="update customerdetails cd,servicecars sc set cd.rdate=?,sc.status='"+"Not Rented' where cd.customerid=?";
 
         psmt=con.prepareStatement(str);
         psmt.setString(1,rdate);
         psmt.setString(2,id);
        int res1 =psmt.executeUpdate();
             return res1 > 0;

     }catch(SQLException e)
      {
            JOptionPane.showMessageDialog(null,"Error in connection");
            return false;
      }  
     
       }
     public String getPassword(int id)
     {
          PreparedStatement psmt;
          ResultSet rst;
          try{
         
         String str="select password from emplist where id=?";
 
         psmt=con.prepareStatement(str);
         psmt.setInt(1,id);
        rst =psmt.executeQuery();
        if(rst.next())
        {
            return rst.getString(1);
        }

     }catch(SQLException e)
      {
            JOptionPane.showMessageDialog(null,"Error in connection");
      }  
                      return null;
     }
     public boolean changePsd(String psd,int id)
     {
         PreparedStatement psmt;
        try{
         
         String str="update emplist set password=? where id=?";
 
         psmt=con.prepareStatement(str);
         psmt.setString(1,psd);
         psmt.setInt(2,id);
      int res=psmt.executeUpdate();
      return res>0;

     }catch(SQLException e)
      {
            JOptionPane.showMessageDialog(null,"Error in connection");
            return false;
      }  
     }
     
}

