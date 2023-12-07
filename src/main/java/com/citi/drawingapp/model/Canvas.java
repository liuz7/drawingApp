package com.citi.drawingapp.model;

import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.exception.OutOfCanvasException;
import com.citi.drawingapp.utils.OutputWriter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Canvas extends Shape {

    private int width;
    private int height;

    private char[][] data;

    private final static char WIDTH_SEP = '-';
    private final static char HEIGHT_SEP = '|';

    private final static char SHAPE_SEP = 'X';

    public Canvas() {
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new char[height][width];
    }

    @Override
    public void drawCanvas(int width, int height) {
        this.width = width + 2;
        this.height = height + 2;
        this.data = new char[this.height][this.width];
        //draw the top and bottom line
        for (int i = 0; i < this.width; i++) {
            data[0][i] = WIDTH_SEP;
            data[this.height - 1][i] = WIDTH_SEP;
        }
        //draw the left and right line
        for (int j = 1; j < this.height - 1; j++) {
            data[j][0] = HEIGHT_SEP;
            data[j][this.width - 1] = HEIGHT_SEP;
        }
        OutputWriter.printToConsole(this.data);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        if (y1 == y2) { //draw the horizontal line
            for (int i = x1; i <= x2; i++) {
                try {
                    this.data[y1][i] = SHAPE_SEP;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new OutOfCanvasException();
                }
            }
        } else if (x1 == x2) { //draw the vertical line
            for (int j = y1; j <= y2; j++) {
                try {
                    this.data[j][x1] = SHAPE_SEP;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new OutOfCanvasException();
                }
            }
        } else {
            throw new NotSupportedException("This type of line drawing is not supported");
        }
        OutputWriter.printToConsole(this.data);
    }

    @Override
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        //draw the top and buttom line
        for (int i = x1; i <= x2; i++) {
            try {
                this.data[y1][i] = SHAPE_SEP;
                this.data[y2][i] = SHAPE_SEP;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new OutOfCanvasException();
            }
        }
        //draw the left and right line
        for (int j = y1; j <= y2; j++) {
            try {
                this.data[j][x1] = SHAPE_SEP;
                this.data[j][x2] = SHAPE_SEP;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new OutOfCanvasException();
            }
        }
        OutputWriter.printToConsole(this.data);
    }

    @Override
    public String toString() {
        return OutputWriter.printToString(this.data);
    }
}
