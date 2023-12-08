package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.exception.OutOfCanvasException;
import com.citi.drawingapp.utils.OutputWriter;
import lombok.Data;

@Data
public class Rectangle implements ShapeInterface {

    private Canvas canvas;

    private final static char SHAPE_SEP = 'X';

    /**
     * Draw the Rectangle in canvas to console
     *
     * @param x1,y1 Integer value for Rectangle upper left point
     * @param x2,y2 Integer value for Rectangle bottom right point
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        char[][] data = this.canvas.getData();
        //draw the top and bottom line
        for (int i = x1; i <= x2; i++) {
            try {
                data[y1][i] = SHAPE_SEP;
                data[y2][i] = SHAPE_SEP;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new OutOfCanvasException();
            }
        }
        //draw the left and right line
        for (int j = y1; j <= y2; j++) {
            try {
                data[j][x1] = SHAPE_SEP;
                data[j][x2] = SHAPE_SEP;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new OutOfCanvasException();
            }
        }
        OutputWriter.printToConsole(data);
    }
}
