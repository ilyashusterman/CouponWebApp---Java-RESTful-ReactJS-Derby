package coupon.web.app.tasks;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import exceptions.CouponSystemException;
import gui.login;
import system.CouponSystem;

/**
 *
 * @author ilya shusterman
 */
public class ServerSystemTray extends javax.swing.JFrame {

    /**
     * Creates new form ServerSystemTray
     */
	private static Process process;
    public ServerSystemTray(Process process2) {
        initComponents();
        process=process2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    String getStatus(){
    	try {
			return CouponSystem.getInstance().pool != null ? "ON" : "OFF";
		} catch (CouponSystemException e) {
		
		}
		return "Failure ! couldnt get pool";
    }
    String getDetails(){
    	try {
			return CouponSystem.getInstance().pool.toString();
		} catch (CouponSystemException e) {
		
		}
		return "Failure ! couldnt get info";
    }
    @SuppressWarnings({ "unchecked", "serial" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	///CouponWebAppPhase2/src/task/images/imageIcon.gif
     //	this.setIconImage(TrayIconTask.createImage("images/trayImage.gif", "tray icon"));
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        //TrayIconTask.createImage("images/91.gif", "System Server")
        //	this.setIconImage(TrayIconTask.createImage("images/trayImage.gif", "tray icon"));
        Icon icon=new ImageIcon(TrayIconTask.getInstance().createImage("images/on.gif", "on"));
       // ImageIcon iconOn=new ImageIcon(getClass().getResource("images/on.gif"));
       if (process==null){
    	   process=new Process("Undefined", "ON", "Undefined");
       }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {process.getName(),icon,process.getStatus(), process.getDetails()}
            },
            new String [] {
                "Proccess", "Image", "serverStatus", "details"
            }
        ) 
        {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, Image.class, java.lang.String.class, java.lang.String.class
            };

            @SuppressWarnings("rawtypes")
            @Override
            public Class getColumnClass(int column)
            {
                return (column == 1) ? Icon.class : super.getColumnClass(column);
            }
//            @Override
//            public Class getColumnClass(int columnIndex)
//            {
//                return (columnIndex == 1) ? ImageIcon.class : getValueAt(0, columnIndex).getClass();
//            }
        }
        );
        
        
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setPreferredScrollableViewportSize(jTable1.getPreferredSize());
      //  jTable1.getColumnModel().getColumn(1).setCellRenderer(new IconTableCellRenderer());
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
        jScrollPane1.setViewportView(jTable1);
        
        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open Gui");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
                new login();
            }
        });
        fileMenu.add(openMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit ServerTray");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );
        pack();
        
        
        //setIconImage(TrayIconTask.createImage("images/imageIcon.gif", "tray icon"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }// </editor-fold>                        

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.dispose();
    }                                            

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    /**
     * @param process the command line arguments
     */
    public static void execute(final Process process) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerSystemTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerSystemTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerSystemTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerSystemTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerSystemTray(process).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    // End of variables declaration                   


    class CustomRenderer extends DefaultTableCellRenderer 
    {
    private static final long serialVersionUID = 6703872492730589499L;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if(row == 0&& column == 1){
                cellComponent.setBackground(Color.green);
 
            } else if ( row == 0&& column==0){
                cellComponent.setBackground(Color.GRAY);
                
            } else {
                cellComponent.setBackground(Color.red);
            }
            return cellComponent;
        }
    }
    class IconTableCellRenderer extends DefaultTableCellRenderer
    {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column)
        {
            JLabel label = (JLabel)super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column
            );
            if (value instanceof Icon)
            {
                label.setText(null);
                Icon icon=new ImageIcon(TrayIconTask.getInstance().createImage("images/on.gif", "on"));
                System.out.println("Inside icon cell ");
                label.setIcon(icon);
            }
			return label;
        }
    }
}
