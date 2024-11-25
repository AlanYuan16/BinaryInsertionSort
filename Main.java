import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    public static ArrayList<Student> BinaryInsertionSort(ArrayList<Student> array) {
        //In insertion sort we start at one because we assume the first one is already sorted
        for (int i = 1; i < array.size(); i++) {
            Student currentStudent = array.get(i);
            int v = currentStudent.getID();
            int j = i - 1;
    
            //Find the correct position using Binary Search
            int location = BinarySort(new ArrayList<>(array.subList(0, i)), v);
    
            //Shift elements to the right to create space for the current student
            while (j >= location) {
                array.set(j + 1, array.get(j));
                j--; //Move to the previous element
            }
    
            //Insert the current student into the correct position
            array.set(j + 1, currentStudent);
        }
    
        return array; //Return the sorted list
    }
    
    
    public static int BinarySort(ArrayList<Student> array, int target) {
        int left = 0;
        int right = array.size()-1;

        while(left<=right){
        int middle = left + (right - left) / 2;  
        if(array.get(middle).getID() == target){
            return middle;
        }
        else if(array.get(middle).getID() > target){
            right = middle - 1;
        }
        else{
            left = middle + 1;
        }
    }
        return left;
    
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        String fileInput = "records.txt";
            //Here we are taking the student's records from the records.txt file and converting it to student objects.
           try (BufferedReader br = new BufferedReader(new FileReader(fileInput))) {
            String line;

            while ((line = br.readLine()) != null) {
                //Split the line into parts
                String[] parts = line.split(", ");

                //Parse the values
                int ID = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                double GPA = Double.parseDouble(parts[3]);

                //Create a Student object
                Student student = new Student(ID, name, age, GPA);

                //Add the object to the list
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        //Now we would like to print the result of BinaryInsertion Sort into a new txt file
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("SortedStudents.txt"));
            for(Student student: BinaryInsertionSort(students)){
                writer.write(student + "\n");
            }
            writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
