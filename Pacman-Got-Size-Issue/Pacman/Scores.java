package Pacman;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Scores implements Serializable {
    protected static ArrayList<Player> classicHS = new ArrayList<>();
    protected static ArrayList<Player> timedHS = new ArrayList<>();
    protected static ArrayList<Player> revengeHS = new ArrayList<>();
    protected static String classicDisp = "";
    protected static String timedDisp = "";
    protected static String revengeDisp = "";
    public boolean topTen = false;
//    FileOutputStream fileOut;
//    private static final String FILE_NAME = "C:\\Users\\USER\\Desktop\\Pacman\\FILE.ser";
//    ObjectOutputStream out;
//    File fin = new File(FILE_NAME);
//    FileInputStream fileIn;
//    ObjectInputStream in_;




    public Scores(){

    }

    public void saveToList(Player given){
        System.out.println("ADDING!");
        if(given.getMode() == 1) { //classic
            System.out.println("CLASSIC!");
            if (classicHS.size() != 7) {
                classicHS.add(given);
            } else {
                for (int i = 0; i < classicHS.size(); i++) {
                    if (classicHS.get(i).getScore() < given.getScore()) {
                        classicHS.add(i, given);
                        break;
                    }
                 }
            }
            if(classicHS.size() == 8){
                classicHS.remove(7);
            }
            Collections.sort(classicHS);
            classicDisp = "";
            for(int i = 0; i < classicHS.size(); i++){
                classicDisp += (i + 1) + ". " +classicHS.get(i).getName() + "\n";
                classicDisp += "    " + classicHS.get(i).getScore() +" m" +"\n";
            }

        }
        else if(given.getMode() == 2){ //timed
            if(timedHS.size() != 7){
                timedHS.add(given);
            }else{
                for(int i = 0; i < timedHS.size(); i++){
                    if(timedHS.get(i).getScore() < given.getScore()){
                        timedHS.add(i, given);
                        break;
                    }
                }
            }
            if(timedHS.size() == 8){
                timedHS.remove(7);
            }
            Collections.sort(timedHS);
            timedDisp = "";
            for(int j = 0; j < timedHS.size(); j++){
                timedDisp += (j + 1) + ". " + timedHS.get(j).getName() + "\n";
                timedDisp += "  " + timedHS.get(j).getScore() + " kills" +"\n";
            }
        }else{
            if(revengeHS.size() != 7){
                revengeHS.add(given);
            }else{
                for(int i = 0; i < revengeHS.size(); i++){
                    if(revengeHS.get(i).getScore() < given.getScore()){
                        revengeHS.add(i, given);
                        break;
                    }
                }
            }
            if(revengeHS.size() == 8){
                revengeHS.remove(7);
            }

            Collections.sort(revengeHS);
            revengeDisp = "";
            for(int k = 0; k < revengeHS.size(); k++){
                revengeDisp += (k + 1) + ". " + revengeHS.get(k).getName() + "\n";
                revengeDisp += "  " + revengeHS.get(k).getScore() + " kills" +"\n";
            }
        }
//        try {
//            File fin = new File(FILE_NAME);
//            fileOut = new FileOutputStream(fin);
//            out = new ObjectOutputStream(fileOut);
//            out.writeObject(classicHS);
//            out.writeObject(timedHS);
//            out.writeObject(revengeHS);
//            out.close();
//            fileOut.close();
//    } catch (IOException i) {
//        i.printStackTrace();
//    }
    }

    public boolean checkTopTen(Player given ){
        topTen = false;
        if(given.getMode() == 1) { //classic
            if (classicHS.size() != 7) {
                topTen = true;
            } else {
                int i;
                for (i = 0; i < classicHS.size(); i++) {
                    if (classicHS.get(i).getScore() < given.getScore()) {
                        topTen = true;
                        break;
                    }
                }
            }
        }
        else if(given.getMode() == 2){ //timed
            if(timedHS.size() != 7){
                topTen = true;
            }else{
                for(int i = 0; i < timedHS.size(); i++){
                    if(timedHS.get(i).getScore() < given.getScore()){
                        topTen = true;
                        break;
                    }
                }
            }
        }else{
            if(revengeHS.size() != 7){
                topTen = true;
            }else{
                for(int i = 0; i < revengeHS.size(); i++){
                    if(revengeHS.get(i).getScore() < given.getScore()){
                        topTen = true;
                        break;
                    }
                }
            }
        }
        return topTen;
    }
}
