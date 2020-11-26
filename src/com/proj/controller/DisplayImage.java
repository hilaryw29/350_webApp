package com.proj.controller;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public final String imagesBase = System.getProperty("user.dir") + File.separator;
    private static final int DEFAULT_BUFFER_SIZE = 10240; 

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String URLAfterWebDomain = request.getRequestURI();
        System.out.println(URLAfterWebDomain);
        
        //Only accept mappings as src="/listingImages/whatever.jpg", even if web.xml has other mappings to this servlet.
        if(URLAfterWebDomain.startsWith("/mie350webapp/listingImages/") == false)   
            return;

        //get the image name, or even directory and image, e.g. /listingImages/music/beethoven.jpg:
        String relativeImagePath = URLAfterWebDomain.substring("/mie350webapp/".length());  //will get "music/beethoven.jpg"
        relativeImagePath = relativeImagePath.replace('/', File.separatorChar);
        
        System.out.println("\nFetching image from "+ imagesBase + relativeImagePath);

        ServletOutputStream outStream;
        outStream = response.getOutputStream();

        File file = new File(imagesBase + relativeImagePath);
        
        if (!file.exists()) {
        	System.out.println("CANNOT FIND FILE");
        }
        System.out.println("Found file: " + file.exists());
        String contentType = getServletContext().getMimeType(file.getName());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        
        // Init servlet response.
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open streams.
            input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

            // Write file contents to response.
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            System.out.println("OUTPUT SUCCESSFUL");
        } finally {
            // Gently close streams.
            close(output);
            close(input);
        }
        
    }
    
    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}