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
public class TimeTable extends AbstractTableModel{
    private static final String[] COLUMN_NAME = {"Day","Time From","Time To","lecturer/Instructor","Subject","Hall/Lab"};
    private static ArrayList<RoomAllocation> list;

    public TimeTable(ArrayList<RoomAllocation> aList) {
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
                return list.get(rowIndex).getDay();
            case 1:
                return list.get(rowIndex).getTimeFrom();
            case 2:
                return list.get(rowIndex).getTimeTo();
            case 3:
                return list.get(rowIndex).getLecIns();
            case 4:
                return list.get(rowIndex).getSubject();
            case 5:
                return list.get(rowIndex).getRoom();
            default:
                return "Error";
                
            
        }
    }
}
