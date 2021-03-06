// Class SimpleFilter unchanged from chapter 14

/**
 *  Copyright 1999-2002 Matthew Robinson and Pavel Vorobiev.
 *  All Rights Reserved.
 *
 *  ===================================================
 *  This program contains code from the book "Swing"
 *  2nd Edition by Matthew Robinson and Pavel Vorobiev
 *  http://www.spindoczine.com/sbe
 *  ===================================================
 *
 */

package net.sourceforge.vietpad;

import java.io.File;

public class SimpleFilter extends javax.swing.filechooser.FileFilter
{
    private String m_description = null;
    private String m_extension = null;

    public SimpleFilter(String extension, String description) {
        m_description = description;
        m_extension = "." + extension.toLowerCase();
    }

    @Override
    public String getDescription() {
        return m_description;
    }

    public String getExtension()    {
        return m_extension;
    }
    
    @Override
    public boolean accept(File f) {
        if (f == null) return false;
        if (f.isDirectory()) return true;
        if (m_extension.equals(".*")) return true;
        return f.getName().toLowerCase().endsWith(m_extension);
    }
}
