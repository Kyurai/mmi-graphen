package input;

import entity.Edge;
import entity.Graph;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class with static methods to import and
 * transform graph.txt-files into {@link Graph}
 */
public class GraphImporter {

    /**
     * Import graph from graph.txt
     *
     * @param pathToFile path to txt.file
     * @param directed   if directed is chosen, the edge is just placed on the origin vertex
     *                   if not directed is chosen, the edge is placed on both the origin and the destination vertices
     * @return Graph
     */
    public static Graph readEdgeListFromFile(final String pathToFile, boolean directed) {

        Graph graph = new Graph();
        try {
            final FileReader fileReader = new FileReader(pathToFile);
            final BufferedReader reader = new BufferedReader(fileReader);

            String firstLine = reader.readLine();
            int numberVertices = Integer.parseInt(firstLine);
            for (int i = 0; i < numberVertices; i++) {
                graph.addVertex(i);
            }

            final String delimiter = "\t";
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                final String[] points = currentLine.split(delimiter);
                final int p1 = Integer.parseInt(points[0]);
                final int p2 = Integer.parseInt(points[1]);

                if (!directed) {
                    Edge e = new Edge(graph.getVertex(p1), graph.getVertex(p2));
                    graph.getVertex(p1).addEdge(e);
                    graph.getVertex(p2).addEdge(e);
                } else {
                    graph.getVertex(p1).addEdge(new Edge(graph.getVertex(p1), graph.getVertex(p2)));
                    graph.getVertex(p2).addEdge(new Edge(graph.getVertex(p2), graph.getVertex(p1)));
                }
            }

            reader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }


    /**
     * Splits the inputted line into single values
     * and parses them as {@link Integer}
     *
     * @param line single line of text file
     * @return List of {@link Integer} values
     */
    static List<Integer> extractValues(String line) {

        String[] split = StringUtils.split(line);

        List<Integer> values = new ArrayList<>();
        for (String s : split) {
            values.add(Integer.parseInt(s));
        }

        return values;
    }
}
