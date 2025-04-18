package com.learn.dsa.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

class PacificAtlanticWaterFlowTest {

    @Test
    void testPacificAtlantic() {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 4),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 2),
                Arrays.asList(3, 0),
                Arrays.asList(3, 1),
                Arrays.asList(4, 0)
        );

        List<List<Integer>> result = pacificAtlanticWaterFlow.pacificAtlantic(heights);

        assertEquals(expected, result);
    }
}