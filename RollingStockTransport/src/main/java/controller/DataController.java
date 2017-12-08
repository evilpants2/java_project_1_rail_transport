package controller;

import java.io.*;

class DataController {

    void save(ProjectData o, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(o);
        } catch (IOException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    ProjectData load(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (ProjectData) in.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

}
