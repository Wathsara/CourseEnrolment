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
public class LecturerTable extends AbstractTableModel{
    private static final String[] COLUMN_NAME = {"ID","Qualification","Name","Faculty"};
    private static ArrayList<Lecturer> list;

    public LecturerTable(ArrayList<Lecturer> aList) {
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
                return list.get(rowIndex).getLecID();
            case 1:
                return list.get(rowIndex).getQualification();
            case 2:
                return list.get(rowIndex).getName();
            case 3:
                return list.get(rowIndex).getFaculty();
            default:
                return "Error";
                
            
        }
    }
    
    
}
