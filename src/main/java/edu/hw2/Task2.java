package edu.hw2;

public class Task2 {

    public class Rectangle {
        private int width;
        private int height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        final Rectangle setWidth(int width) {
            return new Rectangle(width, this.height);
        }

        final Rectangle setHeight(int height) {
            return new Rectangle(this.width, height);
        }

        double area() {
            return width * height;
        }
    }

    public class Square extends Rectangle {

        Square(int side) {
            super(side, side);
        }

        Square setSide(int side) {
            return new Square(side);
        }
    }
}
