/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextpreviousfinal;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import oracle.jdbc.OraclePreparedStatement;
import oracle.sql.BLOB;

/**
 *
 * @author USER
 */
public class HeadEvaluator extends javax.swing.JFrame {

    /**
     * Creates new form HeadEvaluator12
     */
       JTextField bi[];
       
       
    
    public HeadEvaluator() {
        initComponents();
    }
    
    public static  Set<Integer> difference(Set<Integer> set1,Set<Integer> set2)
        {
            Set<Integer> tmp=new TreeSet<>(set1);
            tmp.removeAll(set2);
            return tmp;
        }
    
    int pos = 0;
    int sop = 0;
    
      public Connection getConnection1()
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
    public List<Item> getItemsList2()
    {
        try {
            Connection connection = getConnection1();

            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM myimages6");
            

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
      
        ImageIcon icon = new ImageIcon(getItemsList2().get(index).getImage());

        Image image = icon.getImage().getScaledInstance(1120,800, Image.SCALE_SMOOTH);

        Label_for_Student_copy.setIcon(new ImageIcon(image));
        
                System.out.println("event 4");
    }
    
     public List<Item1> getItemsList3()
    {
         try {
            Connection connection = getConnection();

            Statement st = connection.createStatement();
               
            ResultSet rs = st.executeQuery("SELECT SAImage FROM TempHead3");
           

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
    public void showItem4(int index)
    {
      
        ImageIcon icon = new ImageIcon(getItemsList3().get(index).getImage());

        Image image1 = icon.getImage().getScaledInstance(514,273, Image.SCALE_SMOOTH);

      Label_For_Sample_Answer.setIcon(new ImageIcon(image1));
        
                System.out.println("event 6");
    }
    
    private void First_Button_SCActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
        pos = 0;
        showItem(pos);
                
    }                                        
    
   // Next
    private void Next_Button_SCActionPerformed(java.awt.event.ActionEvent evt) {                                             
        pos++;
        if(pos >= getItemsList2().size())
        {
            pos = getItemsList2().size()-1;
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
        
        pos = getItemsList2().size() - 1;
        showItem(pos);
        
    } 
    
         // First
    private void First_Botton_SAActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
        sop = 0;
        showItem4(sop);
                
    }                                        
    
   // Next
    private void next_Button_SAActionPerformed(java.awt.event.ActionEvent evt) {                                             
        sop++;
        if(sop >= getItemsList3().size())
        {
            sop = getItemsList3().size()-1;
        }
        showItem4(sop);
    }                                            


// Previous
    private void previous_Button_SAActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        sop--;
        if(sop < 0)
        {
            sop = 0;
        }
        showItem4(sop);
    }                                                

// Last
    
   private void last_Button_SAActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        sop = getItemsList3().size() - 1;
        showItem4(sop);
        
    }
    

