/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 * This class is Selling page which allows to Sell medicines.
 * @author ANIS
 * Date: 26-03-2022
 * @version 1.0
 * @since 1.0
 */
public class Selling extends javax.swing.JFrame {

    /**
     * Creates new form Selling.
     */
    public Selling() 
    {
        initComponents();
        SelectMed();
        ShowDate();
        
        medicine_list = new ArrayList<String>();
        getbillno();
        BillNo.setText(Integer.valueOf(bill_no).toString());
//        JOptionPane.showMessageDialog(this, "bill_no:" + bill_no);
//        setbillno();
    }
    
    /**
     * Initialize Variables for Database Connection,Query, Array list, and Global variables.
    */
    Connection Con = null;
    Statement St1 = null;
    ResultSet Rs1 = null;
    
    int i = 0, MedPrice, OldQty, MedId, newQty, temp,  bill_no;
    double total,cgst, sgst, total_with_gst;
    
    /**
     * Creates new objects of Array list and Date.
    */
    public ArrayList<String> medicine_list;
    Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
      
    
    /**
     * This method show date in form by Replacing Dateb1 Text field.
    */
    public void ShowDate()
    {
        Datebl.setText(s.format(d));        
    }
    
    /**
     * This method gets Bill No from Database and add + 1 to show next Bill no.
    */
    public void getbillno()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("Select billno from billno order by billno desc limit 1");
            Rs1.next();
            bill_no = Rs1.getInt("billno")+1;
            ///Con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }    
    }
    
    /**
     * This method Set Bill no in in database.
     * <p> This method is to insert latest Bill no into database to retrieve 
     * latest bill when generating new bill.</p>
    */
    public void setbillno()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
            PreparedStatement add = Con.prepareStatement("Insert Into billno values(?)");
                
            add.setInt(1, Integer.valueOf(BillNo.getText()));
            
            int row = add.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Medicine Successfully Added");
           
