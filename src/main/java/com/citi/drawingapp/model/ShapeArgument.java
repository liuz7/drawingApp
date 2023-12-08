package com.citi.drawingapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShapeArgument {

    private int coordinateX; //coordinateX for Line, Rectangle shape, width for Canvas
    private int coordinateY; //coordinateY for Line, Rectangle shape, height for Canvas

    private int radius; // for circle shape
}
