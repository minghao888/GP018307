package com.gopaoedu.factoryPattern.abstractFactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        CourseFactory java = new JavaCourseFactory();
        java.createIVdieo().record();
        java.creatINote().edit();
        java.creatINote().look();


        CourseFactory python = new PythonCourseFactory();
        python.createIVdieo().record();
        python.creatINote().edit();
        python.creatINote().look();

    }
}
