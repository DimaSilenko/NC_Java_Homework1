package com.homework;

import com.homework.task1.*;
import com.homework.task2.*;

public class MainClass {
    public static void main(String[] args) {
        Ball ball = new Ball(1, 5, 1, 7, -60);
        Container container = new Container(0, 0, 15, 15);

        System.out.println(ball);
        System.out.println(container);
        if (container.collides(ball))
            System.out.println("Ball in container");
        else
            System.out.println("Ball not in container");
        System.out.println();

        System.out.println("The ball has change it position");
        ball.move();
        System.out.println(ball);
        System.out.println(container);
        if (container.collides(ball))
            System.out.println("Ball in container");
        else
            System.out.println("Ball not in container");
        System.out.println();

        System.out.println("The ball has change it position");
        ball.move();
        System.out.println(ball);
        System.out.println(container);
        if (container.collides(ball))
            System.out.println("Ball in container");
        else
            System.out.println("Ball not in container");
        System.out.println();

        System.out.println("The ball has change direction");
        ball.reflectHorizontal();
        ball.reflectVertical();
        System.out.println("The ball has change it position");
        ball.move();
        System.out.println(ball);
        System.out.println(container);
        if (container.collides(ball))
            System.out.println("Ball in container");
        else
            System.out.println("Ball not in container");
    }
}