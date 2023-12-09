package com.citi.drawingapp.model;

import com.citi.drawingapp.utils.OutputWriter;

abstract class Shape {

    protected final static char SHAPE_SEP = 'X';
    protected final static char WIDTH_SEP = '-';
    protected final static char HEIGHT_SEP = '|';

    protected void outputToConsole(char[][] data) {
        OutputWriter.printToConsole(data);
    }
}
