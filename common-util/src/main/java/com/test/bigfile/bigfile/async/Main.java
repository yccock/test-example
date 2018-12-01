package com.test.bigfile.bigfile.async;

public class Main {

	public static void main(String[] args) {
		BigFileReader.Builder builder = new BigFileReader.Builder("c:/test.jtl",new IHandle() {
			
			@Override
			public void handle(String line) {
				System.out.println(line);
			}
		});
		builder.withTreahdSize(10)
			   .withCharset("gbk")
			   .withBufferSize(1024*1024);
		BigFileReader bigFileReader = builder.build();
		bigFileReader.start();
	}
	
}
