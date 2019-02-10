package com.onclick;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//jay dubey
@WebServlet("/FileListServlet")
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FileListServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body");

		out.print("<div>");
		out.print("<marquee><h2 style=\"color:red;\">Complete Halo Report</h2></marquee>");
		out.print("</div>");
		try {
			
		  String rootFolderPath = "E:/Complite_Report"; 
		
			if (request.getPathInfo() != null) {
				rootFolderPath = rootFolderPath + request.getPathInfo();
			}
			File targetFile = new File(rootFolderPath);
			if (targetFile.exists()) {
				if (targetFile.isDirectory()) {

					StringBuilder sb = getFileListInfoString(request, rootFolderPath, targetFile);
					String wholeResponse = "<html><body>" + sb.toString() + "</body></html>";
					response.getWriter().print(wholeResponse);
					
				} else {
					
					response.setContentType(getContentType(targetFile));
					FileReader fileReader = new FileReader(targetFile);
					BufferedReader buffReader = new BufferedReader(fileReader);
					String buffer = new String();
					while( (buffer = buffReader.readLine() ) != null) 
					out.println(buffer);
					buffReader.close();
				
			     }
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		 }
		out.println("</body>");
		out.println("</html>");
	}

	private String getContentType(File targetFile) {
		String fileName = targetFile.getName();
		if (fileName.endsWith("png")) {
			return "image/png";
		} else if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")) {
			return "image/jpeg";
		} else if (fileName.endsWith("html") || fileName.endsWith("htm")) {
			return "text/html";
		} else if (fileName.endsWith("gif")) {
			return "image/gif";
		} else if (fileName.endsWith("pdf")) {
			return "application/pdf";
		} else if (fileName.endsWith("xml")) {
			return "application/xml";
		} else if (fileName.endsWith("txt")) {
			return "text/plain";
		} else if (fileName.endsWith("js")) {
			return "application/javascript";
		} else if (fileName.endsWith("css")) {
			return "text/css";
		}
		return "application/octet-stream";
	}

	private byte[] getFileContentAsString(File targetFile) throws IOException {
		return Files.readAllBytes(targetFile.toPath());
	}

	private StringBuilder getFileListInfoString(HttpServletRequest request, String rootFolderPath, File targetFile) {
		StringBuilder sb = new StringBuilder();
		sb.append("PathInfo:" + request.getPathInfo());
		sb.append("<h2><br/>Listing files/folders in Path:" + rootFolderPath + "<br/></h2>");
		File[] files = targetFile.listFiles();
		if (files != null) {
			if (request.getPathInfo() != null && !request.getPathInfo().equalsIgnoreCase("/")) {
				sb.append("<a href=\"javascript:history.back()\">Parent Directory</a>");
			}
			sb.append("<ul>");
			for (File file : files) {
				// if (file.isDirectory()) {
				sb.append("<li><h4><a href=\"").append(request.getRequestURI().startsWith("/") ? "" : "/")
						.append(request.getRequestURI()).append(request.getRequestURI().endsWith("/") ? "" : "/")
						.append(file.getName() + "\">" + file.getName() + "</a></h4></li>");
				// } else {
				// sb.append("<li>" + file.getName() + "</li>");
				// }
			}
			sb.append("</ul>");
		}
		return sb;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
