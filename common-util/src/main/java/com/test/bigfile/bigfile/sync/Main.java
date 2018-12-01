package com.test.bigfile.bigfile.sync;

import com.test.bigfile.file.FileWriteProcess;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<String> getInfoFromBigFile(String file){
		final List<String> list = new ArrayList<>();
		BigFileReader.Builder builder = new BigFileReader.Builder(file,new IHandle() {
			@Override
			public void handle(String line) {
				list.add(line);
			}
		});
		builder.setThreadSize(10).setCharset("utf-8").setBufferSize(1024*1024*5);//5M缓存
		BigFileReader bigFileReader = builder.build();
		bigFileReader.start();
		return list;
	}

	public static void main(String[] args) {
//		String file = args[0];
		String file = "c:/test.jtl";
		List<String> list = Main.getInfoFromBigFile(file);
		System.out.println(list.size());

		FileWriteProcess writeProcess = new FileWriteProcess("c:/test.txt", true);
		writeProcess.write(list);
		writeProcess.destroy();
	}
	
}
