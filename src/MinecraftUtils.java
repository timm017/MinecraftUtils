import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import com.tjmothy.model.XBLModel;

public class MinecraftUtils extends JFrame implements ActionListener
{
    private JTextArea logTextArea = new JTextArea("", 15, 10);
    private JScrollPane logScrollPane = new JScrollPane(logTextArea);
    private JTextField gtTextField = new JTextField(20);

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
     
        logTextArea.setMargin(new Insets(10,10,10,10));
        
        //gamertag textfield section
        JPanel gtContent = new JPanel();
        JLabel gtLabel = new JLabel("Gamertag: ");
        JButton gtButton = new JButton("Go");
        gtContent.setLayout(new FlowLayout());
        gtContent.add(gtLabel);
        gtContent.add(gtTextField);
        gtContent.add(gtButton);
        
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
        JButton tntButton = new JButton("TNT", icon5);

        toolbar.add(exitButton);
        toolbar.add(exitButton1);
        toolbar.add(exitButton2);
        toolbar.add(exitButton3);
        toolbar.add(exitButton4);
        toolbar.add(tntButton);

        aboutMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        tntButton.addActionListener(this);

        add(gtContent, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);
        add(logScrollPane, BorderLayout.SOUTH);

        setTitle("Minecraft Bots");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            System.out.println(e.getActionCommand());
            // TODO Auto-generated method stub
            if (e.getActionCommand().compareTo("Exit") == 0)
            {
                System.exit(0);
            }
            if (e.getActionCommand().compareTo("About") == 0)
            {
                JOptionPane.showMessageDialog(null, "Tjmothy");
            }
            if (e.getActionCommand().compareTo("TNT") == 0)
            {
                logTextArea.setText("");
                String gtText = gtTextField.getText();
                //Check if Gamertag entry is empty
                if(gtText.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Enter a gamertag dipshit.");
                }
                else
                {
                    XBLModel xm = new XBLModel(gtText);
                    logTextArea.append(xm.getJSON() + "\n");   
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("actionPerformed: " + ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        MinecraftUtils m = new MinecraftUtils();
        m.setVisible(true);
    }
}
