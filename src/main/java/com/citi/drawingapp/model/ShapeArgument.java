package com.citi.drawingapp.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ShapeArgument {

    private int coordinateX; //coordinateX for Line, Rectangle shape
    private int coordinateY; //coordinateY for Line, Rectangle shape

    private int width; //width for Canvas
    private int height; //height for Canvas

    private int radius; // for circle shape

    private Map<String, Integer> userDefinedArguments;

}
