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
        //validation chain
        new CheckArgumentSize().linkWith(new CheckCanvas()).validate(C, null, plist);
        int x1 = 0;
        int y1 = 0;
        int x2 = plist[0].getWidth() + 1;
        int y2 = plist[0].getHeight() + 1;
        this.data = new char[plist[0].getHeight() + 2][plist[0].getWidth() + 2];
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(x1).coordinateY(y1).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(x2).coordinateY(y2).build();
        plist = new ShapeArgument[]{p1, p2};
        //draw the left line
        plist[1].setCoordinateX(x1);
        super.drawLine(this, WIDTH_SEP, HEIGHT_SEP, plist);
        plist[1].setCoordinateX(x2);
        //draw the right line
        plist[0].setCoordinateX(x2);
        super.drawLine(this, WIDTH_SEP, HEIGHT_SEP, plist);
        plist[0].setCoordinateX(x1);
        //draw the top line
        plist[1].setCoordinateY(y1);
        super.drawLine(this, WIDTH_SEP, HEIGHT_SEP, plist);
        plist[1].setCoordinateY(y2);
        //draw the bottom line
        plist[0].setCoordinateY(y2);
        super.drawLine(this, WIDTH_SEP, HEIGHT_SEP, plist);
        plist[0].setCoordinateY(y1);
        super.outputToConsole(this.data);
    }

    @Override
    public String toString() {
        return OutputWriter.printToString(this.data);
    }

}
