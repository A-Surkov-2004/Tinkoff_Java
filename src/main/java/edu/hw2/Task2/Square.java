package edu.hw2.Task2;

import edu.hw2.Task2.Task2.Rectangle;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public Square setSide(int side) {
        return new Square(side);
    }
}
