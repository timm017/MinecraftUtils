import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MinecraftUtils extends JFrame
{
    
    private JTextArea logTextArea = new JTextArea("blah blah", 10, 6);
    private JScrollPane logScrollPane = new JScrollPane(logTextArea);

    public MinecraftUtils()
    {
        initUI();
    }

    public final void initUI()
    {
        logTextArea.setEditable(false);
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        menubar.add(file);
        setJMenuBar(menubar);
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        file.add(aboutMenuItem);
        file.add(exitMenuItem);
        JToolBar toolbar = new JToolBar();

        ImageIcon icon = new ImageIcon("res/cobblestone.png");
        ImageIcon icon1 = new ImageIcon("res/creeper.png");
        ImageIcon icon2 = new ImageIcon("res/diamond_pickaxe.png");
        ImageIcon icon3 = new ImageIcon("res/diamond_sword.png");
        ImageIcon icon4 = new ImageIcon("res/grass.png");
        ImageIcon icon5 = new ImageIcon("res/tnt.png");

        JButton exitButton = new JButton(icon);
        JButton exitButton1 = new JButton(icon1);
        JButton exitButton2 = new JButton(icon2);
        JButton exitButton3 = new JButton(icon3);
        JButton exitButton4 = new JButton(icon4);
        JButton tntButton = new JButton(icon5);

        toolbar.add(exitButton);
        toolbar.add(exitButton1);
        toolbar.add(exitButton2);
        toolbar.add(exitButton3);
        toolbar.add(exitButton4);
        toolbar.add(tntButton);

        aboutMenuItem.addActionListener(new aboutListener());
        exitMenuItem.addActionListener(new exitListener());
        tntButton.addActionListener(new tntListener());

        add(toolbar, BorderLayout.NORTH);
        add(logScrollPane, BorderLayout.SOUTH);

        setTitle("Minecraft Bots");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class exitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            System.exit(0);
        }
    }
    
    class aboutListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Tjmothy");
        }
    }
    
    class tntListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            logTextArea.append("TNT" + "\n");
        }
    }

    public static void main(String[] args)
    {
        MinecraftUtils m = new MinecraftUtils();
        m.setVisible(true);
    }
}
