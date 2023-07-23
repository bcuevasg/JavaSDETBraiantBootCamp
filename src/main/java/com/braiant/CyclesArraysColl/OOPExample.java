package com.braiant.CyclesArraysColl;

import javax.naming.Name;

public class OOPExample {
    public static void main(String[] args) {

        Employee.setEmployeeName("Luis");
        Employee.setSalary(100.3f);

        System.out.println(Employee.getEmployeeName() +" " + Employee.getSalary());

        /* Usado si la clase no fuera STATIC

        Carr car = new Carr();
        */
        Car.setTireCount(3);
        System.out.println(Car.getTireCount());



    }
    class Employee {
        //static int employeeNum;
        static String employeeName;
        static float salary;


        /*CREADO CON EL GENERATE THE INTELLIJ "GENERATOR"
        public static String getEmployeeName() {
            return employeeName;
        }

        public static float getSalary() {
            return salary;
        }

        public static void setEmployeeName(String employeeName) {
            Employee.employeeName = employeeName;
        }

        public static void setSalary(float salary) {
            Employee.salary = salary;
        }
        */


        //Mutator
        //Method
        static void setEmployeeName(String name) {
            employeeName = name;
        }

        static void setSalary(float salaryEmployee) {
            salary = salaryEmployee;
        }

        // Accessor
        static float getSalary() {
            return salary;
        }

        static String getEmployeeName() {
            return employeeName;
        }
    }
    class Car{
        static int tireCount;

        static void setTireCount(int tireCounts) {
            tireCount = tireCounts;
        }
        static int getTireCount() {
            return tireCount;
        }
    }




}
