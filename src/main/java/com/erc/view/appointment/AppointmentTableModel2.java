package com.erc.view.appointment;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import com.erc.entities.AppointmentDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.user.service.AppointmentService;

public class AppointmentTableModel2 extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
	private PatientDTO patientDTO = new PatientDTO();
	private ArrayList<AppointmentRow> appointmentList = new ArrayList<AppointmentRow>();
	private StaffDTO staffDTO = new StaffDTO();
	private String columnNames[] = { "Randevu Saati", "Hasta Adý Soyadý", "Doktor", "Randevu Oluþturulma Tarihi",
			"Randevu Güncellenme Tarihi" };
	private String patientName;
	private String doctorName;
	private MyTableCellRenderer myTableCellRenderer = new MyTableCellRenderer();
	private ArrayList<String> patientNameList = new ArrayList<String>();
	List<Color> rowColours = Arrays.asList(Color.RED, Color.GREEN, Color.CYAN);

	public void setRowColour(int row, Color c) {
		rowColours.set(row, c);
		fireTableRowsUpdated(row, row);
	}

//	public void setRowColour(JTable table, int row,int column) {
//		AppointmentTableModel2 model = (AppointmentTableModel2) table.getModel();
//		if(table.getValueAt(row, column).toString().equals(null)) {
//			rowColours.set(row,Color.GREEN);
//			fireTableRowsUpdated(row, row);		        	
//        }else {
//        	rowColours.set(row,Color.RED);
//			fireTableRowsUpdated(row, row);	
//        }
//	}
//	
	public Color getRowColour(int row) {
		return rowColours.get(row);
	}

	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}

//	
//	private SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
	/*
	 * //servisten appointenList list getirldii for(appointnmentrow in
	 * appointmentRowList) { appointmentRowHour =
	 * hourFormat.format(appointnmentrow.getDate); //servisten getireln data
	 * 
	 * for(appointment in appointenList ) { appointmentHour =
	 * hourFormat.format(appointment);
	 * 
	 * if(appointmentHour.eqa }
	 * 
	 * }
	 */
	public boolean controlAppointment() {
		AppointmentService appService = new AppointmentService();
		ArrayList<AppointmentDTO> appointmentLists = appService.getAllAppointmentList();
		for (AppointmentDTO appointment : appointmentLists) {
			String appointmentHour = appointment.getStringSaat();

			for (AppointmentRow appRow : appointmentList) {
				String appRowHour = hourFormat.format(appRow.getDate());
				if (appointmentHour.equals(appRowHour)) {
					if (appointment.getAppointmentID() != null && appointment.getAppointmentID() != null) {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Randevu dolu", "Alert", JOptionPane.WARNING_MESSAGE);
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return appointmentList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		AppointmentRow appointmentRow = appointmentList.get(row);

		appointmentRow.getDate();
		AppointmentDTO appointmentDTO = appointmentRow.getAppointment();
		PatientDTO patient = appointmentDTO.getPatientDTO();

		StaffDTO staff = appointmentDTO.getStaffDTO();
		// String doctorName = staff.getName();

		switch (col) {
		case 0:
			return hourFormat.format(appointmentRow.getDate());
		case 1:
			if (patient != null) {
				return patient.getName() + " " + patient.getSurname();
			} else {
				return "";
			}
		case 2:
			if (staff != null) {
				return staff.getName() + " " + staff.getLastname();
			} else {
				return null;
			}
		case 3:
			return appointmentDTO.getAppointmentCreate();
		case 4:
			return appointmentDTO.getAppointmentUpdate();

		}
		return null;
	}

	public ArrayList<AppointmentRow> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<AppointmentRow> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public void addAppointmentRow(AppointmentRow appointmentRow) {
		this.appointmentList.add(appointmentRow);
	}

	public void setPatientDTO(PatientDTO patientDTO) {
		patientName = patientDTO.getName() + " " + patientDTO.getSurname();
		this.patientDTO = patientDTO;
	}

	public void setStaffDTO(StaffDTO staffDTO) {
		doctorName = staffDTO.getName() + " " + staffDTO.getLastname();
		this.staffDTO = staffDTO;

	}

//	static class MyTableCellRenderer extends DefaultTableCellRenderer {
//
//	    @Override
//	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//	    	AppointmentTableModel2 model = (AppointmentTableModel2) table.getModel();
//	        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//	        c.setBackground(model.getRowColour(row));
//	        return c;
//	    }
//	}
	static class MyTableCellRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			AppointmentTableModel2 model = (AppointmentTableModel2) table.getModel();
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (table.getValueAt(row, column).toString().equals(null)) {
				c.setBackground(Color.GREEN);
				model.setRowColour(row, Color.GREEN);
			} else {
				c.setBackground(Color.RED);
				model.setRowColour(row, Color.RED);
			}
		

			c.setBackground(model.getRowColour(row));
			return c;
		}
		
	}

}
//class CustomRenderer extends DefaultTableCellRenderer 
//{
//private static final long serialVersionUID = 6703872492730589499L;
//
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
//    {
//    	AppointmentTableModel2 tableModel = new AppointmentTableModel2();
//        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
////        if(table.getValueAt(row, column).equals("Y")){
////            cellComponent.setBackground(Color.YELLOW);
////        } else if(table.getValueAt(row, column).equals("N")){
////            cellComponent.setBackground(Color.GRAY);
////        }
//        if(table.getValueAt(row, column).toString().equals(null)) {
//        	cellComponent.setBackground(Color.GREEN);
//        }else {
//        	cellComponent.setBackground(Color.RED);  
//        }
//            
//        return cellComponent;
//    }
//}
