package Domain;

/**
 *
 * @author Diego
 */
public class User {
    
    private String name;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public User() {
    }

    public void setScore(double score) {
        this.score = score;
    }

    public User(String name, float score) {
        this.name = name;
        this.score = score;
    }
    
    public int sizeInBytes(){
        //String: necesita 2 bytes de espacio.
        return this.getName().length() * 2 + 8;
    }
}
