package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.utils.OutputWriter;
import com.citi.drawingapp.validation.CheckArgumentSize;
import com.citi.drawingapp.validation.CheckCanvas;
import lombok.Data;

import static com.citi.drawingapp.enums.ShapeType.C;


@Data
public class Canvas extends Shape implements ShapeInterface {

    private int width;
    private int height;
    private char[][] data;

    public Canvas() {
    }

    /**
     * Draw the canvas to console
     *
     * @param plist ShapeArgument object list which contains Integer value
     *              for canvas width and Integer value for canvas height.
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(ShapeArgument... plist) {
        new CheckArgumentSize().linkWith(new CheckCanvas()).validate(C, null, plist);
        this.width = plist[0].getWidth() + 2;
        this.height = plist[0].getHeight() + 2;
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
        super.outputToConsole(this.data);
    }

    @Override
    public String toString() {
        return OutputWriter.printToString(this.data);
    }

}
