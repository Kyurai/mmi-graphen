package input;

import entity.Edge;
import entity.Graph;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class with static methods to import and
 * transform graph.txt-files into {@link Graph}
 */
public class GraphImporter {

    /**
     * Creates a {@link Graph} from given file
     * <p>
     * File format:
     * <p>
     * Line 0:      Number of vertices (int)
     * Line 1-n:    Edges with origin (int) and destination (int)
     *
     * @param pathToFile path to graph file
     */
    public static Graph loadGraphFromFile(String pathToFile) throws IOException, IllegalArgumentException {

        try (Stream<String> stream = Files.lines(Paths.get(pathToFile))) {
            List<String> lines = stream.collect(Collectors.toList());

            //read first line to get number of vertices
            String s = lines.remove(0);
            List<Integer> values = extractValues(s);
            if (values.size() != 1) {
                throw new IllegalArgumentException("The first line in file should only contain one value !");
            }
            int numberVertices = values.get(0);

            //Create all vertices
            Graph graph = new Graph();
            for (int i = 0; i < numberVertices; i++) {
                graph.addVertex(i);
            }

            //read other lines to add edges
            while (lines.size() > 0) {
                List<Integer> edgeValues = extractValues(lines.remove(0));
                if (edgeValues.size() != 2) {
                    throw new IllegalArgumentException("Edges can only consist out of two values");
                }

                int originId = edgeValues.get(0);
                int destinationId = edgeValues.get(1);
                Edge edge = new Edge(destinationId);
                graph.getVertex(originId).addEdge(edge);
            }

            return graph;
        }
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
