package com.braiant.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;


public class WindowManageExample extends BaseTestClass{

    @Test
    void manageWindow(){
        driver.navigate().to(demoSite);

        getSizeAndPosition();
        setSizeAndPosition();
        getSizeAndPosition();

        wait(3);

        driver.manage().window().maximize();
        wait(3);

        driver.manage().window().minimize();
        wait(3);

        driver.manage().window().fullscreen();
    }



    private void getSizeAndPosition(){
        Dimension size = driver.manage().window().getSize();
        System.out.println(String.format("La altura de la ventana es de: %d pixeles", size.height));
        System.out.println(String.format("El ancho de la ventana es de: %d pixeles", size.width));

        Point position = driver.manage().window().getPosition();
        System.out.println(String.format("La posicion X de mi venta es: %d pixeles",position.x));
        System.out.println(String.format("La posicion Y de mi venta es: %d pixeles",position.y));
    }

    private void setSizeAndPosition(){
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().window().setPosition(new Point(0,0));
    }

}
