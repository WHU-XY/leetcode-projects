package txtRead;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtRead {
    private String filePath;
    private List<Float> accuracyList = new ArrayList<>();

    public TxtRead(String filePath){
        this.filePath = filePath;
    }

    public void readTxt() throws IOException {
        String path = this.getClass().getResource(filePath).getPath();
        System.out.println(path);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String contentLine = br.readLine();
        boolean is = false;
        while (contentLine != null){
            //System.out.println(contentLine);
            String[] splitString = contentLine.split("\\s+");
            if (is){
                accuracyList.add(Float.valueOf(splitString[1])*100);
                is = false;
            }
            if (splitString[0].equals("Label") && splitString[1].equals("Accuracy")){
                is = true;
            }
            contentLine = br.readLine();
        }
        System.out.println(accuracyList.size());
        System.out.println(accuracyList);
    }

    public List<Float> getAccuracyList() {
        return accuracyList;
    }
}
