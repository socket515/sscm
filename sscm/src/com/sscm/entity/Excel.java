package com.sscm.entity;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel {
	private String title;
	private Label[] header;//表头
	private Label[][] content;//内容
	public Excel(String title, String[] col){
		setTitle(title);
		header = new Label[col.length];
		for(int i=0; i<col.length;i++){
			header[i] = new Label(i, 0, col[i]);
		}
	}
	public void setContent(List<? extends Filed> filed){
		if (filed==null||filed.size()==0) {
			return;
		}
		content = new Label[filed.size()][filed.get(0).getNum()];
		for (int i = 0; i < filed.size(); i++) {
			String[] row = filed.get(i).getFiled();
			for(int j=0;j<row.length;j++){
				content[i][j] = new Label(j, i+1, row[j]);
			}
		}
	}
	public void  wirte(OutputStream os) throws IOException, RowsExceededException, WriteException{
		if (header==null||header.length==0) {
			return;
		}
		WritableWorkbook wbook = Workbook.createWorkbook(os);
		WritableSheet wsheet = wbook.createSheet(title, 0); // sheet名称
		for (Label label : header) {
			wsheet.addCell(label);
		}
		if(content!=null&&content.length!=0){
			for (Label[] labels : content) {
				for (Label label : labels) {
					wsheet.addCell(label);
				}
			}
		}
		wbook.write();
		wbook.close();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Label[] getHeader() {
		return header;
	}
	public void setHeader(Label[] header) {
		this.header = header;
	}
	public Label[][] getContent() {
		return content;
	}
	public void setContent(Label[][] content) {
		this.content = content;
	}
	
}
