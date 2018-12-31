package record;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Record {
    public static int time = 1;
    private ArrayList<Step> st;
    private String fileName;
    public Record() {
        st = new ArrayList<>();
        time = 1;
        setFileName("record1.txt");
    }

    public ArrayList<Step> getSt() {
        return st;
    }

    public void setFileName(String str)
    {
        this.fileName = new String(str);
    }

    public String getFileName() {
        return fileName;
    }

    public void writeRocord(){
        File file =new File(getFileName());
        for(Step temp:getSt())
        {
            try {
                FileWriter fileWritter = new FileWriter(file.getName(), true);
                fileWritter.write(temp.toString());
                fileWritter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }
}
