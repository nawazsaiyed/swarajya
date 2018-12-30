package com.gvp.swarajya;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
	private static final long serialVersionUID = 1L;

	// location to store file uploaded
	private static  String UPLOAD_DIRECTORY;

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public void uploadFile(HttpServletRequest request)
	{
		UPLOAD_DIRECTORY = request.getServletContext().getRealPath("/images/upload");
		// checks if the request actually contains upload file
			if (!ServletFileUpload.isMultipartContent(request)) {
				// if not, we stop here
				request.setAttribute("error", "Error: Form must has enctype=multipart/form-data.");
				return;
			}
			
			
			// configures upload settings
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// sets memory threshold - beyond which files are stored in disk
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			// sets temporary location to store files
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			ServletFileUpload upload = new ServletFileUpload(factory);

			// sets maximum size of upload file
			upload.setFileSizeMax(MAX_FILE_SIZE);

			// sets maximum size of request (include file + form data)
			upload.setSizeMax(MAX_REQUEST_SIZE);

			// constructs the directory path to store upload file
			// this path is relative to application's directory
			String uploadPath =  File.separator + UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try {
				// parses the request's content to extract file data
				@SuppressWarnings("unchecked")
				List<FileItem> formItems = upload.parseRequest(request);

				if (formItems != null && formItems.size() > 0) {
					// iterates over form's fields
					for (FileItem item : formItems) {

						// processes only fields that are not form fields
						if (!item.isFormField()) {
							String fileName= null;
							if(request.getAttribute("fileName") == null)
								fileName = new File(item.getName()).getName();
							else
								fileName = new File(request.getAttribute("fileName").toString()).getName();
							

							System.out.println(fileName);
							String filePath = uploadPath + File.separator + fileName;
							File storeFile = new File(filePath);
							// saves the file on disk
							item.write(storeFile);
							request.setAttribute("fileName", filePath);
							request.setAttribute("message", "Upload has been done successfully!");
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}


	}

}
