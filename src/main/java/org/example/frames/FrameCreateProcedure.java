package org.example.frames;

import org.example.handlers.ProcedureTransfer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreateProcedure extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton buttonSave, buttonCancel;
    private JPanel panelButtons;
    private long id;
    private ProcedureTransfer procedureTransfer;

    public FrameCreateProcedure(long id, ProcedureTransfer procedureTransfer){
        this.id = id;
        this.procedureTransfer = procedureTransfer;

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(600,600));

        buttonSave = new JButton("Gem procedure");
        buttonSave.addActionListener(this);

        buttonCancel = new JButton("Annuller");
        buttonCancel.addActionListener(this);

        panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButtons.setPreferredSize(new Dimension(600,40));
        panelButtons.add(buttonSave);
        panelButtons.add(buttonCancel);

        add(textArea);
        add(panelButtons);

        setTitle("Procedure");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(new Dimension(650,800));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonSave){
            procedureTransfer.setId(id);
            procedureTransfer.setProcedure(textArea.getText());
            JOptionPane.showMessageDialog(null,"Procedure er gemt!","Gemt",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
