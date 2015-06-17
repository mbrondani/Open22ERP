/*
 * The MIT License
 *
 * Copyright 2015 Diego Geronimo D' Onofre.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package erpsystem.forms;

import erpsystem.Log;
import erpsystem.Util;
import erpsystem.db.PayMethod;

import static erpsystem.Util.*;
import erpsystem.db.MovProd;
import erpsystem.db.Produto;
import erpsystem.db.PessoasDB;
import erpsystem.db.Pessoa;
import erpsystem.db.ProdutosDB;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;

import javax.swing.table.TableModel;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;



/**
 *
 * @author Diego
 */
public class MovView extends javax.swing.JFrame {

    /**
     * Creates new form MovView
     */
    static final String COMPRA = "Compra";
    static final String VENDA = "Venda";
    
    public static final int COMPRA_VALUE = 1;
    public static final int VENDA_VALUE = 2;
    
    public MovView() {
        initComponents();
        
        java.awt.Point p = Util.getCenterPoint(this.getWidth(), this.getHeight());
        this.setLocation(p);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Gerar Movimentação");
        this.setResizable(false);
        
        this.cbxPayMethod.setEditable(false);
        this.cbxPayMethod.setSelectedItem("Selecione");

        this.cbxMovType.setEditable(false);
        this.cbxMovType.setSelectedItem("Selecione");
        
        fillPayMethods();
        fillMovTypes();
        
        tfdCodCli.setNextFocusableComponent(tfdCodProd);
        tfdCodProd.setNextFocusableComponent(tfdQt);
        tfdQt.setNextFocusableComponent(tfdCodCli);
    }

    final void fillMovTypes()
    {
        this.cbxMovType.removeAllItems();
        this.cbxMovType.addItem(COMPRA);
        this.cbxMovType.addItem(VENDA);    
    }
    
