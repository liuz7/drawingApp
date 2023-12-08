package com.citi.drawingapp.model;

import com.citi.drawingapp.api.CanvasInterface;
import com.citi.drawingapp.utils.OutputWriter;
import lombok.Data;


@Data
public class Canvas implements CanvasInterface {

    private int width;
    private int height;

    private char[][] data;

    private final static char WIDTH_SEP = '-';
    private final static char HEIGHT_SEP = '|';


    public Canvas() {
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new char[height][width];
    }

    /**
     * Draw the canvas to console
     *
     * @param width  Integer value for canvas width
     * @param height Integer value for canvas height
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and Height should be greater than zero");
        }
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
    public String toString() {
        return OutputWriter.printToString(this.data);
    }

}
