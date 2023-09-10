package com.mycompany.biz.common;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class JDBCUtill {
   
   public static Connection getConnection() {
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/studydb?allowPublicKeyRetrieval=true","root","mysql"
               );
               
      } catch (Exception e) {}
      return null;
   }
   
   public static void close(PreparedStatement stmt, Connection conn) {
      if(stmt != null) {
         try {
            if(!stmt.isClosed()) stmt.close();
         } catch (Exception e) {
         } finally {
            
         }
      }
      if(conn != null) {
         try {
            if(!conn.isClosed()) conn.close();
         } catch (Exception e) {
            // TODO: handle exception
         } finally {
            conn = null;
         }
      }
   }
   
   public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
      if(rs != null) {
         try {
            if(!rs.isClosed()) rs.close();
         } catch (Exception e) {
            
         }finally {
            rs = null;
         }
      }
      
      if(stmt != null) {
         try {
            if(!stmt.isClosed()) stmt.close();
         } catch (Exception e) {
         } finally {
            
         }
      }
      if(conn != null) {
         try {
            if(!conn.isClosed()) conn.close();
         } catch (Exception e) {
            // TODO: handle exception
         } finally {
            conn = null;
         }
      }
      
   }
   
}