
package nextpreviousfinal;

import java.awt.Color;
import java.io.*;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import oracle.jdbc.OraclePreparedStatement;
import oracle.security.o3logon.b;
import oracle.sql.BLOB;

public class OnScreenMarkingSystem extends javax.swing.JFrame{
     JTextField bi[];
  JTextField TextFied_For_Obtained_Marks;
     static int count_next_copy=1;
     static int LastCopy= new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\SudentsFirstPage").list().length;
     static int  Unatt=0;
    
    public static  Set<Integer> difference(Set<Integer> set1,Set<Integer> set2)
        {
            Set<Integer> tmp=new TreeSet<Integer>(set1);
            tmp.removeAll(set2);
            return tmp;
        }

    
    public OnScreenMarkingSystem() throws IOException {
        
        initComponents();
         showItem(pos);
         showItem1(sop);
    }
    
     int pos = 0;
    int sop = 0;
    
    public Connection getConnection()
    {
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
        
                System.out.println("event 2");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    

 // bind a list of item from mysql database
    public List<Item> getItemsList()
    {
        try {
            Connection connection = getConnection();

            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM myimages5");
            

            List<Item> list = new ArrayList<Item>();

            Item item;

            while(rs.next())
            {
               item = new Item(rs.getBytes("Image"));
               
               list.add(item);
            }
            
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     // show records and image from database 
    public void showItem(int index)
    {
      
        ImageIcon icon = new ImageIcon(getItemsList().get(index).getImage());

        Image image = icon.getImage().getScaledInstance(1300,800, Image.SCALE_SMOOTH);

        Label_for_Student_copy.setIcon(new ImageIcon(image));
        
                System.out.println("event 4");
    }
    
    public List<Item1> getItemsList1()
    {
         try {
            Connection connection = getConnection();

            Statement st = connection.createStatement();
               
            ResultSet rs = st.executeQuery("SELECT SAImage FROM Temp3");
           

            List<Item1> list1 = new ArrayList<Item1>();
           
            Item1 item1;

            while(rs.next())
            {
                
               item1 = new Item1(rs.getBytes("SAImage"));
                 
               
               list1.add(item1);
            }
            return list1;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     // show records and image from database 
    public void showItem1(int index)
    {
      
        ImageIcon icon = new ImageIcon(getItemsList1().get(index).getImage());

        Image image1 = icon.getImage().getScaledInstance(514,273, Image.SCALE_SMOOTH);

      Label_For_Sample_Answer.setIcon(new ImageIcon(image1));
        
                System.out.println("event 6");
    }

    @SuppressWarnings("unchecked")                     
    private void initComponents() {
        bi=new JTextField[array2.length];
        TextFied_For_Obtained_Marks = new JTextField();
      
        Mainpanel_for_SubTotal = new javax.swing.JPanel();
        label_For_SubTotal = new javax.swing.JLabel();

        Button_For_Submt = new javax.swing.JButton();
        panel_For_Sample_Answer = new javax.swing.JPanel();
        Drop_Down = new javax.swing.JComboBox<>();
        label_Heading_Sample_Answer = new javax.swing.JLabel();
        Label_For_Sample_Answer = new javax.swing.JLabel();
        Main_Panel_For_Buttons_SC = new javax.swing.JPanel();
        First_Button_SC = new javax.swing.JButton();
        Previous_Button_SC = new javax.swing.JButton();
        Next_Button_SC = new javax.swing.JButton();
        Last_Button_SC = new javax.swing.JButton();
        Main_Panel_For_Buttons_SA = new javax.swing.JPanel();
        First_Botton_SA = new javax.swing.JButton();
        previous_Button_SA = new javax.swing.JButton();
        next_Button_SA = new javax.swing.JButton();
        last_Button_SA = new javax.swing.JButton();
        panel_For_StuCopy_Button = new javax.swing.JPanel();
        next_Copy_Button = new javax.swing.JButton();
        label_For_Heading_Obtained_Marks = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Sroll_panel_For_Obt_Marks = new javax.swing.JPanel();
        label_Stu_Ans_Heading = new javax.swing.JLabel();
        Label_for_Student_copy = new javax.swing.JLabel();
        
           int j=10;  
        for(int i = 0; i < array2.length; i++)
        {
            JLabel l11i=new JLabel("("+(i+1)+")  Question "+array2[i]+ " : ");
            l11i.setBounds(50,j,220,30);
            l11i.setFont(new Font("TAHOMA", Font.BOLD, 15));
            bi[i] = new JTextField();           
           
             // jTextField[i]=new javax.swing.JTextField();
             bi[i].setBounds(210,j,60,30);
            JLabel l21i=new JLabel("/"+array3[i]);
            l21i.setBounds(272,j,60,30);
            l21i.setFont(new Font("TAHOMA", Font.BOLD, 15));
            Sroll_panel_For_Obt_Marks.add(l21i);
            Sroll_panel_For_Obt_Marks.add(l11i); Sroll_panel_For_Obt_Marks.add(bi[i]); 
            j=j+33;
        }
        for(int f=(array2.length-Unatt);f<array2.length;f++)
        {
            bi[f].setEnabled(false);
        bi[f].setText("NA");
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mainpanel_for_SubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Mainpanel_for_SubTotal.setName("Panel_for_overall_Subtotal"); // NOI18N

        label_For_SubTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_For_SubTotal.setText("Sub Total : ");
        label_For_SubTotal.setName("label_contaning_heading_\"Sub_total\""); // NOI18N

        TextFied_For_Obtained_Marks.setEditable(false);
        TextFied_For_Obtained_Marks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextFied_For_Obtained_Marks.setName("non_editable_Text_Field_For_Obtained_marks"); // NOI18N
         
         

        Button_For_Submt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Button_For_Submt.setText("SUBMIT");
        Button_For_Submt.setName("Submit_button"); // NOI18N
         Button_For_Submt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_For_SubmtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Mainpanel_for_SubTotalLayout = new javax.swing.GroupLayout(Mainpanel_for_SubTotal);
        Mainpanel_for_SubTotal.setLayout(Mainpanel_for_SubTotalLayout);
        Mainpanel_for_SubTotalLayout.setHorizontalGroup(
            Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mainpanel_for_SubTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_For_SubTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFied_For_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(Button_For_Submt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Mainpanel_for_SubTotalLayout.setVerticalGroup(
            Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Mainpanel_for_SubTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_For_SubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFied_For_Obtained_Marks, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(Button_For_Submt)))
                .addContainerGap())
        );

        panel_For_Sample_Answer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_For_Sample_Answer.setName("Main_panel_for_sample_answer"); // NOI18N

        Drop_Down.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" }));
        Drop_Down.setName("Drop_down"); // NOI18N

        label_Heading_Sample_Answer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_Heading_Sample_Answer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Heading_Sample_Answer.setText("SAMPLE ANSWER");
        label_Heading_Sample_Answer.setName("Label_For_heading_SampleAnswer"); // NOI18N

        Label_For_Sample_Answer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel_For_Sample_AnswerLayout = new javax.swing.GroupLayout(panel_For_Sample_Answer);
        panel_For_Sample_Answer.setLayout(panel_For_Sample_AnswerLayout);
        panel_For_Sample_AnswerLayout.setHorizontalGroup(
            panel_For_Sample_AnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_For_Sample_AnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_For_Sample_AnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_For_Sample_Answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_For_Sample_AnswerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Drop_Down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_Heading_Sample_Answer, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_For_Sample_AnswerLayout.setVerticalGroup(
            panel_For_Sample_AnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_For_Sample_AnswerLayout.createSequentialGroup()
                .addComponent(label_Heading_Sample_Answer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Drop_Down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_For_Sample_Answer, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Main_Panel_For_Buttons_SC.setName("panel containing buttons for student copy"); // NOI18N

        First_Button_SC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        First_Button_SC.setText("First");
        First_Button_SC.setName("First_button"); // NOI18N
        First_Button_SC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                First_Button_SCActionPerformed(evt);
            
                System.out.println("event next");
            }
        });

        Previous_Button_SC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Previous_Button_SC.setText("Previous");
        Previous_Button_SC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Previous_Button_SCActionPerformed(evt);
            
                System.out.println("event next");
            }
        });

        Next_Button_SC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Next_Button_SC.setText("Next");
        Next_Button_SC.setName("Next_Button"); // NOI18N
        Next_Button_SC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Next_Button_SCActionPerformed(evt);
            
                System.out.println("event next");
            }
        });


