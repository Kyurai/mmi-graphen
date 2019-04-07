import entity.Graph;
import input.GraphImporter;
import startup.AsciiGenerator;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //Drawing the ASCII
        AsciiGenerator asciiGenerator = new AsciiGenerator();
        asciiGenerator.drawString("MMI-Praktikum", "*", asciiGenerator.new Settings(Font.getFont("Arial Bold"), 100, 20), true);


        //Importing graph and measuring time
        String path = "C:\\Users\\Dustin\\Downloads\\FH Aachen\\Mathe\\Graph_ganzgross.txt";
        long startTime = System.currentTimeMillis();
        Graph graph = null;
        try {
            System.out.println("Starting import of graph...");
            graph = GraphImporter.loadGraphFromFile(path);
        } catch (IOException e) {
            System.out.println("Error while importing graph from: " + path);
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Importing graph took: " + estimatedTime + " ms");

        //Sample Outputs
        System.out.println(graph.countVertices());
        System.out.println(graph.getVertices().get(0).countEdges());
    }
}
