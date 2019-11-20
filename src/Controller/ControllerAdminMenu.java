/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AdminMenu;
import View.AdminSubMngCars;
import View.AdminSubTransaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author user
 */
public class ControllerAdminMenu implements ActionListener{
    private AdminMenu view;
    private AdminSubMngCars view2;
    private AdminSubTransaksi view3;
    
    public ControllerAdminMenu(){
        view = new AdminMenu();
        view2 = new AdminSubMngCars();
        view3 = new AdminSubTransaksi();
        view.addActionListener(this);
        view2.addActionListener(this);
        view3.addActionListener(this);
        view.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnCust())){
            new ControllerCustomer();
            view.setVisible(false);
        }else if (source.equals(view.getBtnEmp())) {
            new Controller.ControllerAdminEmp();
            view.setVisible(false);
        }else if (source.equals(view.getBtnMngCars())) {
            view.setVisible(false);
            view2.setVisible(true);
        }else if (source.equals(view2.getBtnBack())) {
            view2.setVisible(false);
            view.setVisible(true);
        }else if (source.equals(view2.getBtnSUV())){
            new ControllerSUV();
            view2.setVisible(false);
        } else if (source.equals(view2.getBtnMpv())){
            new ControllerMPV();
            view2.setVisible(false);
        } else if (source.equals(view2.getBtnSedan())) {
            new ControllerSedan();
            view2.setVisible(false);
        } else if (source.equals(view.getBtnMngTrs())){
            view.setVisible(false);
            view3.setVisible(true);
        } else if (source.equals(view3.getBtnBackMenu())){
            view3.setVisible(false);
            view.setVisible(true);
        } else if (source.equals(view3.getBtnLoadPemesanan())){
            new ControllerPemesanan();
            view3.setVisible(false);
        }
    }
       
}
