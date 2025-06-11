package Kasir.Controller;

import Kasir.View.PenjualanView;
import Kasir.View.HistoryPenjualan;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class MenuController {
    private final JDesktopPane desktopPane;

    public MenuController(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public void openPenjualanWindow() {
        PenjualanView a = new PenjualanView();
        JInternalFrame internalframe = new JInternalFrame("Penjualan", false, true, true);
        internalframe.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        internalframe.setContentPane(a.getContentPane());
        internalframe.setLocation((desktopPane.getWidth() - a.getWidth()) / 2,
                (desktopPane.getHeight() - a.getHeight()) / 2);
        internalframe.pack();
        internalframe.setVisible(true);
        desktopPane.add(internalframe);
    }

    public void openHistoryWindow() {
        HistoryPenjualan a = new HistoryPenjualan();
        JInternalFrame internalframe = new JInternalFrame("History Penjualan", false, true, true);
        internalframe.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        internalframe.setContentPane(a.getContentPane());
        internalframe.setLocation((desktopPane.getWidth() - a.getWidth()) / 2,
                (desktopPane.getHeight() - a.getHeight()) / 2);
        internalframe.pack();
        internalframe.setVisible(true);
        desktopPane.add(internalframe);
    }
}