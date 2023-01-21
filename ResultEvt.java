package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import day0104.MainWindow;
import day0104.SubWindow;

public class ResultEvt extends WindowAdapter implements ActionListener {

	private Result result;
	
	public ResultEvt(Result result) {
		this.result=result;
	}//ResultEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		result.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed

}
