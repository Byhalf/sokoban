package utulities;

public class Levels {
    private String[] levelsList;

    public Levels(String levels){
        this.levelsList = levels.split(";.*");
    }

    public String[] getlevelsList(){
        return this.levelsList;
    }
    public  String getLevelAsString(int n){
        return getlevelsList()[n-1];
    }


}
