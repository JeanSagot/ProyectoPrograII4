package Domain;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class UserFile {
    //atributos
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tamanno del registro
    private String myFilePath;//ruta

    public UserFile(File file) throws IOException {
        myFilePath = file.getPath();
        this.regSize = 140;
        if(file.exists() && !file.isFile()){
            throw new IOException(file.getName() + " is an invalid file");
        }else{
            randomAccessFile = new RandomAccessFile(file, "rw");
            this.regsQuantity = 
                    (int)Math.ceil((double)randomAccessFile.length() / (double)regSize);
        }
    }
    
    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    public int fileSize(){
        return this.regsQuantity;
    }
    
    public boolean putValue(int position, User user) throws IOException {
        if(position < 0 && position > this.regsQuantity){
            System.err.println("1001 - Record position is out of bounds");
            return false;
        }else{
            if(user.sizeInBytes() > this.regSize){
                System.err.println("1002 - Record size is out of bounds");
                return false;
            }else{
                //BINGO
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(user.getName());
                randomAccessFile.writeDouble(user.getScore());
                return true;
            }
        }
    }
    
    public boolean addEndRecord(User user) throws IOException {
        boolean success = putValue(this.regsQuantity, user);
        if(success){
            ++this.regsQuantity;
        }
        return success;
    }
    
    public User getUser(int position) throws IOException {
        if(position >= 0 && position <= this.regsQuantity){
            randomAccessFile.seek(position * this.regSize);
            User userTemp = new User();
            userTemp.setName(randomAccessFile.readUTF());
            userTemp.setScore(randomAccessFile.readDouble());
            
            if(userTemp.getName().equalsIgnoreCase("deleted")){
                return null;
            }else{
                return userTemp;
            }
        }else{
            System.err.println("1003 - position is out of bounds");
            return null;
        }
    }
    
    public ArrayList<User> getAllUsers() throws IOException {
        ArrayList<User> usersArray = new ArrayList<User>();
        
        for(int i = 0; i < this.regsQuantity; i++){
            User uTemp = this.getUser(i);
            if(uTemp != null){
                usersArray.add(uTemp);
            }
        }
        return usersArray;
    }
}
