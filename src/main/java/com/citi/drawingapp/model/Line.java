package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.exception.NoCanvasException;
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
     * @param p1 ShapeArgument object contains Integer value for line starting point
     * @param p2 ShapeArgument object contains Integer value for line ending point
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(ShapeArgument p1, ShapeArgument p2) {
        int x1 = p1.getCoordinateX();
        int y1 = p1.getCoordinateY();
        int x2 = p2.getCoordinateX();
        int y2 = p2.getCoordinateY();
        if (this.canvas == null || this.canvas.getData() == null) {
            throw new NoCanvasException("Canvas is not found, please draw Canvas firstly");
        }
        char[][] data = this.canvas.getData();
        int m = data.length;
        int n = data[0].length;
        if (y1 <= 0 || y1 >= m - 1 || x1 <= 0 || x1 > n - 2 ||
                y2 <= 0 || y2 >= m - 1 || x2 <= 0 || x2 > n - 2) {
            throw new OutOfCanvasException("Line should be in canvas");
        }
        if (y1 == y2) { //draw the horizontal line
            for (int i = x1; i <= x2; i++) {
                data[y1][i] = SHAPE_SEP;
            }
        } else if (x1 == x2) { //draw the vertical line
            for (int j = y1; j <= y2; j++) {
                data[j][x1] = SHAPE_SEP;
            }
        } else {
            throw new NotSupportedException("This type of line drawing is not supported");
        }
        OutputWriter.printToConsole(data);
    }
}
