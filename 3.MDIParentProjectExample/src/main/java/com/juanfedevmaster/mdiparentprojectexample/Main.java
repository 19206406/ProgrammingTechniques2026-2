package com.juanfedevmaster.mdiparentprojectexample;

import com.juanfedevmaster.mdiparentprojectexample.ui.LoginFrame;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
