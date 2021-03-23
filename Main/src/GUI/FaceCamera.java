package GUI;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import javafx.embed.swing.SwingNode;

import javax.swing.*;
import java.awt.*;

public class FaceCamera {
    private final Webcam cam = Webcam.getDefault();
    private WebcamPanel webpanel = new WebcamPanel(cam);
    final SwingNode swingNode = new SwingNode();
    private JPanel jPanelCamera = new JPanel();

    public FaceCamera() {
        startCamera(cam, webpanel, jPanelCamera, swingNode);
    }

    public static void startCamera(Webcam cam, WebcamPanel webpanel, JPanel jPanelCamera, SwingNode swingNode) {

        cam.open(true);
        webpanel.setImageSizeDisplayed(true);
        webpanel.setMirrored(true);
        webpanel.setPreferredSize(new Dimension(368, 366));
        jPanelCamera.add(webpanel);
        swingNode.setContent(jPanelCamera);
        swingNode.setTranslateX(113);
        swingNode.setTranslateY(111);
    }
}