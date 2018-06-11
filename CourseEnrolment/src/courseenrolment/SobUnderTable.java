/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseenrolment;

/**
 *
 * @author wathsara
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class SobUnderTable extends AbstractTableModel{
    private static final String[] COLUMN_NAME = {"ID","Name","Academic Year","GPA","Credits"};
    private static ArrayList<Student> list;

    public SobUnderTable(ArrayList<Student> aList) {
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
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getAcademicYear();
            case 3:
                return list.get(rowIndex).getGp();
            case 4:
                return list.get(rowIndex).getCredits();
            default:
                return "Error";
                
            
        }
    }
    
}