        Last_Button_SC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Last_Button_SC.setText("Last");
        Last_Button_SC.setName("Last button"); // NOI18N
        Last_Button_SC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Last_Button_SCActionPerformed(evt);
            
                System.out.println("event next");
            }
        });

        javax.swing.GroupLayout Main_Panel_For_Buttons_SCLayout = new javax.swing.GroupLayout(Main_Panel_For_Buttons_SC);
        Main_Panel_For_Buttons_SC.setLayout(Main_Panel_For_Buttons_SCLayout);
        Main_Panel_For_Buttons_SCLayout.setHorizontalGroup(
            Main_Panel_For_Buttons_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Panel_For_Buttons_SCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(First_Button_SC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Previous_Button_SC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Next_Button_SC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Last_Button_SC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Main_Panel_For_Buttons_SCLayout.setVerticalGroup(
            Main_Panel_For_Buttons_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Panel_For_Buttons_SCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Main_Panel_For_Buttons_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Last_Button_SC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Next_Button_SC, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(First_Button_SC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Previous_Button_SC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Main_Panel_For_Buttons_SA.setName("Panel_for_Buttons_For_Sample_Answer"); // NOI18N

        First_Botton_SA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        First_Botton_SA.setText("First");
        First_Botton_SA.setName("First_button"); // NOI18N
        First_Botton_SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                First_Botton_SAActionPerformed(evt);
            
                System.out.println("event next");
            }
        });

        previous_Button_SA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        previous_Button_SA.setText("Previous");
        previous_Button_SA.setName("Previous_button"); // NOI18N
        previous_Button_SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_Button_SAActionPerformed(evt);
            
                System.out.println("event next");
            }
        });
        

        next_Button_SA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        next_Button_SA.setText("Next");
        next_Button_SA.setName("Next_button"); // NOI18N
        next_Button_SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_Button_SAActionPerformed(evt);
            
                System.out.println("event next");
            }
        });

        last_Button_SA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        last_Button_SA.setText("Last");
        last_Button_SA.setName("Last_button"); // NOI18N
        last_Button_SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_Button_SAActionPerformed(evt);
            
                System.out.println("event next");
            }
        });

        javax.swing.GroupLayout Main_Panel_For_Buttons_SALayout = new javax.swing.GroupLayout(Main_Panel_For_Buttons_SA);
        Main_Panel_For_Buttons_SA.setLayout(Main_Panel_For_Buttons_SALayout);
        Main_Panel_For_Buttons_SALayout.setHorizontalGroup(
            Main_Panel_For_Buttons_SALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Panel_For_Buttons_SALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(First_Botton_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(previous_Button_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(next_Button_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(last_Button_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Main_Panel_For_Buttons_SALayout.setVerticalGroup(
            Main_Panel_For_Buttons_SALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Panel_For_Buttons_SALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Main_Panel_For_Buttons_SALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(last_Button_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_Button_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous_Button_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(First_Botton_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_For_StuCopy_Button.setName("Button For Submit and Next Copy"); // NOI18N

        next_Copy_Button.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        next_Copy_Button.setText("NEXT COPY");
        next_Copy_Button.setName("Next Copy Button"); // NOI18N
        next_Copy_Button.setEnabled(false);
         
      next_Copy_Button.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
                try {
                    next_Copy_ButtonActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(OnScreenMarkingSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }

        });
        javax.swing.GroupLayout panel_For_StuCopy_ButtonLayout = new javax.swing.GroupLayout(panel_For_StuCopy_Button);
        panel_For_StuCopy_Button.setLayout(panel_For_StuCopy_ButtonLayout);
        panel_For_StuCopy_ButtonLayout.setHorizontalGroup(
            panel_For_StuCopy_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_For_StuCopy_ButtonLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(next_Copy_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panel_For_StuCopy_ButtonLayout.setVerticalGroup(
            panel_For_StuCopy_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_For_StuCopy_ButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(next_Copy_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        label_For_Heading_Obtained_Marks.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_For_Heading_Obtained_Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_For_Heading_Obtained_Marks.setText("OBTAINED MARKS");
        label_For_Heading_Obtained_Marks.setName("label_for_heading_obtained_marks"); // NOI18N

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Sroll_panel_For_Obt_Marks.setName("scroll_panel_for_obtained_marks"); // NOI18N

        javax.swing.GroupLayout Sroll_panel_For_Obt_MarksLayout = new javax.swing.GroupLayout(Sroll_panel_For_Obt_Marks);
        Sroll_panel_For_Obt_Marks.setLayout(Sroll_panel_For_Obt_MarksLayout);
        Sroll_panel_For_Obt_MarksLayout.setHorizontalGroup(
            Sroll_panel_For_Obt_MarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        Sroll_panel_For_Obt_MarksLayout.setVerticalGroup(
            Sroll_panel_For_Obt_MarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(Sroll_panel_For_Obt_Marks);

        label_Stu_Ans_Heading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_Stu_Ans_Heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Stu_Ans_Heading.setText("STUDENT ANSWER SHEET");
        label_Stu_Ans_Heading.setName("label_for_heading_\"Stydent_answer_Sheet\""); // NOI18N

        Label_for_Student_copy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Main_Panel_For_Buttons_SC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 660, Short.MAX_VALUE)
                                .addComponent(Main_Panel_For_Buttons_SA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_For_StuCopy_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_Stu_Ans_Heading, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
                            .addComponent(Label_for_Student_copy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mainpanel_for_SubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(panel_For_Sample_Answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_For_Heading_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Stu_Ans_Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_For_Heading_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Mainpanel_for_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(panel_For_Sample_Answer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Label_for_Student_copy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Main_Panel_For_Buttons_SA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Main_Panel_For_Buttons_SC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(panel_For_StuCopy_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(270, Short.MAX_VALUE))
       
   
         );
        
        
        
                    ActionListener actionListener = new ActionListener() {
                  public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Selected: " + Drop_Down.getSelectedItem());
                    int x=Integer.parseInt((String) Drop_Down.getSelectedItem());
                    showItem1((int)x-1);
                    //if seslected gfghggh ==dgx
                    //gye wali image 
                    //else    or switch case.....
                    System.out.println(", Position: " + Drop_Down.getSelectedIndex());
                    }
                    };
                  Drop_Down.addActionListener(actionListener);
   

        pack();
    }// </editor-fold>           
    
    
    // First
    private void First_Button_SCActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
        pos = 0;
        showItem(pos);
                
    }                                        
    
   // Next
    private void Next_Button_SCActionPerformed(java.awt.event.ActionEvent evt) {                                             
        pos++;
        if(pos >= getItemsList().size())
        {
            pos = getItemsList().size()-1;
        }
        showItem(pos);
    }                                            


// Previous
    private void Previous_Button_SCActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        pos--;
        if(pos < 0)
        {
            pos = 0;
        }
        showItem(pos);
    }                                                

// Last
    private void Last_Button_SCActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        pos = getItemsList().size() - 1;
        showItem(pos);
        
    }       
    
     // First
    private void First_Botton_SAActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
        sop = 0;
        showItem1(sop);
                
    }                                        
    
   // Next
    private void next_Button_SAActionPerformed(java.awt.event.ActionEvent evt) {                                             
        sop++;
        if(sop >= getItemsList1().size())
        {
            sop = getItemsList1().size()-1;
        }
        showItem1(sop);
    }                                            


// Previous
    private void previous_Button_SAActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        sop--;
        if(sop < 0)
        {
            sop = 0;
        }
        showItem1(sop);
    }                                                

// Last
    
   private void last_Button_SAActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        sop = getItemsList1().size() - 1;
        showItem1(sop);
        
    } 
   
    public static boolean isNumeric(String str)  
    {              
        try  
        {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }
   
    private void Button_For_SubmtActionPerformed(java.awt.event.ActionEvent evt)        //SUBMIT BUTTON 
    {          
        //OnScreenMarkingSystem osm;
        int i=0;
        int totalmarks=0;
        StringBuffer sb=new StringBuffer();
        StringBuffer sb1=new StringBuffer();
        
        String res=null;        
        int flag=0;         
        /*Values : 
        -1 for negative marks
        1 for more than max marks
        */    
        int count=0;
        for( i=0;i<array2.length-Unatt;i++)
        {
            
            if(!isNumeric(bi[i].getText()))
            {
            JOptionPane.showMessageDialog(null, "Field can't be left empty.");
                count++;                
                bi[i].setText("");
                bi[i].requestFocus();
                bi[i].setBackground(Color.yellow);  
            }    
        }       
        
        for( i=0;i<array2.length-Unatt;i++)
        {   
            if(array3[i]<Integer.parseInt(bi[i].getText()))
            {
                JOptionPane.showMessageDialog(null, "Obtained marks cannot be more than maximum marks.");
                count++;
                bi[i].setText("");
                bi[i].requestFocus();
                bi[i].setBackground(Color.RED);                
            }
            else if(Integer.parseInt(bi[i].getText())<0)
            {
                JOptionPane.showMessageDialog(null, "Negative marking is not allowed."); 
                count++;
                bi[i].setText("");
                bi[i].requestFocus();
                bi[i].setBackground(Color.RED);
            }
            else /*if(!isNumeric(bi[i].getText()))
            {
                JOptionPane.showMessageDialog(null, "Field can't be left empty.");
                count++;                
                bi[i].setText("");
                bi[i].requestFocus();
                bi[i].setBackground(Color.yellow);            
            }*/   
            if(i==array2.length-Unatt-1)
            {
                res=bi[i].getText();
                sb.append(res);
                totalmarks+=Integer.parseInt(res);
            }
            else
            {
                res=bi[i].getText();
                sb.append(res).append(",");
                totalmarks+=Integer.parseInt(res);
            }
           /*switch(flag)
            {
                case -1:
                    JOptionPane.showMessageDialog(null, "Negative marking is not allowed."); 
                    //count++;
                    System.out.println("NM "+i);
                    bi[i].setText("");
                    bi[i].requestFocus();
                    bi[i].setBackground(Color.RED);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Invalid number fed in the field. Please Re-enter.");
                    //count++;
                    System.out.println("IN "+i);
                    bi[i].setText("");
                    bi[i].requestFocus();
                    bi[i].setBackground(Color.RED);
                    break;
                case -2:
                    JOptionPane.showMessageDialog(null, "Field can't be left empty.");
                    //count++;
                    System.out.println("EMPTY "+i);
                    bi[i].setText("");
                    bi[i].requestFocus();
                    bi[i].setBackground(Color.yellow);
                    break;
                default:                
                    System.out.println(i+" entered default");
                    if(i==array2.length-Unatt-1)
                    {
                        res=bi[i].getText();
                        sb.append(res);
                        totalmarks+=Integer.parseInt(res);
                    }
                    else
                    {
                        res=bi[i].getText();
                        sb.append(res).append(",");
                        totalmarks+=Integer.parseInt(res);
                    }
            }*/
           /* if(array3[i]<Integer.parseInt(bi[i].getText()))
            {
                JOptionPane.showMessageDialog(null, "Invalid entry. Please enter again.");
                count++;
            }            
            if(!isNumeric(bi[i].getText()))
            {
                JOptionPane.showMessageDialog(null, "Field can't be left empty.");
                bi[i].setText("");
                bi[i].requestFocus();
                bi[i].setBackground(Color.yellow);
            }    
            if(array3[i]>=Integer.parseInt(bi[i].getText()))
            {      
                if(i==array2.length-Unatt-1)
                {
                    res=bi[i].getText();
                    sb.append(res);
                    totalmarks+=Integer.parseInt(res);
                }
                else
                {
                    res=bi[i].getText();
                    sb.append(res).append(",");
                    totalmarks+=Integer.parseInt(res);
                }
            }
            else if(count>0)
            {  
                bi[i].setText("");
                bi[i].requestFocus();
                bi[i].setBackground(Color.RED);
            }*/
                 
        }
        System.out.println("Total invalid records : "+count);
       
        /*if(count!=0)
        {
            JOptionPane.showMessageDialog(null, "Invalid Entry Plz Check");
        }*/
        //System.out.println(sb.toString());
        if(count==0)
        {        
            try
            {   
                System.out.println(totalmarks);
                TextFied_For_Obtained_Marks.setText(Integer.toString(totalmarks));
       
                for(i=0;i<array2.length-Unatt;i++)
                {
                    bi[i].setBackground(Color.WHITE);
                    bi[i].setEnabled(false);
                }
                Class.forName("oracle.jdbc.driver.OracleDriver");  
  
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");  
                Statement stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  

                ResultSet rs1=stmt1.executeQuery("select CopyNumber,SRNo,Qseq,Fid from StoreFinal");  
                PreparedStatement stmt=con.prepareStatement("insert into ResultStore values(?,?,?,?,?,?,?)");  
                
                rs1.absolute(count_next_copy);
                stmt.setInt(1,rs1.getInt(1));  
                stmt.setInt(2,rs1.getInt(2));
          
                
                /*while(rs1.next())
                {
                    stmt.setInt(1,rs1.getInt(1));  
                    stmt.setInt(2,rs1.getInt(2));  
                }*/
                stmt.setString(3,sb.toString());//1 specifies the first parameter in the query  
                stmt.setInt(4,totalmarks);
                stmt.setInt(5,1);
                
                String Qseq=null;
                  for( i=0;i<array1.length;i++)
                  {
                        if(i==array1.length-1)
                         {
                             Qseq=Integer.toString(array1[i]);
                             sb1.append(Qseq);
                         }
                         else
                         {
                             Qseq=Integer.toString(array1[i]);
                             sb1.append(Qseq).append(",");
                         }
                  }
                stmt.setString(6,sb1.toString());
                stmt.setString(7,rs1.getString(4));
                int p=stmt.executeUpdate();  
                System.out.println(p+" records inserted");  

                Statement stmt2 = con.createStatement();
                stmt2.executeUpdate("Truncate table Temp");
                Statement stmt3 = con.createStatement();
                stmt3.executeUpdate("Truncate table Temp3");
                con.commit();
                con.close();  
                  next_Copy_Button.setEnabled(true);
            }
            catch(Exception e){ System.out.println(e);} 
        }
        System.out.println("Invalid entries : "+count);
    }
    
    
     private void next_Copy_ButtonActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, IOException       //NEXT BUTTON FOR ANSWER SHEET 
    {       
            
            TreeSet<Integer> setA=new TreeSet<Integer>();
            TreeSet<Integer> setB=new TreeSet<Integer>();
            Unatt=0;
            String str=null;
            Sroll_panel_For_Obt_Marks.removeAll();
            TextFied_For_Obtained_Marks.setText("");
         //   jScrollPane2.removeAll();
           jScrollPane3.setViewportView(null);

         //  jScrollPane3.setViewportView(Sroll_panel_For_Obt_Marks);

              Label_For_Sample_Answer.setIcon(null);
            Label_for_Student_copy.setIcon(null);
                     count_next_copy++; 
                     
         if ( LastCopy ==(count_next_copy-1))    
          {
               
           JOptionPane.showMessageDialog(null, "You Can Exit Now --- Thank You");
              
          }
        else
         {      
             try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");         
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                stmt.executeQuery("Truncate table myimages5");
                con.commit();
                
                
                 int count = new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsUnzippedFile\\s"+count_next_copy).list().length;

                PreparedStatement ps=con.prepareStatement("insert into myimages5 values(?)");  

                FileInputStream fin2[]=new FileInputStream[count];
                for(int v=0;v<count;v++)
                {
                fin2[v]  =new FileInputStream("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsUnzippedFile\\s"+count_next_copy+"\\"+(v+1)+".jpg");  
                ps.setBinaryStream(1,fin2[v],fin2[v].available()); 
                int i=ps.executeUpdate();  
                System.out.println(i+" records affected");  

                }
           

            
                
                //for() total number of questions attempted times...         
                ResultSet rs=stmt.executeQuery("select * from StoreFinal");  
            
                rs.absolute(count_next_copy);               
                System.out.println("Student Roll Number : "+rs.getInt(2));
                str = rs.getString(3);
               
                String Arr[]=str.split(",");
                System.out.println("Array size : "+Arr.length);
                /*    for(int i=0;i<Arr.length;i++)
                {
                    System.out.println(Arr[i]);
                }*/
                
                for (int j = 0; j < Arr.length; j++) 
                    {

                     array1[j] = Integer.parseInt(Arr[j]);
                    }
                
                
             String Arr2[] = new String [Arr.length];
                for(int n=0; n<Arr.length;n++)
                {
                         Arr2[n]= String.valueOf((n+1));
                         
                System.out.println(Arr2[n]);
                }
                
                
                int[] results = new int[Arr.length];
                
               
                for(int b=0;b<Arr.length;b++)
                    { if(Arr[b].equals("-1"))
                        {
                            Unatt++;
                        }
                    }

                for (int j = 0; j < Arr.length-Unatt; j++) 
                    {

                        results[j] = Integer.parseInt(Arr[j]);
                        System.out.println("Attempted :"+results[j]);
                    }

                for(int i=0;i<Arr.length;i++)
                    {
                            setA.add(Integer.parseInt(Arr2[i]));
                    }
                for(int i=0;i<Arr.length-Unatt;i++)
                    { 
                        setB.add(Integer.parseInt(Arr[i]));
                    }

                int x=OnScreenMarkingSystem.difference(setA,setB).size();
                Iterator it=OnScreenMarkingSystem.difference(setA, setB).iterator();
                System.out.println("Unatt"+Unatt+"Array length - Unatt"+(Arr.length-Unatt));
                int q=Arr.length-Unatt;
                while(it.hasNext())
                {
                    results[q]=(int) it.next();
                    System.out.println("Unattempted :"+results[q]);
                      q++;
                }       
                
                PreparedStatement stm=con.prepareStatement("Insert into Temp values (?,?)");  
                for(int g=0; g<results.length;g++)
                {
                    // int o=results[g];
               
                    
                    ResultSet rstemp;
                    rstemp = stmt.executeQuery("select marks from maxmarks where question="+results[g]);
                    stm.setInt(1,results[g]);
                    
                    while(rstemp.next())
                    {
                        //System.out.println(rstemp.getInt("marks"));
                        stm.setInt(2,rstemp.getInt("marks"));
                    }
                    
                    int i=stm.executeUpdate();  
                    con.commit();
                    System.out.println(i+" records inserted");  
                }
           //     split()
                
                ResultSet rs2=stmt.executeQuery("select * from Temp");  
                int f=0; 
                array2=new int[results.length];
                
                array3=new int[results.length];
                while(rs2.next())
                {
                    //System.out.println(rs.getInt(1)+" "+rs.getInt(2);  
                    array2[f]=rs2.getInt(1);
                    array3[f]=rs2.getInt(2);
                    f++;
                }        
                /*   for(int j=0;j<results.length;j++)
                {
                    System.out.println("Question ="+array2[j]+" carrys -->"+array3[j] );
                }*/
                
                
                con.close();            
            
                
                Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");       
                Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String str1=null;
                
                for (int j = 0; j < Arr.length; j++) 
                {
                results[j] = Integer.parseInt(Arr[j]);
                
                
                 //  System.out.println(results1[j]);
                }
                 PreparedStatement pstmt = null;
                //  PreparedStatement stm=connection.prepareStatement("Insert into Temp3 values (?,?)"); 
                 OraclePreparedStatement ops = (OraclePreparedStatement)connection.prepareStatement("INSERT INTO Temp3 VALUES(?,?)"); 
                for(int g=0; g<results.length;g++)
                {
                    //int o=results[g];
                    pstmt = connection.prepareStatement("select SAImage from SAnswer where QuestionNo = ?");
                    pstmt.setInt(1, results[g]);
                   
                    ResultSet rstemp;
                    rstemp = pstmt.executeQuery();
                 
                   
                    
                    Blob blob1=null;                  // System.out.println(rstemp);
                    while( rstemp.next())
                    {    
                        blob1= rstemp.getBlob("SAImage");
                        //    blob1.free();
                    }
                    ops.setInt(1, results[g]);
                    ops.setBLOB(2, (BLOB) blob1);
                    ops.execute();
                
                    connection.commit();                   
               }
            
                connection.close();
   
               
                 showItem(pos);
                 showItem1(sop);
             
                 
                 
                     int j=10;
        for(int i = 0; i < array2.length; i++)
        {
            JLabel l11i=new JLabel("("+(i+1)+")  Question "+array2[i]+ " : ");
            l11i.setBounds(50,j,220,30);
            l11i.setFont(new Font("TAHOMA", Font.BOLD, 15));
               bi[i] = new JTextField(); 
               
             // jTextField[i]=new javax.swing.JTextField();
             bi[i].setBounds(210,j,60,30);
            JLabel l21i=new JLabel("/"+array3[i]);
            l21i.setBounds(272,j,60,30);
            l21i.setFont(new Font("TAHOMA", Font.BOLD, 15));
            Sroll_panel_For_Obt_Marks.add(l11i); Sroll_panel_For_Obt_Marks.add(bi[i]); Sroll_panel_For_Obt_Marks.add(l21i);
            j=j+33;
        }
        
               for(int k=(array2.length-Unatt);k<array2.length;k++)
        {
            bi[k].setEnabled(false);
            
        bi[k].setText("NA");
        }
                         jScrollPane3.setViewportView(Sroll_panel_For_Obt_Marks);
                        next_Copy_Button.setEnabled(false);

            
            }
             catch(ClassNotFoundException | SQLException e)
            {
                e.printStackTrace();
            }  
        
         }    
            
            

    }     
   
  
         public static int array1[];
         public static int array2[];
         public static int array3[];
          public static String strr[]=null;
       public static String str=null;
    public static void main(String arg[]) throws FileNotFoundException, IOException {

        System.out.println("LastCopy"+LastCopy);
        TreeSet<Integer> setA=new TreeSet<Integer>();
        TreeSet<Integer> setB=new TreeSet<Integer>();
         
           try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");         
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                
                //for() total number of questions attempted times...         
                ResultSet rs=stmt.executeQuery("select * from StoreFinal");  
       
                rs.absolute(1);
                str = rs.getString(3); 
                String Arr[]=str.split(",");
                System.out.println("Array size : "+Arr.length);
            /*    for(int i=0;i<Arr.length;i++)
                {
                    System.out.println(Arr[i]);
                }*/
                //for storing 28 question
                String Arr2[] = new String [Arr.length];
               
                 array1=new int[Arr.length];
               
                 for (int j = 0; j < Arr.length; j++) 
                    {

                     array1[j] = Integer.parseInt(Arr[j]);
                    }
                
                
                for(int n=0; n<Arr.length;n++)
                {
                         Arr2[n]= String.valueOf((n+1));
                         
                System.out.println(Arr2[n]);
                }
                
                
                int[] results = new int[Arr.length];
                
               
                for(int b=0;b<Arr.length;b++)
                    { if(Arr[b].equals("-1"))
                        {
                            Unatt++;
                        }
                    }

                for (int j = 0; j < Arr.length-Unatt; j++) 
                    {

                        results[j] = Integer.parseInt(Arr[j]);
                        System.out.println("Attempted :"+results[j]);
                    }

                for(int i=0;i<Arr.length;i++)
                    {
                            setA.add(Integer.parseInt(Arr2[i]));
                    }
                for(int i=0;i<Arr.length-Unatt;i++)
                    { 
                        setB.add(Integer.parseInt(Arr[i]));
                    }

                int x=OnScreenMarkingSystem.difference(setA,setB).size();
                Iterator it=OnScreenMarkingSystem.difference(setA, setB).iterator();
                System.out.println("Unatt"+Unatt+"Array length - Unatt"+(Arr.length-Unatt));
                int q=Arr.length-Unatt;
                while(it.hasNext())
                {
                    results[q]=(int) it.next();
                    System.out.println("Unattempted :"+results[q]);
                      q++;
                }       

                
                
                
                
                PreparedStatement stm=con.prepareStatement("Insert into Temp values (?,?)");  
                for(int g=0; g<results.length;g++)
                {
                    // int o=results[g];
               
                    
                    ResultSet rstemp;
                    rstemp = stmt.executeQuery("select marks from maxmarks where question="+results[g]);
                    stm.setInt(1,results[g]);
                    
                    while(rstemp.next())
                    {
                        //System.out.println(rstemp.getInt("marks"));
                        stm.setInt(2,rstemp.getInt("marks"));
                    }
                    
                    int i=stm.executeUpdate();  
                    con.commit();
                    System.out.println(i+" records inserted");  
                }
                
                ResultSet rs2=stmt.executeQuery("select * from Temp");  
                int f=0; 
                array2=new int[results.length];
                
                array3=new int[results.length];
                while(rs2.next())
                {
                    //System.out.println(rs.getInt(1)+" "+rs.getInt(2);  
                    array2[f]=rs2.getInt(1);
                    array3[f]=rs2.getInt(2);
                    f++;
                }        
             /*   for(int j=0;j<results.length;j++)
                {
                    System.out.println("Question ="+array2[j]+" carrys -->"+array3[j] );
                }*/

                        PreparedStatement ps=con.prepareStatement("insert into myimages5 values(?)");  


                        int n= new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsUnzippedFile\\s"+count_next_copy).list().length;
                        FileInputStream fin[]=new FileInputStream[n];
                        for(int v=0;v<n;v++)
                        {
                        fin[v]  =new FileInputStream("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsUnzippedFile\\s"+count_next_copy+"\\"+(v+1)+".jpg");  
                        ps.setBinaryStream(1,fin[v],fin[v].available()); 
                        int i=ps.executeUpdate();  
                        System.out.println(i+" records affected");  

                        }
                
                con.close();            
            
                {
             Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");       
              Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 PreparedStatement pstmt = null;
              //  PreparedStatement stm=connection.prepareStatement("Insert into Temp3 values (?,?)"); 
                 OraclePreparedStatement ops = (OraclePreparedStatement)connection.prepareStatement("INSERT INTO Temp3 VALUES(?,?)"); 
            for(int g=0; g<results.length;g++)
               {
                    //int o=results[g];
                      pstmt = connection.prepareStatement("select SAImage from SAnswer where QuestionNo = ?");
                      pstmt.setInt(1, results[g]);
                      
                   
                      ResultSet rstemp;
                      rstemp = pstmt.executeQuery();
                 
                   
                    
                     Blob blob1=null;                  // System.out.println(rstemp);
                    while( rstemp.next())
                  {    blob1= rstemp.getBlob("SAImage");
               
             //    blob1.free();
                  }
                      ops.setInt(1, results[g]);
                 ops.setBLOB(2, (BLOB) blob1);
                 
                 ops.execute();
                
                 connection.commit();
                   
               }
            
                  connection.close();            
                }
            
            
      
            
            }
            
            catch(ClassNotFoundException | SQLException e)
            {
                e.printStackTrace();
            }  
        
        
    
        
        
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OnScreenMarkingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnScreenMarkingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnScreenMarkingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnScreenMarkingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new OnScreenMarkingSystem().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(OnScreenMarkingSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Button_For_Submt;
    private javax.swing.JComboBox<String> Drop_Down;
    private javax.swing.JButton First_Botton_SA;
    private javax.swing.JButton First_Button_SC;
    private javax.swing.JLabel Label_For_Sample_Answer;
    private javax.swing.JLabel Label_for_Student_copy;
    private javax.swing.JButton Last_Button_SC;
    private javax.swing.JPanel Main_Panel_For_Buttons_SA;
    private javax.swing.JPanel Main_Panel_For_Buttons_SC;
    private javax.swing.JPanel Mainpanel_for_SubTotal;
    private javax.swing.JButton Next_Button_SC;
    private javax.swing.JButton Previous_Button_SC;
    private javax.swing.JPanel Sroll_panel_For_Obt_Marks;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_For_Heading_Obtained_Marks;
    private javax.swing.JLabel label_For_SubTotal;
    private javax.swing.JLabel label_Heading_Sample_Answer;
    private javax.swing.JLabel label_Stu_Ans_Heading;
    private javax.swing.JButton last_Button_SA;
    private javax.swing.JButton next_Button_SA;
    private javax.swing.JButton next_Copy_Button;
    private javax.swing.JPanel panel_For_Sample_Answer;
    private javax.swing.JPanel panel_For_StuCopy_Button;
    private javax.swing.JButton previous_Button_SA;
    // End of variables declaration                     
   
}
