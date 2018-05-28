/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseenrolment;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wathsara
 */
public class AdminTable extends AbstractTableModel{
    private static final String[] COLUMN_NAME = {"FullName","Email","Address","Contact No"};
    private static ArrayList<AdminInsert> list;

    public AdminTable(ArrayList<AdminInsert> aList) {
        list = aList;
        
    }
    
    public String getColumnName(int columnIndex){
        return COLUMN_NAME[columnIndex];
    }
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        
        return COLUMN_NAME.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getFullName();
            case 1:
                return list.get(rowIndex).getEmail();
            case 2:
                return list.get(rowIndex).getAddress();
            case 3:
                return list.get(rowIndex).getContact();
            default:
                return "Error";
                
            
        }
    }
    
}
