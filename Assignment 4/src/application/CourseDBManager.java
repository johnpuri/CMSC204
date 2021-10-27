package application;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class CourseDBManager implements CourseDBManagerInterface {

    CourseDBStructure structure;

    public CourseDBManager(){
        structure = new CourseDBStructure(10);
    }

    /**
     * @param id course ID
     * @param crn course unique number
     * @param credits number of credits offered
     * @param roomNum the room the course will be taught in
     * @param instructor the instructor teaching the course
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        structure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }

    /**
     * @param crn the number to search for
     * @return the course object corresponding to that number
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return structure.get(crn);
        } catch (IOException e){
            return null;
        }
    }

    /**
     * @return an array list containing all elements sorted by the hashing algorithm
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> output = new ArrayList<>();
        for(LinkedList<CourseDBElement> list : structure.hashTable){
            for(CourseDBElement element : list){
                output.add(element.toString());
            }
        }
        return output;
    }

    /**
     * @param input File object to index
     * @throws FileNotFoundException if the given parameter doesn't exist
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        BufferedReader read = new BufferedReader(new FileReader(input));
        read.lines().forEach((String s) -> {
            String[] values = s.split(" ", 5);
            add(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3], values[4]);
        });
        
    }

}