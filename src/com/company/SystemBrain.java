package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class SystemBrain {
    //objects
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    Student assignObj = new Student();
    ArrayList<String> arrayList = new ArrayList<String>();
    //----------------------------------------------------------------------------------
    //file creation object
    File databaseFile = new File("database.csv");
    public File getDatabaseFile() {
        return databaseFile;
    }
    //----------------------------------------------------------------------------------
    //Create
    public void createStudent(){
        //name
        System.out.println("Enter Student name : ");
        String name = input.next();
        //------------------------------------------------------------------
        // id
        System.out.println("Enter Student ID : ");
        String id = input.next();
        id +=  "$" + new Random().nextInt(100);
        //------------------------------------------------------------------
        //department
        System.out.println("Enter Student department : ");
        String department = input.next();
        //------------------------------------------------------------------
        //level
        System.out.println("Enter Student Level : ");
        int level = input.nextInt();
        assignObj.Student(name,id,department,level);
        //File write
        FileWriter write;
        {
            try {
                write = new FileWriter("database.csv",true);
                write.append(assignObj.getStudentData());
                write.append("\n");
                write.close();
                System.out.println("Student data had been added successfully...");
                System.out.println("////////////////////////////////////////////////////////////////////////");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //----------------------------------------------------------------------------------
    //Update
    public void updateData(ArrayList<String>arrayList,Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("database.csv"));
            System.out.println("please enter any key to update the record");
            String searchKey=input.next();
            String line;
            while ((line = reader.readLine())!= null){
                if(line.contains(searchKey)){
                    System.out.println("enter the text you want to change");
                    String oldValue = input.next();
                    System.out.println("enter the new text you want to change");
                    String newValue = input.next();
                    arrayList.add(line.replace(oldValue,newValue));
                }else {
                    arrayList.add(line);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            FileWriter writer = new FileWriter("database.csv");
            for(int i = 0 ; i < arrayList.size(); i++){
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
        arrayList.clear();
    }
    //----------------------------------------------------------------------------------
    //Delete
    public void deleteStudent(){
        System.out.println("enter any id or word to delete a record");
        String searchKey=input.next();
        String line;
        try {

            BufferedReader reader=new BufferedReader(new FileReader("database.csv"));
            while ((line=reader.readLine())!=null){
                if(line.contains(searchKey)){
                    System.out.println(line);
                    continue;
                }else {
                    arrayList.add(line);
                }
            }

        }catch (Exception e){

        }
        try {
            FileWriter writer=new FileWriter("database.csv");
            for (int i=0;i<arrayList.size();i++){
                writer.append( arrayList.get(i));
                writer.append("\n");
            }
            writer.close();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("The record had been deleted successfully!");
        }
        arrayList.clear();
    }
    //----------------------------------------------------------------------------------
    //Read
    public void readData(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("database.csv"));
            System.out.println("Enter the key of student record to read the data!!");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if(line.contains(searchKey)){
                    System.out.println(line);

                }

            }


        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("============================================================================");
    }
}
