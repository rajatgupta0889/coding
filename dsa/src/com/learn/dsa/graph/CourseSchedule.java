package com.learn.dsa.graph;

import java.util.*;

public class CourseSchedule {

    /**
     * https://leetcode.com/problems/course-schedule/
     * 207. Course Schedule
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        Set<Integer> visiting = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            courseMap.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int preReqCourse = prerequisite[1];
            courseMap.get(course).add(preReqCourse);
        }
        for(int i = 0; i< numCourses; i++){
            if(!dfs(i, courseMap,visiting)){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int course, Map<Integer, List<Integer>> courseMap, Set<Integer> visiting) {
        if(visiting.contains(course)){
            return false;
        }
        if(courseMap.get(course).isEmpty()){
            return true;
        }

        visiting.add(course);
        for(int pre: courseMap.get(course)){
            if(!dfs(pre, courseMap,visiting)){
                return false;
            }
        }
        visiting.remove(course);
        courseMap.put(course, new ArrayList<>());

        return true;
    }

    public boolean canFinishTopSort(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            inDegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int finish = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int neighbour: adj.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }

        return finish == numCourses;
    }




    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = {
                {1,0},
                {0,1}
        };
        System.out.println(courseSchedule.canFinishTopSort(2, prerequisites)); // Output: false

        int[][] prerequisites2 = {
                {1,0}
        };
        System.out.println(courseSchedule.canFinishTopSort(2, prerequisites2)); // Output: true
    }
}
