import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

public class Form extends JFrame implements ActionListener {

    private JTextField jtTitle, jtDescription;
    private JRadioButton rdProgram, rdNetwork, rdWeb;
    private JComboBox<String> jcbYear;
    private JComboBox<String> jcBtn;
    private JButton btnAdd, btnClear, btnExit;
    private Vector<Book> books = new Vector<>();
    private JList jlist;
    private Container container;
    String[] sortButton;


    public Form() {
//        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Book");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
        addAction();
    }

    private void initComponents() {
        container = getContentPane();

        JPanel pHeader = new JPanel(new FlowLayout());
        pHeader.add(new JLabel("Book Information"));

        JPanel pInsert = new JPanel(new GridLayout(4, 2));

        pInsert.add(new JLabel("Title"));
        pInsert.add(jtTitle = new JTextField(30));

        pInsert.add(new JLabel("Description"));
        pInsert.add(jtDescription = new JTextField(30));

        pInsert.add(new JLabel("Type"));
        JPanel panelType = new JPanel(new GridLayout(1, 3));
        panelType.add(rdProgram = new JRadioButton("Programming"));
        panelType.add(rdNetwork = new JRadioButton("Network"));
        panelType.add(rdWeb = new JRadioButton("Web development"));

        ButtonGroup btnGroupType = new ButtonGroup();
        btnGroupType.add(rdProgram);
        btnGroupType.add(rdNetwork);
        btnGroupType.add(rdWeb);
        pInsert.add(panelType);
        pInsert.add(new JLabel("Year"));
        jcbYear = new JComboBox<>();
        for (int i = 9; i >= 0; i--)
            jcbYear.addItem("201" + i);
        pInsert.add(jcbYear);

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(pHeader, "North");
        p1.add(pInsert, "Center");

        JPanel pButton = new JPanel(new GridLayout(1, 4));
        pButton.add(btnAdd = new JButton("Add"));
        sortButton = new String[]{"Sort by title", "Sort by year", "Sort by type"};
        jcBtn = new JComboBox<>();
        for(int i = 0; i < sortButton.length; i++)
            jcBtn.addItem(sortButton[i]);
        pButton.add(jcBtn);
        pButton.add(btnClear = new JButton("Clear"));
        pButton.add(btnExit = new JButton("Exit"));
        JPanel pNorth = new JPanel(new BorderLayout());
        pNorth.add(p1, "North");
        pNorth.add(pButton, "Center");

        JPanel pCenter = new JPanel(new BorderLayout());
        pCenter.add(new JScrollPane(jlist = new JList<Book>()));
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        container.add(pNorth, "North");
        container.add(pCenter, "Center");
    }

    private void addAction() {
        btnAdd.addActionListener(this);
        jcBtn.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title, des, type, year;
            title = jtTitle.getText();
            des = jtDescription.getText();
            if (rdProgram.isSelected())
                type = rdProgram.getText();
            else if (rdNetwork.isSelected())
                type = rdNetwork.getText();
            else
                type = rdWeb.getText();
            year = jcbYear.getSelectedItem().toString();
            books.add(new Book(title, des, year, type));
            jlist.setListData(books.toArray());
        }

        if(e.getSource() == jcBtn){
            String selected = jcBtn.getSelectedItem().toString();
            int selectedIndex = -1;
            for(int i = 0; i < 2; i++)
                if(selected.equals(jcBtn.getItemAt(i))){
                    selectedIndex = i;
                    break;
                }
            if(selectedIndex == 0){
                Collections.sort(books, new CompareTitle());
            }
            if(selectedIndex == 1){
                Collections.sort(books, new CompareYear());
            }
            if(selectedIndex == 2){
                Collections.sort(books, new CompareType());
            }
            jlist.setListData(books.toArray());
        }
        if(e.getSource() == btnClear){
            jtTitle.setText("");
            jtDescription.setText("");
            jcbYear.setSelectedIndex(0);

        }


        if(e.getSource() == btnExit){
            System.exit(0);
        }

    }
}