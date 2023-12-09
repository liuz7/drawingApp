package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.exception.NoCanvasException;
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
     * @param plist ShapeArgument object list contains Integer value for
     *              Rectangle upper left and bottom right points.
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(ShapeArgument... plist) {
        if (plist == null || plist.length != 2) {
            throw new IllegalArgumentException("Argument size is incorrect");
        }
        int x1 = plist[0].getCoordinateX();
        int y1 = plist[0].getCoordinateY();
        int x2 = plist[1].getCoordinateX();
        int y2 = plist[1].getCoordinateY();
        if (this.canvas == null || this.canvas.getData() == null) {
            throw new NoCanvasException("Canvas is not found, please draw Canvas firstly");
        }
        char[][] data = this.canvas.getData();
        int m = data.length;
        int n = data[0].length;
        if (y1 <= 0 || y1 >= m - 1 || x1 <= 0 || x1 > n - 2 ||
                y2 <= 0 || y2 >= m - 1 || x2 <= 0 || x2 > n - 2) {
            throw new OutOfCanvasException("Rectangle should be in canvas");
        }
        //draw the top and bottom line
        for (int i = x1; i <= x2; i++) {
            data[y1][i] = SHAPE_SEP;
            data[y2][i] = SHAPE_SEP;
        }
        //draw the left and right line
        for (int j = y1; j <= y2; j++) {
            data[j][x1] = SHAPE_SEP;
            data[j][x2] = SHAPE_SEP;
        }
        OutputWriter.printToConsole(data);
    }
}
