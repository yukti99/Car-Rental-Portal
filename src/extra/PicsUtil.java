/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author yukti
 */
public class PicsUtil {
    
static JFileChooser fc;
    
    public static byte[] readImage() {
        InputStream is = null;
        byte[] bytes = null;
        try {
            File file = new File(fc.getSelectedFile().getAbsolutePath());
            is = new FileInputStream(file);
            // Get the size of the file
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                JOptionPane.showMessageDialog(null, "File is too large!");
                return null;
            }   // Create the byte array to hold the data
            bytes = new byte[(int) length];
            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }   // Ensure all the bytes have been read in
            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }   // Close the input stream and return bytes
            is.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return bytes;
    }

    public static ImageIcon getScaledImage(String filename) {
        ImageIcon imageIcon = new ImageIcon(filename); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        double h = 100.0 / imageIcon.getIconHeight();  // calculate w/h ratio
        Image newimg = image.getScaledInstance((int) (imageIcon.getIconWidth() * h),
                (int) (imageIcon.getIconHeight() * h), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
    }

    public static ImageIcon getImage() {
        fc = new JFileChooser();
        FileFilter jpegFilter = new ExtensionFileFilter(null, new String[]{"JPG", "JPEG", "PNG", "GIF"});
        fc.addChoosableFileFilter((javax.swing.filechooser.FileFilter) jpegFilter);
        fc.setFileFilter((javax.swing.filechooser.FileFilter) jpegFilter);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return getScaledImage(fc.getSelectedFile().getPath());
        }
        return null;
    }
}