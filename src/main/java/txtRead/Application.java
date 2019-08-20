package txtRead;

import org.jfree.ui.RefineryUtilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<List<Float>> accuracyLists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        TxtRead txtRead = new TxtRead("/9_MLP.txt");
        txtRead.readTxt();
        accuracyLists.add(txtRead.getAccuracyList());

        txtRead = new TxtRead("/1_LSTM.txt");
        txtRead.readTxt();
        accuracyLists.add(txtRead.getAccuracyList());

        txtRead = new TxtRead("/2_LSTM.txt");
        txtRead.readTxt();
        accuracyLists.add(txtRead.getAccuracyList());

        txtRead = new TxtRead("/3_LSTM.txt");
        txtRead.readTxt();
        accuracyLists.add(txtRead.getAccuracyList());

        final LineChart demo = new LineChart("",accuracyLists);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
