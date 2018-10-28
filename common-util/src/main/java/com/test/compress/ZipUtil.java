package com.test.compress;

import com.google.common.base.Preconditions;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {

    private static final Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    public static void zip(File src) throws IOException {
        zip(src, Charset.defaultCharset().name(), true);
    }

    public static void zip(File src, boolean includeSrc) throws IOException {
        zip(src, Charset.defaultCharset().name(), includeSrc);
    }

    public static void zip(File src, String charSetName, boolean includeSrc) throws IOException {
        zip(src, src.getParentFile(), charSetName, includeSrc);
    }

    public static void zip(File src, OutputStream os) throws IOException {
        zip(src, os, Charset.defaultCharset().name(), true);
    }

    public static void zip(File src, File destDir, String charSetName, boolean includeSrc) throws IOException {
        String fileName = src.getName();
        if (!src.isDirectory()) {
            int pos = fileName.lastIndexOf(".");
            if (pos > 0) {
                fileName = fileName.substring(0, pos);
            }
        }
        fileName += ".zip";

        File zippedFile = new File(destDir, fileName);
        if (!zippedFile.exists()) {
            zippedFile.createNewFile();
        }
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(zippedFile);
            zip(src, os, charSetName, includeSrc);
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    public static void zip(File src, OutputStream os, String charsetName, boolean includeSrc) throws IOException {
        ZipArchiveOutputStream zos = new ZipArchiveOutputStream(os);
        zos.setEncoding(charsetName);
        FileInputStream fis = null;

        int length;
        ZipArchiveEntry ze;
        byte[] buf = new byte[8 * 1024];
        String name;

        Stack<File> stack = new Stack<File>();
        File root;
        if (src.isDirectory()) {
            if (includeSrc) {
                stack.push(src);
                root = src.getParentFile();
            } else {
                File[] fs = Preconditions.checkNotNull(src.listFiles());
                for (int i = 0; i < fs.length; i++) {
                    stack.push(fs[i]);
                }

                root = src;
            }
        } else {
            stack.push(src);
            root = src.getParentFile();
        }

        while (!stack.isEmpty()) {
            File f = stack.pop();
            name = toPath(root, f);
            if (f.isDirectory()) {
                File[] fs = Preconditions.checkNotNull(f.listFiles());
                for (int i = 0; i < fs.length; i++) {
                    if (fs[i].isDirectory()) {
                        stack.push(fs[i]);
                    } else {
                        stack.add(0, fs[i]);
                    }
                }
            } else {
                ze = new ZipArchiveEntry(name);
                zos.putArchiveEntry(ze);
                try {
                    fis = new FileInputStream(f);
                    while ((length = fis.read(buf, 0, buf.length)) >= 0) {
                        zos.write(buf, 0, length);
                    }
                } finally {
                    IOUtils.closeQuietly(fis);
                }
                zos.closeArchiveEntry();
            }
        }
        zos.close();
    }

    private static String toPath(File root, File dir) {
        String path = dir.getAbsolutePath();
        path = path.substring(root.getAbsolutePath().length()).replace(File.separatorChar, '/');
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        if (dir.isDirectory() && !path.endsWith("/")) {
            path += "/";
        }
        return path;
    }

    public static void unzip(File zippedFile, String charsetName) throws Exception {
        unzip(zippedFile, zippedFile.getParentFile(), charsetName);
    }

    public static void unzip(File zippedFile, File destDir, String charsetName) throws Exception {
        unzip(new FileInputStream(zippedFile), destDir, charsetName);
    }

    public static void unzip(InputStream is, File destDir, String charsetName) throws Exception {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;
        FileOutputStream fos = null;
        try {
            File folder = destDir;
            if (!folder.exists()) {
                folder.mkdir();
            }

            zis = new ZipInputStream(is);
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {
                String fileName = ze.getName();

                File newFile = new File(destDir.getAbsolutePath(), fileName);
                if (newFile.getPath().contains("..")) {
                    throw new IllegalArgumentException("zip entry should not contain .. in the path.");
                }
                if (ze.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    IOUtils.closeQuietly(fos);
                }

                ze = zis.getNextEntry();
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(zis);
        }
    }


    public static void main(String[] args) throws Exception {

    }
}