                                                                                //LOAD BUTTON EVENT    
    private void bt_loadActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, SQLException {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");  
            Statement stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            ResultSet rs1=stmt1.executeQuery("select copynumber from resultstore where status=1");                                  //TABLE NAME: RESULTSTORE AND PREDICATE: STATUS=1
            while(rs1.next())
            {
                dd_copyno.addItem(Integer.toString(rs1.getInt(1)));
                int c = new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\SudentsFirstPage").list().length;
                txt_total.setText(Integer.toString(c)); txt_total.setEnabled(false);
                txt_check.setText("4"); txt_check.setEnabled(false);
                txt_left.setText("0"); txt_left.setEnabled(false);
            }
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    
    
    //SAMPLE ANSWERS FOR HEAD_EVALUATOR
    
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
    
    public List<Item1> getItemsList1()
    {
         try {
            Connection connection = getConnection();

            Statement st = connection.createStatement();
               
            ResultSet rs = st.executeQuery("SELECT SAImage FROM TempHead3");
           

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

        Image image1 = icon.getImage().getScaledInstance(544,290, Image.SCALE_SMOOTH);

      Label_For_Sample_Answer.setIcon(new ImageIcon(image1));
        
                System.out.println("event 6");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
            bi=new JTextField[28];

        Mainpanel_for_SubTotal = new javax.swing.JPanel();
        label_For_SubTotal = new javax.swing.JLabel();
        TextFied_For_Obtained_Marks = new javax.swing.JTextField();
        panel_For_Sample_Answer = new javax.swing.JPanel();
        Drop_Down = new javax.swing.JComboBox<>();
        label_Heading_Sample_Answer = new javax.swing.JLabel();
        Label_For_Sample_Answer = new javax.swing.JLabel();
        Main_Panel_For_Buttons_SC = new javax.swing.JPanel();
        First_Button_SC = new javax.swing.JButton();
        Previous_Button_SC = new javax.swing.JButton();
        Next_Button_SC = new javax.swing.JButton();
        Last_Button_SC = new javax.swing.JButton();
        label_For_Heading_Obtained_Marks = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Sroll_panel_For_Obt_Marks = new javax.swing.JPanel();
        label_Stu_Ans_Heading = new javax.swing.JLabel();
        Label_for_Student_copy = new javax.swing.JLabel();
        label_TNC = new javax.swing.JLabel();
        NOC_label = new javax.swing.JLabel();
        label_NOC_rem = new javax.swing.JLabel();
        dd_copyno = new javax.swing.JComboBox<>();
        Noc_remaining_Label1 = new javax.swing.JLabel();
        bt_load = new javax.swing.JButton();
        txt_total = new javax.swing.JLabel();
        txt_check = new javax.swing.JLabel();
        txt_left = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mainpanel_for_SubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Mainpanel_for_SubTotal.setName("Panel_for_overall_Subtotal"); // NOI18N

        label_For_SubTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_For_SubTotal.setText("Sub Total : ");
        label_For_SubTotal.setName("label_contaning_heading_\"Sub_total\""); // NOI18N

        TextFied_For_Obtained_Marks.setEditable(false);
        TextFied_For_Obtained_Marks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextFied_For_Obtained_Marks.setName("non_editable_Text_Field_For_Obtained_marks"); // NOI18N

        javax.swing.GroupLayout Mainpanel_for_SubTotalLayout = new javax.swing.GroupLayout(Mainpanel_for_SubTotal);
        Mainpanel_for_SubTotal.setLayout(Mainpanel_for_SubTotalLayout);
        Mainpanel_for_SubTotalLayout.setHorizontalGroup(
            Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mainpanel_for_SubTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_For_SubTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFied_For_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
        );
        Mainpanel_for_SubTotalLayout.setVerticalGroup(
            Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Mainpanel_for_SubTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mainpanel_for_SubTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_For_SubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFied_For_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(label_Heading_Sample_Answer, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_For_Sample_AnswerLayout.setVerticalGroup(
            panel_For_Sample_AnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_For_Sample_AnswerLayout.createSequentialGroup()
                .addComponent(label_Heading_Sample_Answer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Drop_Down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_For_Sample_Answer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Main_Panel_For_Buttons_SC.setName("panel containing buttons for student copy"); // NOI18N

        First_Button_SC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        First_Button_SC.setText("First");
        First_Button_SC.setName("First button"); // NOI18N
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
        Next_Button_SC.setName("Next Button"); // NOI18N
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
            .addGap(0, 0, Short.MAX_VALUE)
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

        label_TNC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_TNC.setText("Total Number of Copy");

        NOC_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NOC_label.setText("Number of Copy Checked : ");

        label_NOC_rem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_NOC_rem.setText("Number of copy Remaining :");

        dd_copyno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Noc_remaining_Label1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Noc_remaining_Label1.setText("Copy No:");

        bt_load.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt_load.setText("LOAD");
        bt_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bt_loadActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HeadEvaluator.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(HeadEvaluator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        txt_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_check.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_check.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_left.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_left.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Main_Panel_For_Buttons_SC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(label_Stu_Ans_Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_for_Student_copy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label_TNC, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(NOC_label)
                            .addGap(18, 18, 18)
                            .addComponent(txt_check, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label_NOC_rem, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_left, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addComponent(Noc_remaining_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dd_copyno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_load)
                        .addGap(387, 387, 387)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mainpanel_for_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_For_Sample_Answer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_For_Heading_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_For_Heading_Obtained_Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mainpanel_for_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(panel_For_Sample_Answer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_load)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dd_copyno, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_TNC, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NOC_label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_NOC_rem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Noc_remaining_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_check, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_left, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(label_Stu_Ans_Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Label_for_Student_copy, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Main_Panel_For_Buttons_SC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        
           dd_copyno.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String query=null;
                String query1=null;
                String Arr2[]=null;
                int array4[]=null;
                int Unatt=0;
            String str=dd_copyno.getSelectedItem().toString();
            //    System.out.println(""+dd_copyno.getSelectedItem().toString());
                TreeSet<Integer> setA=new TreeSet<Integer>();
                TreeSet<Integer> setB=new TreeSet<Integer>();
            try
            {
                
                Sroll_panel_For_Obt_Marks.removeAll();
                
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");  
                Statement stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
                Statement stmt2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
            
                ResultSet rs1=stmt1.executeQuery("select fid from storefinal where copynumber="+Integer.parseInt(str));         //rs1 contains the answer sheet folder
                ResultSet rs2=stmt1.executeQuery("select marksalloted,Seq,Fid2,TOTALMARKS from resultstore where copynumber="+Integer.parseInt(str));
               
                stmt2.executeQuery("Truncate table myimages6");
                stmt2.executeQuery("Truncate table TempHead");
                stmt2.executeQuery("Truncate table TempHead3");
                con.commit();
                 
                System.out.println("Check"+Integer.parseInt(str));
                String count_next_copy=null;
                int total=0;
                while(rs2.next())
                {
                    query=rs2.getString(1);
                    query1=rs2.getString(2);
                   count_next_copy=rs2.getString(3);
                    System.out.println("Count next copy"+count_next_copy);
                    total=rs2.getInt(4);
                }
                System.out.println("Marks"+query);
                
                String arr[]=query.split(",");
                String arr2[]=query1.split(",");
                Arr2=new String[arr2.length];
                
                for(int n=0; n<arr2.length;n++)
                {
                         Arr2[n]= String.valueOf((n+1));
                         
                System.out.println(Arr2[n]);
                }
                
                
                
                        PreparedStatement ps=con.prepareStatement("insert into myimages6 values(?)");  
                        int w= new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsUnzippedFile\\"+count_next_copy).list().length;
                        System.out.println("Number of pages ="+w);
                        FileInputStream fin[]=new FileInputStream[w];
                        for(int v=0;v<w;v++)
                        {
                        fin[v]  =new FileInputStream("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsUnzippedFile\\"+count_next_copy+"\\"+(v+1)+".jpg");  
                        ps.setBinaryStream(1,fin[v],fin[v].available()); 
                        int i=ps.executeUpdate();  
                        System.out.println(i+" records affected");  

                        }
                        
                     pos=0;
                     sop=0;
                     showItem(pos);
                   
                    
                
                
                
                int[] results = new int[arr2.length];
                
               
                for(int b=0;b<arr2.length;b++)
                    { if(arr2[b].equals("-1"))
                        {
                            Unatt++;
                        }
                    }

                for (int j = 0; j < arr2.length-Unatt; j++) 
                    {

                        results[j] = Integer.parseInt(arr2[j]);
                        System.out.println("Attempted :"+results[j]);
                    }

                for(int i=0;i<arr2.length;i++)
                    {
                            setA.add(Integer.parseInt(Arr2[i]));
                    }
                for(int i=0;i<arr2.length-Unatt;i++)
                    { 
                        setB.add(Integer.parseInt(arr2[i]));
                    }

                int x=FinaloGUIOSM.difference(setA,setB).size();
                Iterator it=OnScreenMarkingSystem.difference(setA, setB).iterator();
                System.out.println("Unatt"+Unatt+"Array length - Unatt"+(arr2.length-Unatt));
                int q=arr2.length-Unatt;
                while(it.hasNext())
                {
                    results[q]=(int) it.next();
                    System.out.println("Unattempted :"+results[q]);
                      q++;
                }       

                
                
                System.out.println(arr.length);
                int j=10,k=10; 
                 for(int i=0;i<arr.length;i++)
                { 
                    System.out.println("Array"+Integer.parseInt(arr2[i]));
                }
                 
                 
                  PreparedStatement stm=con.prepareStatement("Insert into TempHead values (?,?)");  
                for(int g=0; g<results.length;g++)
                {
                    ResultSet rstemp;
                    rstemp = stmt1.executeQuery("select marks from maxmarks where question="+results[g]);
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
                
                  ResultSet rs3=stmt1.executeQuery("select * from TempHead");  
                int S=0; 
                array4=new int[results.length];
                
              
                while(rs3.next())
                {
                    //System.out.println(rs.getInt(1)+" "+rs.getInt(2);  
                    array4[S]=rs3.getInt(2);
                    System.out.println("Array4"+array4[S]+"     "+S);
                    S++;
                }        
                 
                /*System.out.println("Arrived");*/
                 
                PreparedStatement pstmt = null;
                 OraclePreparedStatement ops = (OraclePreparedStatement)con.prepareStatement("INSERT INTO TempHead3 VALUES(?,?)"); 
            for(int g=0; g<results.length;g++)
               {
                    //int o=results[g];
                      pstmt = con.prepareStatement("select SAImage from SAnswer where QuestionNo = ?");
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
                
                con.commit();
                   
               }
            
                  showItem1(sop);
                
                
                 for(int i=0;i<results.length;i++)
                 {
                     JLabel l11i=new JLabel("("+(i+1)+")  Question "+results[i]+ " : ");
                     l11i.setBounds(50,k,220,30);
                     l11i.setFont(new Font("TAHOMA", Font.BOLD, 15));
                     l11i.setVisible(true);
                     Sroll_panel_For_Obt_Marks.add(l11i);
                     JLabel l21i=new JLabel("/"+array4[i]);
                     l21i.setBounds(272,k,60,30);
                     l21i.setFont(new Font("TAHOMA", Font.BOLD, 15));
                     Sroll_panel_For_Obt_Marks.add(l21i);
                     k+=33;
                }
                
                for(int i=0;i<arr2.length-Unatt;i++)
                {     
                    System.out.println("Array"+Integer.parseInt(arr[i]));
                    bi[i]=new JTextField();
                    bi[i].setBounds(210,j,60,30);
                    bi[i].setText(arr[i]);
                    bi[i].setEnabled(false);
                    bi[i].setVisible(true);
                    Sroll_panel_For_Obt_Marks.add(bi[i]);
                    j=j+33;
                }
                
                 for(int f=(arr2.length-Unatt);f<arr2.length;f++)
                    {
                    bi[f]=new JTextField();
                    bi[f].setEnabled(false);
                    bi[f].setBounds(210,j,60,30);
                    bi[f].setText("NA");
                    bi[f].setVisible(true);
                       Sroll_panel_For_Obt_Marks.add(bi[f]);
                       j=j+33;
                    }
                 TextFied_For_Obtained_Marks.setEditable(false);
                 TextFied_For_Obtained_Marks.setText(Integer.toString(total));
                
            }
              catch(Exception e1)
              {
                  System.out.println(e);
              }
            }
        });
           
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

 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(HeadEvaluator12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeadEvaluator12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeadEvaluator12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeadEvaluator12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeadEvaluator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> Drop_Down;
    private javax.swing.JButton First_Button_SC;
    private javax.swing.JLabel Label_For_Sample_Answer;
    private javax.swing.JLabel Label_for_Student_copy;
    private javax.swing.JButton Last_Button_SC;
    private javax.swing.JPanel Main_Panel_For_Buttons_SC;
    private javax.swing.JPanel Mainpanel_for_SubTotal;
    private javax.swing.JLabel NOC_label;
    private javax.swing.JButton Next_Button_SC;
    private javax.swing.JLabel Noc_remaining_Label1;
    private javax.swing.JButton Previous_Button_SC;
    private javax.swing.JPanel Sroll_panel_For_Obt_Marks;
    private javax.swing.JTextField TextFied_For_Obtained_Marks;
    private javax.swing.JButton bt_load;
    private javax.swing.JComboBox<String> dd_copyno;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_For_Heading_Obtained_Marks;
    private javax.swing.JLabel label_For_SubTotal;
    private javax.swing.JLabel label_Heading_Sample_Answer;
    private javax.swing.JLabel label_NOC_rem;
    private javax.swing.JLabel label_Stu_Ans_Heading;
    private javax.swing.JLabel label_TNC;
    private javax.swing.JPanel panel_For_Sample_Answer;
    private javax.swing.JLabel txt_check;
    private javax.swing.JLabel txt_left;
    private javax.swing.JLabel txt_total;
    // End of variables declaration                   
}