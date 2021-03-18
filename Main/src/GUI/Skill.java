package GUI;

import java.io.File;

public class Skill {
    private File file;
    public String name;

    public Skill(File file, String name){
        this.file = file;
        this.name = name;
    }

    public void setFile(File file){
        this.file = file;
    }
    public File getFile(){
        return file;
    }
}
