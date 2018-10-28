package com.test.compress;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class TarUtil {

    private static final Logger logger = LoggerFactory.getLogger(TarUtil.class);

    private static TarArchiveOutputStream createTarOutputArchiveStream(File tarName) throws FileNotFoundException {
        FileOutputStream outputStream = new FileOutputStream(tarName);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        TarArchiveOutputStream archiveOutputStream = new TarArchiveOutputStream(bufferedOutputStream);
        return archiveOutputStream;
    }

    private static TarArchiveInputStream createTarInputArchiveStream(File tarFile) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(tarFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        TarArchiveInputStream archiveInputStream = new TarArchiveInputStream(bis);
        return archiveInputStream;
    }

    /**
     * 生成压缩文件
     * @param tarName
     * @param files
     * @throws Exception
     */
    public static void tar(File tarName, List<File> files) throws Exception {
        TarArchiveOutputStream tarArchiveOutputStream = createTarOutputArchiveStream(tarName);
        for (File file : files) {
            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(file.getAbsolutePath());
            tarArchiveEntry.setSize(file.length());
            tarArchiveEntry.setMode(TarArchiveEntry.DEFAULT_FILE_MODE);
            tarArchiveEntry.setName(file.getName());
            tarArchiveOutputStream.putArchiveEntry(tarArchiveEntry);
            tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int count = -1;
                byte[] buffer = new byte[1024];
                while ((count = bis.read(buffer, 0, buffer.length)) != -1) {
                    tarArchiveOutputStream.write(buffer, 0, count);
                }

            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new Exception("Error while adding File to Tar file");
            } finally {
                IOUtils.closeQuietly(fis);
                IOUtils.closeQuietly(bis);
                tarArchiveOutputStream.closeArchiveEntry();
            }
        }
        tarArchiveOutputStream.finish();
        tarArchiveOutputStream.close();
    }

    /**
     * 解压缩
     * @param tarFile
     * @param destFile
     * @throws IOException
     */
    public static void untar(File tarFile, File destFile) throws IOException {
        TarArchiveInputStream tarArchiveInputStream = createTarInputArchiveStream(tarFile);
        TarArchiveEntry tarArchiveEntry = null;
        while ((tarArchiveEntry = tarArchiveInputStream.getNextTarEntry()) != null) {
            String fileName = tarArchiveEntry.getName();
            File targetFile = new File(destFile, fileName);
            if (tarArchiveEntry.isDirectory()) {
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
            } else {
                FileOutputStream fos = null;
                BufferedOutputStream bos = null;
                try {
                    if (!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    fos = new FileOutputStream(targetFile);
                    bos = new BufferedOutputStream(fos);
                    int count = -1;
                    byte[] buffer = new byte[1024];
                    while ((count = tarArchiveInputStream.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, count);
                    }
                    bos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                } finally {
                    IOUtils.closeQuietly(fos);
                    IOUtils.closeQuietly(bos);
                }
            }
        }
        tarArchiveInputStream.close();
    }

    private TarArchiveOutputStream createTarArchiveStream(File agentTar) throws IOException {
        FileOutputStream fos = new FileOutputStream(agentTar);
        return new TarArchiveOutputStream(new BufferedOutputStream(fos));
    }

    public static void addFileToTar(TarArchiveOutputStream tarStream, File file, String path) throws IOException {
        int mode = file.isDirectory() ? TarArchiveEntry.DEFAULT_DIR_MODE : TarArchiveEntry.DEFAULT_FILE_MODE;
        addFileToTar(tarStream, file, path, mode);
    }

    public static void addFolderToTar(TarArchiveOutputStream tarStream, String path) throws IOException {
        TarArchiveEntry archiveEntry = new TarArchiveEntry(path);
        archiveEntry.setMode(TarArchiveEntry.DEFAULT_DIR_MODE);
        tarStream.putArchiveEntry(archiveEntry);
        tarStream.closeArchiveEntry();
    }

    public static void addInputStreamToTar(TarArchiveOutputStream tarStream, InputStream inputStream, String path,
                                           long size, int mode) throws IOException {
        TarArchiveEntry entry = new TarArchiveEntry(path);
        entry.setSize(size);
        entry.setMode(mode);
        try {
            tarStream.putArchiveEntry(entry);
            IOUtils.copy(inputStream, tarStream);
        } catch (IOException e) {
            throw new IOException("Error while adding File to Tar file", e);
        } finally {
            tarStream.closeArchiveEntry();
        }
    }

    public static void addFileToTar(TarArchiveOutputStream tarStream, File file, String path, int mode) throws IOException {
        TarArchiveEntry entry = new TarArchiveEntry(path);
        entry.setSize(file.length());
        entry.setMode(mode);
        BufferedInputStream bis = null;
        try {
            tarStream.putArchiveEntry(entry);
            bis = new BufferedInputStream(new FileInputStream(file));
            IOUtils.copy(bis, tarStream);
        } catch (IOException e) {
            throw new IOException("Error while adding File to Tar file", e);
        } finally {
            IOUtils.closeQuietly(bis);
            tarStream.closeArchiveEntry();
        }
    }

    public static void main(String[] args) throws Exception {
        TarUtil.tar(new File("c:\\aa.tar"), Arrays.asList(new File("c:\\lib").listFiles()));
        TarUtil.untar(new File("C:\\44698476161154368.tar"), new File("C:\\Users\\"));
    }
}