package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.exception.OutOfCanvasException;
import com.citi.drawingapp.utils.OutputWriter;
import lombok.Data;

@Data
public class Line implements ShapeInterface {

    private Canvas canvas;

    private final static char SHAPE_SEP = 'X';

    /**
     * Draw the Line in canvas to console
     *
     * @param x1,y1  Integer value for line starting point
     * @param x2,y2  Integer value for line ending point
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        char[][] data = this.canvas.getData();
        if (y1 == y2) { //draw the horizontal line
            for (int i = x1; i <= x2; i++) {
                try {
                    data[y1][i] = SHAPE_SEP;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new OutOfCanvasException();
                }
            }
        } else if (x1 == x2) { //draw the vertical line
            for (int j = y1; j <= y2; j++) {
                try {
                    data[j][x1] = SHAPE_SEP;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new OutOfCanvasException();
                }
            }
        } else {
            throw new NotSupportedException("This type of line drawing is not supported");
        }
        OutputWriter.printToConsole(data);
    }
}
