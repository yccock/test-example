package com.test.classloader.unload;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SimpleClassLoader extends URLClassLoader {

    private List<JarURLConnection> cachedJarFiles = new ArrayList<JarURLConnection>();

    public SimpleClassLoader() {
        super(new URL[]{});
    }

    /**
     * loadClass：加载类的入口方法，调用该方法完成类的显式加载。通过对该方法的重新实现，我们可以完全控制和管理类的加载过程。
     *
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> aClass = null;
        //查看SimpleClassLoader实例缓存下，是否已经加载过class
        //不同的SimpleClassLoader实例是不共享缓存的
        aClass = findLoadedClass(name);
        if (aClass != null) {
            //根据resolve参数决定是否解析该类
            if (resolve) {
                resolveClass(aClass);
            }
            return aClass;
        }

        //如果类的包名为"java."开始，则有系统默认加载器AppClassLoader加载
        if (name.startsWith("java.")) {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            aClass = classLoader.loadClass(name);
            if (aClass != null) {
                if (resolve) {
                    //链接一个指定的类。这是一个在某些情况下确保类可用的必要方法。
                    resolveClass(aClass);
                }
            }
            return aClass;
        }
        aClass = customLoad(name, this);
        return aClass;
    }

    /**
     * 自定义类加载器
     * @param name
     * @param classLoader
     * @return
     * @throws ClassNotFoundException
     */
    public Class customLoad(String name, ClassLoader classLoader) throws ClassNotFoundException {
        SimpleClassLoader simpleClassLoader = (SimpleClassLoader) classLoader;
        //findClass()调用的是URLClassLoader里面重载了ClassLoader的findClass()方法
        Class<?> aClass = simpleClassLoader.findClass(name);
        return aClass;
    }

    /**
     * 加载jar包到classloader的classpath
     * @param file
     * @throws IOException
     */
    public void addJarFile(File file) throws IOException {
        if (!file.getName().endsWith(".jar")) {
            return;
        }
//        URL url = new URL("file", null, file.getCanonicalPath());
        URL url = new URL(String.format("jar:file:%s!/", file.getAbsolutePath()));
        URLConnection urlConnection = url.openConnection();
        // 打开并缓存文件url连接
        if (urlConnection instanceof JarURLConnection) {
            urlConnection.setUseCaches(true);
            cachedJarFiles.add((JarURLConnection) urlConnection);
        }
        super.addURL(url);
    }

    /**
     * 卸载jar，以便于删除
     */
    public void unloadJarFiles(){
        for (JarURLConnection cachedJarFile : cachedJarFiles) {
            try {
                cachedJarFile.getJarFile().close();
                cachedJarFile = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cachedJarFiles.clear();
    }
    /**
     * findClass方法：这是自定义class loader类必须覆盖的方法，用于告诉class loader到哪里去加载类，比如某个目录或者JAR URL等。
     * 参数name为要加载的类全名，如java.lang.String。该方法作为类加载的步骤之一被loadClass()方法调用
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public Set<Class> findInterfaceClassesByJarFile(File file) throws CustomException{
        if (!file.exists()) {
            throw new CustomException(file.getName() + " is not exist");
        }
        Set<Class> classes = new LinkedHashSet<Class>();
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(file);
            Enumeration<JarEntry> enumeration = jarFile.entries();
            while (enumeration.hasMoreElements()){
                JarEntry jarEntry = enumeration.nextElement();
                String name = jarEntry.getName();
                if (name != null && name.endsWith(".class")){
                    Class clazz = this.loadClass(name.replace("/", ".").substring(0, (name.length() - 6)), false);
                    if (clazz.isInterface() && !isContain(classes, clazz)) {
                        classes.add(clazz);
                    } else {
                        clazz = null;
                    }
                }
            }
        } catch (Exception e) {
            throw new CustomException("解析jar包异常: " + e.getMessage());
        } catch (Throwable e) {
            throw new CustomException("解析jar包异常: " + e.toString());
        } finally {
            try {
                if (jarFile != null) {
                    jarFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new CustomException(e.getMessage());
            }
        }
        return classes;
    }

    private boolean isContain(Set<Class> classes, Class clazz){
        boolean nameIsEqual = false;
        for (Class c : classes){
            if (c.isAssignableFrom(clazz)){
                nameIsEqual = true;
                break;
            }
        }
        return nameIsEqual;
    }

}
