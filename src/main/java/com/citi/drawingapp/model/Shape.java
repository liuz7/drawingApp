package com.citi.drawingapp.model;

import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.utils.OutputWriter;

abstract class Shape {

    protected final static char SHAPE_SEP = 'X';
    protected final static char WIDTH_SEP = '-';
    protected final static char HEIGHT_SEP = '|';

    protected void outputToConsole(char[][] data) {
        OutputWriter.printToConsole(data);
    }

    protected String outputToString(char[][] data) {
        return OutputWriter.printToString(data);
    }

    protected void drawLine(Canvas canvas, char horizontalSep, char verticalSep, ShapeArgument... plist) {
        int x1 = plist[0].getCoordinateX();
        int y1 = plist[0].getCoordinateY();
        int x2 = plist[1].getCoordinateX();
        int y2 = plist[1].getCoordinateY();
        char[][] data = canvas.getData();
        if (y1 == y2 && x1 != x2) { //draw the horizontal line
            for (int i = x1; i <= x2; i++) {
                data[y1][i] = horizontalSep;
            }
        } else if (x1 == x2 && y1 != y2) { //draw the vertical line
            for (int j = y1; j <= y2; j++) {
                data[j][x1] = verticalSep;
            }
        } else {
            throw new NotSupportedException("This type of line drawing is not supported");
        }
    }

}
