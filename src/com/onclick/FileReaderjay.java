package com.onclick;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileReaderjay")
public class FileReaderjay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FileReaderjay() {
        super();
    
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		out.print("Hello jay....");
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			String rootFolderPath="E:/Complite_Report";
			//List<String> fileNameList =new ArrayList<String>().giveFileList(rootFolderPath);
			
	        File pdfFolder = new File(request.getSession().getServletContext().getRealPath("WebContent/Finishline_Build4/CTSReport.html"));

	        for (File html : pdfFolder.listFiles()) { 
	            out.println(html.getName());
	        }
	    } catch (IOException e) {
	        //log.log(Level.SEVERE, e.getMessage());
	    }
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			((ServletResponse) request).setContentType("application/json");
			request.setCharacterEncoding("UTF-8");
			
		
	        File pdfFolder = new File(request.getSession().getServletContext().getRealPath("WebContent/Finishline_Build4/CTSReport.html"));

	        for (File html : pdfFolder.listFiles()) { // Line 27
	            out.println(html.getName());
	        }
	    } catch (IOException e) {
	        //log.log(Level.SEVERE, e.getMessage());
	    }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
