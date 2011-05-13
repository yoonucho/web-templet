package com.hw.shop.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelUtil extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List list = (List) model.get("list");
		
		String[] titles = (String[]) model.get("titles");
		String[] order = (String[]) model.get("order");
		String sheetName = (String) model.get("sheetName");
		String[] modifyRow = (String[]) model.get("modifyRow");
		
		
		if (list != null && list.size() > 0) {
			HSSFSheet sheet = createFirstSheet(workbook, sheetName);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			style.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			
			createColumnLabel(sheet,titles,style);
			
			int rowNum = 1;
			for( int i =0; i < list.size(); i ++){
				HashMap map = (HashMap) list.get(i);
				createPageRankRow(sheet, map, rowNum++,order);
			}
			if(modifyRow!=null && modifyRow.length > 2){
				modifyRow(sheet,modifyRow);
			}
		}
		
		String fileName = sheetName+".xls"; 
		fileName = new String(fileName.getBytes("euc-kr"), "8859_1"); 
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";"); 
		response.setHeader("Content-Transfer-Encoding", "binary"); 

	}

	
	private void modifyRow(HSSFSheet sheet, String[] titles) {
		
		int row = Integer.parseInt(titles[0]);
		int col = Integer.parseInt(titles[1]);
		                 
		HSSFRow firstRow = sheet.getRow(row);
		
		for(int i=2; i < titles.length; i++){
			HSSFCell cell= firstRow.getCell(col);	
			cell.setCellValue(titles[i]);
			col++;
		}
	}
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook,String sheetName) {
		HSSFSheet sheet = workbook.createSheet();
		if(sheetName !=null && !sheetName.equals("")){
			workbook.setSheetName(0, sheetName);
			sheet.setColumnWidth(1, (256 * 20));
		}else{
			workbook.setSheetName(0, "DATA");
			sheet.setColumnWidth(1, (256 * 20));
		}
		
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet, String[] titles,HSSFCellStyle style) {
		HSSFRow firstRow = sheet.createRow( 0);

		//sheet.

		
		if(titles !=null && titles.length>0){
			HSSFCell cell=null;
			
			for(int i =0; i < titles.length;i++){
				cell = firstRow.createCell( i);
				cell.setCellValue(titles[i]);
				cell.setCellStyle(style);
				sheet.setColumnWidth(i, (256 * 20));
				
				cell.setCellStyle(style);
			
			}
		}
	}

	private void createPageRankRow(HSSFSheet sheet, HashMap value, int rowNum, String[] order) {
		HSSFRow row = sheet.createRow( rowNum);
		HSSFCell cell=null;
		
		if(order !=null && order.length > 0){
			for (int j = 0; j < order.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue((String)value.get(order[j]));
			}
		}else{
			Set set = value.keySet();
			Object[] keys = set.toArray();
			
			for (int j = 0; j < keys.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue((String)value.get(keys[j]));
			}	
		}
	}
}