    final void fillPayMethods()
    {
        cbxPayMethod.removeAllItems();
        java.util.List<erpsystem.db.PayMethod> pmList = erpsystem.db.PayMethodDB.findAll();
        final int len = pmList.size();
        
        for ( int i = 0; i < len; i++ ){
            PayMethod pm = pmList.get(i);
            cbxPayMethod.addItem(pm);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodCli = new javax.swing.JLabel();
        tfdCodCli = new javax.swing.JTextField();
        tfdQt = new javax.swing.JTextField();
        lblCodProd = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();
        tfdCodProd = new javax.swing.JTextField();
        lblCodProd1 = new javax.swing.JLabel();
        lblQt = new javax.swing.JLabel();
        btnConcluir = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblProdMov = new javax.swing.JLabel();
        btnFindCli = new javax.swing.JButton();
        btnFindProd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCliInfo = new javax.swing.JLabel();
        lblProdInfo = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxPayMethod = new javax.swing.JComboBox();
        lblPayMethod = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        cbxMovType = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                winOpen(evt);
            }
        });

        lblCodCli.setText("Código Cliente");

        tfdCodCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCodCliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdCodCliKeyTyped(evt);
            }
        });

        lblCodProd.setText("Código Produto");

        btnAdd.setText("Adicionar Produto");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProd.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblProd);
        tblProd.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        tfdCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCodProdKeyPressed(evt);
            }
        });

        lblQt.setText("Quantidade:");

        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblProdMov.setText("Produtos da Movimentação");

        btnFindCli.setText("...");
        btnFindCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCliActionPerformed(evt);
            }
        });

        btnFindProd.setText("...");
        btnFindProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindProdActionPerformed(evt);
            }
        });

        lblCliInfo.setText("Informações do Cliente");

        lblProdInfo.setText("Informações do Produto");

        lblTotal.setText("Total:");

        lblValorTotal.setText("R$ 00.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cbxPayMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblPayMethod.setText("Método de Pagamento:");

        lblTipo.setText("Tipo:");

        cbxMovType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTotal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodCli)
                            .addComponent(lblProdMov)
                            .addComponent(lblCodProd)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQt)
                                .addGap(8, 8, 8)
                                .addComponent(tfdQt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFindCli))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFindProd)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodProd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(346, 346, 346)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblProdInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(33, 33, 33))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lblTipo))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblCliInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(58, 58, 58)
                                                        .addComponent(lblPayMethod)))
                                                .addGap(4, 4, 4)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxMovType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxPayMethod, 0, 187, Short.MAX_VALUE))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodCli))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfdCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFindCli)
                                .addComponent(lblCliInfo)
                                .addComponent(cbxPayMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPayMethod))
                            .addComponent(jLabel1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCodProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFindProd)
                            .addComponent(lblProdInfo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMovType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipo))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCodProd1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQt)
                        .addComponent(tfdQt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProdMov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(lblValorTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(389, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private final static Object[] colNames = new Object[]{"Código",
                                                      "Descrição",
                                                      "Quantidade",
                                                      "Valor Unit",
                                                      "Total",
                                                };;
    
    final TableModel emptyModel = new XTableModel(new Object[0][colNames.length], colNames);
    
    private void winOpen(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_winOpen
        // TODO add your handling code here:
        
        /* ESTE PROJETO ESTÁ SENDO USADO ------> DefaultTableModel <------.
        Conforme o mesmo crescer, será necessário implementar 
        o próprio TableModel. Pelo menos é isso que está dizendo um Desenvolvedor experiente 
        de um fórum*/

        
        //Definição inicial de uma venda
        initMov();
        
        
        //Bloqueando a reordenação das colunas
        tblProd.getTableHeader().setReorderingAllowed(false);
        //Evitando seleção múltipla
        tblProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
    }//GEN-LAST:event_winOpen

    private static void fill( TableModel source, TableModel dest )
    {
        final int cc = source.getColumnCount();
        final int rc = source.getRowCount();
        
        for ( int c = 0; c < cc; c++ ){
            for ( int r = 0; r < rc; r++ ){
                Object value = source.getValueAt(r, c);
                dest.setValueAt(value, r, c);
            }
        }
    }
    
    private static boolean exists(int cod, TableModel tm)
    { 
        final int rc = tm.getRowCount();
        
        for ( int c = 0; c < rc; c++ ){
            int code = ( int ) tm.getValueAt(c,0);
            
            if ( cod == code )
                return true;
        }
        
        return false;
    }
    
    private boolean validateFields()
    {
        String codCli = tfdCodCli.getText();
        String codProd = tfdCodProd.getText();
        String qt = tfdQt.getText();
        
        if ( codCli.trim().equals("") ){
            msg("Por favor, preencha o código do cliente.");
            tfdCodCli.grabFocus();
            return false;
        }
        
        if ( codProd.trim().equals("") ){
            msg("Por favor, preencha o código do produto.");
            tfdCodProd.grabFocus();
            return false;
        }
        
        if ( qt.trim().equals("") ){
            msg("Por favor, preencha o a quantidade.");
            tfdQt.grabFocus();
            return false;
        }

        
        if (! isInt(codCli) ){
            msg("O código do cliente está em um formato inválido.\n"
              + "Por favor, informe um valor numérico válido.");
            tfdCodCli.grabFocus();
            return false;
        }
       
        if (! isInt(codProd) ){
            msg("O código do produto está em um formato inválido.\n"
              + "Por favor, informe um valor numérico válido.");
            tfdCodProd.grabFocus();
            return false;
        }
        
        if (! isInt(qt) ){
            msg("A quatidade está em um formato inválido.\n"
              + "Por favor, informe um valor numérico válido.");
            tfdQt.grabFocus();
            return false;
        }
        
        if (Integer.parseInt(qt) <= 0 ){
            msg("A quatidade deve ser maior que 0(zero)");
            tfdQt.grabFocus();
            return false;
        }
        
        return true;
    }
    
    private boolean lockCli = false;
    
    private void lockCli()
    {
        tfdCodCli.setEditable(false);
        tfdCodCli.setFocusable(false);
        tfdCodCli.setBackground(Color.lightGray);
        btnFindCli.setEnabled(false);
        
        cbxPayMethod.setEnabled(false);        
        cbxMovType.setEnabled(false);        
        
        lockCli = true;
    }
    
    private void unlockCli()
    {
        tfdCodCli.setEditable(true);
        tfdCodCli.setFocusable(true);
        tfdCodCli.setBackground(Color.white);   
        btnFindCli.setEnabled(true);
        
        cbxPayMethod.setEnabled(true);
        cbxMovType.setEnabled(true);
        
        lockCli = false;    
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        if ( validateFields() ){
            
            String cod = tfdCodProd.getText();
            TableModel oldModel = tblProd.getModel();

            if (! exists(Integer.parseInt(cod), oldModel) ){
                int icod = Integer.parseInt(cod);
                Produto prod = business.Produtos.find(icod);

                if ( prod != null ){
                    int rowCount  = oldModel.getRowCount();
                    TableModel tm = new XTableModel(colNames, rowCount + 1);

                    fill(oldModel, tm);

                    tm.setValueAt(prod.getCodigo(), rowCount, 0);
                    tm.setValueAt(prod.getDescricao(), rowCount, 1);

                    int qt = Integer.parseInt(tfdQt.getText());
                    tm.setValueAt(qt, rowCount, 2);
                    double preco = prod.getPreco();

                    tm.setValueAt(preco, rowCount, 3);

                    double total  =  qt * preco;
                    tm.setValueAt(total, rowCount, 4);

                    tblProd.setModel(tm);
                    lockCli();
                    calcTotalValue();
                    updateMovInfo();
                    initQt();
                }
                else
                    msg("Código do produto não encontrado.");
            }
            else
                msg("Produto informado já inserido.");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void initQt()
    {
        /*Adicionando o valor 1 em quantidade quando um
        novo produto é adicionado na movimentação por que
        provavelmente este é o gosto comum dos administradores.*/
        
        tfdQt.setText("1");
    }
    
    private void updateMovInfo()
    {
        String cs = tfdCodCli.getText();
        
        if ( Util.isInt(cs) ){
            int code = Integer.parseInt(cs);
            Pessoa cli = PessoasDB.find(code);

            if ( cli != null )
                fillCli(cli);
            else
                Log.log("Problema: 7680");
        }
        else
            Log.log("Problema: 7701");
        
        String ps = tfdCodProd.getText();
        
        if ( Util.isInt(ps) ){
            int code = Integer.parseInt(ps);
            Produto prod = ProdutosDB.find(code);
            
            if ( prod != null )
                fillProd(prod);
            else
                Log.log("Problema: 7743");
        }
    }
    
    private void calcTotalValue()
    {
        double result = 0;
        TableModel model = tblProd.getModel();
        
        for ( int i = 0; i < model.getRowCount(); i++ ){
            double value = ( double ) model.getValueAt(i, 4);
            result += value;
        }
        
        lblValorTotal.setText("R$ " + String.valueOf(result));
    }
    
    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        // TODO add your handling code here:
        String cod = tfdCodCli.getText().trim();

        if ( isEmptyTabProd() ){
            msg("Para realizar uma movimentação é necessário ter "
              + "\npelo menos um produto adicionado na tabela.");
            return;
        }
        
        if ( cod.equals("") ){
            msg("Não foi possível buscar o código da pessoa, "
              + "\nreporte este erro ao Desenvolvedor.");
            return;
        }

        if (! isInt(cod) ){
              msg("Código pessoa não é válido. "
              + "\nreporte este erro ao Desenvolvedor.");
              return;
        }
        
        terminateMov();


    }//GEN-LAST:event_btnConcluirActionPerformed

    private java.util.List<MovProd> getItemList(TableModel tm)
    {
        java.util.List<MovProd> result = new ArrayList();
        
        for ( int r = 0; r < tm.getRowCount(); r++ ){
            int code = (int) tm.getValueAt(r,0);
            int qt = (int) tm.getValueAt(r,2);
            double preco = (double) tm.getValueAt(r,3);    
            
            MovProd mp = new MovProd();
            mp.setCodProd(code);
            mp.setQt(qt);
            mp.setPreco(preco);
            
            result.add(mp);
        }
        
        return result;
    }
    
    private int getPayMethodCode()
    {
        return ((PayMethod)cbxPayMethod.getSelectedItem()).getCod();
    }
    
    public static int getMovType(String movType)
    {
        String s = movType;
        
        if ( s.equals(COMPRA) )
            return COMPRA_VALUE;
        else if ( s.equals(VENDA) )
            return VENDA_VALUE;
        else{
            Log.log(new Exception("Problema interno!"));
            return -1;
        }        
    }
    
    private int getMovType()
    {
        String s = ((String)cbxMovType.getSelectedItem());
        return MovView.getMovType(s);
    }
    
    private void terminateMov()
    {
        TableModel tm = tblProd.getModel();
        java.util.List<MovProd> mpList = getItemList(tm);
        String cod = tfdCodCli.getText();
        int cliCod = Integer.parseInt(cod);
        int payMethodCode = getPayMethodCode();
        int movTypeCode = getMovType();
        
        if ( movTypeCode != -1 ){
            String msg = business.Mov.persistMov(cliCod,payMethodCode, movTypeCode, mpList);

            if ( msg == null ){
                msg("Nova movimentação gerada com sucesso.");
            }
            else
                msg(msg);
        }
        //Executar o método abaixo no final.
        initMov();   
    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        initMov();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void findCli()
    {
        XConsultaClienteView c = new XConsultaClienteView()
        {
            @Override
            public void chosenCode(int code)
            {
                tfdCodCli.setText(String.valueOf(code));
                Pessoa cli = PessoasDB.find(code);
                
                if ( cli != null )
                    fillCli(cli);
                else
                    Log.log("Problema:4648");
            }
        };
        c.setVisible(true);
    }
    
    private void btnFindCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCliActionPerformed
        // TODO add your handling code here:
        findCli();
    }//GEN-LAST:event_btnFindCliActionPerformed

    private void findProd()
    {
        ConsultaProdutoView p = new XConsultaProdutoView(this, true)
        {
            @Override
            public void chosenCode(int code)
            {
                tfdCodProd.setText(String.valueOf(code));
                Produto prod = ProdutosDB.find(code);

                if ( prod != null ){
                    fillProd(prod);
                }
                else
                    Log.log("Problema: 4650");
            }
        };
        p.setVisible(true);        
    }
    
    private void btnFindProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindProdActionPerformed
        // TODO add your handling code here:
        findProd();
    }//GEN-LAST:event_btnFindProdActionPerformed

    private void tfdCodCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCodCliKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tfdCodCliKeyTyped

    private void fillCli(Pessoa cli)
    {
        lblCliInfo.setText(cli.getSummary());
    }
    
    private void tfdCodCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCodCliKeyPressed
        // TODO add your handling code here:
        java.awt.event.KeyEvent e = evt;
        int code = e.getKeyCode();
        
        if ( code == KeyEvent.VK_ENTER ){
            String s = tfdCodCli.getText().trim();
            if ( Util.isInt(s) ){
                int codCli = Integer.parseInt(s);

                if (! PessoasDB.exists(codCli) )
                    findCli();
                else{
                    Pessoa cli = PessoasDB.find(codCli);
                    
                    if ( cli != null ){
                        fillCli(cli);
                    }
                    else
                        Log.log("Problema: 4647");
                }
            }
        }
    }//GEN-LAST:event_tfdCodCliKeyPressed

    private void fillProd( Produto prod )
    {
        lblProdInfo.setText(prod.getSummary());   
    }
    
    private void tfdCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCodProdKeyPressed
        // TODO add your handling code here:
        java.awt.event.KeyEvent e = evt;
        int code = e.getKeyCode();
        
        if ( code == KeyEvent.VK_ENTER ){
            String s = tfdCodProd.getText().trim();
            if ( Util.isInt(s) ){
                int codProd = Integer.parseInt(s);

                if (! ProdutosDB.exists(codProd) )
                    findProd();
                else{
                    Produto prod = ProdutosDB.find(codProd);
                    
                    if ( prod != null ){
                        fillProd(prod);
                    }
                    else
                        Log.log("Problema: 4647");
                }
            }
        }        
    }//GEN-LAST:event_tfdCodProdKeyPressed

    private boolean isEmptyTabProd()
    {
        return tblProd.getModel().getRowCount() == 0;
    }
    
    private void clearFields()
    {
        tfdCodCli.setText("");
        tfdCodProd.setText("");
        initQt();
        
        lblCliInfo.setText("");
        lblProdInfo.setText("");
        
        initTotal();
    }
    
    private void initTotal()
    {
        lblTotal.setText("Total:");
        lblValorTotal.setText("R$ 00.00");
    }
    
    private void initMov()
    {
        unlockCli();
        clearFields();
        tblProd.setModel(emptyModel);
    }
    
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
            java.util.logging.Logger.getLogger(MovView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnFindCli;
    private javax.swing.JButton btnFindProd;
    private javax.swing.JComboBox cbxMovType;
    private javax.swing.JComboBox cbxPayMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliInfo;
    private javax.swing.JLabel lblCodCli;
    private javax.swing.JLabel lblCodProd;
    private javax.swing.JLabel lblCodProd1;
    private javax.swing.JLabel lblPayMethod;
    private javax.swing.JLabel lblProdInfo;
    private javax.swing.JLabel lblProdMov;
    private javax.swing.JLabel lblQt;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField tfdCodCli;
    private javax.swing.JTextField tfdCodProd;
    private javax.swing.JTextField tfdQt;
    // End of variables declaration//GEN-END:variables
}
