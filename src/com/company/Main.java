package com.company;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in).useDelimiter("\n");
        SystemBrain brainObj = new SystemBrain();
        Student stuObj = new Student();
        //check csv file
        try {
            if( brainObj.getDatabaseFile().createNewFile() == true){
                System.out.println("a new file is created" + brainObj.getDatabaseFile().getAbsolutePath());
            } else{
                System.out.println("this file is already exist" + brainObj.getDatabaseFile().getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----------------------------------------------------------------------------------------------------------------
        while(true){
            //UI
            System.out.println("Welcome to the collage System! ");
            System.out.println("===============================");
            System.out.println("Chose the Service you want to get by specify a number :");
            System.out.println("1 to add a new student.");
            System.out.println("2 to read the data for the student.");
            System.out.println("3 to update the data of the student.");
            System.out.println("4 to delete the data of the student.");
            System.out.println("finally, 0 to exit the system.");
            System.out.println("===============================");
            System.out.println("Your choice is : ");
            int reminder = user.nextInt();
            //-----------------------------------------------------------------------------------------------------------------
            if(reminder == 0){
                System.out.println("System is closing........ ");
                break;
            } else if(reminder == 1){
                brainObj.createStudent();
            } else if(reminder == 2){
                brainObj.readData();
            } else if(reminder == 3){
                brainObj.updateData(brainObj.arrayList, user);
            } else if(reminder == 4){
                brainObj.deleteStudent();
            }
        }
    }
}