//            Con.close();
            
            //to display entered records in GUI table 
            getbillno();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * This method retrieve Medicine data from database and display into Medicine table.
    */
    public void SelectMed()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("Select * from medicinetbl");
            MedicineTable.setModel(DbUtils.resultSetToTableModel(Rs1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }    
    }
    
    /**
     * This method Update Medicine data from database and display into Medicine table.
     * <p> This method Updates the medicine data from medicine table as we add the medicines to array list
     * and also revert back the old data if clear button is pressed.</p> 
    */
    
    int oldqty_beforeupdate;
    public void Update()
    {
        newQty = Integer.valueOf(MedQty.getText());
        oldqty_beforeupdate = OldQty;
        temp = temp + newQty;
        OldQty = OldQty - newQty;
        
//        if(OldQty == 0 )
//        {
//            JOptionPane.showMessageDialog(this, "Sorry No Stocks Available");
//        }
//        else 
        if(Integer.valueOf(MedQty.getText()) > oldqty_beforeupdate)
        {
            

            JOptionPane.showMessageDialog(this, "Please Enter Quantity Less then " + oldqty_beforeupdate);
        }
        else
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
                String UpdateQuery = "Update medicinetbl set Quantity = "+OldQty+""+" where Id = "+MedId;
                Statement updt = Con.createStatement();
                updt.executeUpdate(UpdateQuery);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        SelectMed();
        
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Agents = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BillNo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        MedQty = new javax.swing.JTextField();
        MedName = new javax.swing.JTextField();
        Datebl = new javax.swing.JLabel();
        PrintBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Med_Id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedicineTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillText = new javax.swing.JTextArea();
        AddBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Medicine = new javax.swing.JLabel();
        Company = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));

        Agents.setBackground(new java.awt.Color(255, 255, 255));
        Agents.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Agents.setForeground(new java.awt.Color(255, 255, 255));
        Agents.setText("USER");
        Agents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgentsMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        BillNo.setBackground(new java.awt.Color(255, 255, 255));
        BillNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BillNo.setForeground(new java.awt.Color(255, 0, 51));
        BillNo.setText("BILLING");
        BillNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillNoMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("Medicine Name");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 51));
        jLabel18.setText("QUANTITY");

        MedQty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedQtyMouseClicked(evt);
            }
        });

        MedName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedNameActionPerformed(evt);
            }
        });

        Datebl.setBackground(new java.awt.Color(255, 255, 255));
        Datebl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Datebl.setForeground(new java.awt.Color(255, 0, 51));
        Datebl.setText("DATE");
        Datebl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateblMouseClicked(evt);
            }
        });

        PrintBtn.setBackground(new java.awt.Color(0, 153, 0));
        PrintBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PrintBtn.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtn.setText("PRINT");
        PrintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBtnMouseClicked(evt);
            }
        });
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("BILL No:");

        Med_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Med_IdActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("MEDCINE LIST");

        MedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Medicine Name", "Medicine Price", "Quantity", "ManuFacture Date", "Expiry Date", "Company"
            }
        ));
        MedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MedicineTable);

        BillText.setColumns(20);
        BillText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BillText.setRows(5);
        BillText.setToolTipText("");
        jScrollPane2.setViewportView(BillText);

        AddBtn.setBackground(new java.awt.Color(0, 153, 0));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("ADD TO BILL");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(0, 153, 0));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("CLEAR");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("BILL");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("SELLING");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("BILL ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BillNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Datebl)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MedName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MedQty, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Med_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(358, 358, 358))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Med_Id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(MedName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(MedQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Datebl)
                            .addComponent(BillNo)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Medicine.setBackground(new java.awt.Color(255, 255, 255));
        Medicine.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Medicine.setForeground(new java.awt.Color(255, 255, 255));
        Medicine.setText("MEDICINE");
        Medicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineMouseClicked(evt);
            }
        });

        Company.setBackground(new java.awt.Color(255, 255, 255));
        Company.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Company.setForeground(new java.awt.Color(255, 255, 255));
        Company.setText("COMPANY");
        Company.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompanyMouseClicked(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("X");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anisa\\Desktop\\Goa University\\SY\\Sem 4\\PL 405 SE\\Project\\Image\\logo_1.png")); // NOI18N
        jLabel24.setText("jLabel12");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Agents)
                                    .addComponent(Company)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Medicine)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 793, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(42, 42, 42)
                        .addComponent(Medicine)
                        .addGap(30, 30, 30)
                        .addComponent(Company)
                        .addGap(30, 30, 30)
                        .addComponent(Agents)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method calls Agents Page Button to Navigate to Agent Page.
    */
    private void AgentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgentsMouseClicked
        // TODO add your handling code here:
        new Agents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AgentsMouseClicked

    /**
     * This method calls Medicine Page Button to Navigate to Company Page.
    */
    private void MedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineMouseClicked
        // TODO add your handling code here:
        new Medicine().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MedicineMouseClicked

    /**
     * This method calls Company Page Button to Navigate to Company Page.
    */
    private void CompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompanyMouseClicked
        // TODO add your handling code here:
        new Company().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CompanyMouseClicked

    /**
     * This method Exit Button to Exit out of System.
    */
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void Med_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Med_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Med_IdActionPerformed

    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrintBtnActionPerformed

    /**
     * This method prints the bill from text area and stores into local storage.
     * <p> This method prints the bill from text area. After printing the bill 
     * it clears the text area, Medicine name from text field, and array list.
     * Also initialize i, total value to 0 and increment Bill no by 1 and 
     * update Bill no on text field and insert the updated bill into database.</p> 
    */
    private void PrintBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseClicked
        // TODO add your handling code here:
        try
        {
            BillText.print();
            BillText.setText("");
            MedName.setText("");
            medicine_list.clear();
            i= 0;
            total = 0;
            getbillno();
            BillNo.setText(Integer.valueOf(bill_no).toString());
//            JOptionPane.showMessageDialog(this, "bill_no:" + bill_no);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        setbillno();
    }//GEN-LAST:event_PrintBtnMouseClicked

    private void DateblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DateblMouseClicked

    private void MedNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedNameActionPerformed

    /**
     * This method Displays the data from the database into Medicine Table.
    */
    private void MedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)MedicineTable.getModel();
        int Myindex = MedicineTable.getSelectedRow();
        MedId = Integer.valueOf(model.getValueAt(Myindex, 0).toString());
        MedName.setText(model.getValueAt(Myindex, 1).toString());
        MedPrice = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        //MedQty.setText(model.getValueAt(Myindex, 3).toString());
        OldQty = Integer.valueOf(model.getValueAt(Myindex, 3).toString());
        SelectMed();
        
    }//GEN-LAST:event_MedicineTableMouseClicked

    /**
     * This method Adds the data from the Medicine Table into Text area to generate Bill.
    */
    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        // TODO add your handling code here:
       
        if(MedName.getText().isEmpty() || MedQty.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Name or Quantity");
        }
        else if(OldQty == 0)
        {
            
            JOptionPane.showMessageDialog(this, "Sorry No Stocks Available");
        }
        else if(Integer.valueOf(MedQty.getText()) > OldQty)
        {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity Less then " + OldQty);
        }
        else
        {
            i++;
            Update();
            
            BillText.setText("\t\t     AIO PHARMA \n\n     \t\t Goa University, Taleigao,\n     \t\t North-Goa, Goa\n"
                + "     \t\t Ph.no 9876543210\n" + "Bill.NO: " + bill_no+"\t\t\t\t Date: " + s.format(d) +"\n" + "\n" 
                        + " ************************************** BILL INVOICE **************************************\n" + "\n" 
                        + "   ID\tMEDICINE\t\t  QTY\tPRICE\tTOTAL\n");
            
            medicine_list.add("   "+i+"\t"+MedName.getText()+"\t\t    "+MedQty.getText()+"\t"+MedPrice+"\t"+Integer.valueOf(MedQty.getText())*MedPrice+"\n");
                
            for(String list:medicine_list)
            {
                BillText.setText(BillText.getText()+ list);
            }
            
            total = total + Integer.valueOf(MedQty.getText())*MedPrice;
            
            cgst = (total * 2.50)/100;
            
            sgst = (total * 2.50)/100;
            
            total_with_gst = total + cgst + sgst;
            
            BillText.setText(BillText.getText()+ "\n\n\n\n\n\t\t-----------------------------------------------------------\n\t\tTotal :\t\t"+total + "\n\t\tCSGT @2.50% :\t"+cgst
                +"\n\t\tSGST @2.50% :\t"+sgst+"\n\t\t-----------------------------------------------------------\n\t\tTotal with GST :\t"+Math.ceil(total_with_gst));
            
        }
        
        MedQty.setText("");
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    /**
     * This method clears all the value when Button is pressed.
     * And also update the old values which was deducted from 
     * the database while adding into text area to generate bill and clear the
     * text area, Medicine name, Quantity and also re-initialize all the global variables. 
    */
    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        // TODO add your handling code here:
        MedName.setText("");
        MedQty.setText("");
        BillText.setText("");
        i=0;
        
        OldQty = OldQty + temp;
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
            String UpdateQuery = "Update medicinetbl set Quantity = "+OldQty+""+" where Id = "+MedId;
            Statement updt = Con.createStatement();
            updt.executeUpdate(UpdateQuery);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        SelectMed();
        
        temp = 0;
        total = 0;
        medicine_list.clear();
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void MedQtyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedQtyMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MedQtyMouseClicked

    private void BillNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillNoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BillNoMouseClicked

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel Agents;
    private javax.swing.JLabel BillNo;
    private javax.swing.JTextArea BillText;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JLabel Company;
    private javax.swing.JLabel Datebl;
    private javax.swing.JTextField MedName;
    private javax.swing.JTextField MedQty;
    private javax.swing.JTextField Med_Id;
    private javax.swing.JLabel Medicine;
    private javax.swing.JTable MedicineTable;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
