package org.example.frames;

import javax.swing.*;
import java.awt.*;

public class FrameCreateProcedure extends JFrame {
    private JTextArea textArea;
    private JButton buttonSave, buttonCancel;
    private JPanel panelButtons;
    private long id;

    public FrameCreateProcedure(long id){
        this.id = id;
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(600,600));

        add(textArea);

        setTitle("Procedure");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(new Dimension(650,800));
        setVisible(true);
    }
}
