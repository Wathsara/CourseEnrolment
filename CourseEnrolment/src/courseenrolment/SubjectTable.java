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
public class SubjectTable extends AbstractTableModel {
    private static final String[] COLUMN_NAME = {"ID","Subject Name","Type","Acadamic Year","Semester","Subject Type","Lecturer Incharge","Credit","Subject Fee"};
    private static ArrayList<Subject> list;

    public SubjectTable(ArrayList<Subject> aList) {
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
                return list.get(rowIndex).getSubCode();
            case 1:
                return list.get(rowIndex).getSubName();
            case 2:
                return list.get(rowIndex).getType();
            case 3:
                return list.get(rowIndex).getAcademicYear();
            case 4:
                return list.get(rowIndex).getSemester();
            case 5:
                return list.get(rowIndex).getSubType();
            case 6:
                return list.get(rowIndex).getLecturerIncharge();
            case 7:
                return list.get(rowIndex).getCredit();
            case 8:
                return list.get(rowIndex).getSubFee();
            default:
                return "Error";
                
            
        }
    }
}
