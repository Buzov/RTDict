package com.barracuda.rtdict.dao;



public class Factory {
      
//      private static StudentDAO studentDAO = null;
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

//      public StudentDAO getStudentDAO(){
//            if (studentDAO == null){
//              studentDAO = new StudentDAOImpl();
//            }
//            return studentDAO;
//      }   
}