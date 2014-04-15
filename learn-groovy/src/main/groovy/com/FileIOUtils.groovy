package com

import groovy.io.FileType;

class FileIOUtils {

	static main(args) {
		
		//String folder=  'D:/SkyDrive/Books/NewBooks'
		String folder = 'D:/tmp'
		def file = new File(folder+'/sample1.txt');
		def name = 'siva'
		/*
		file.text = """log log log\n 
                      heelo ${name}
					  how r u"""
		*/
		/*
	  file.append('What\'s in a name? That which we call a rose,\n')
	  file.append('By any other name would smell as sweet.')
		
	  file << 'What\'s in a name? That which we call a rose\n'
	  file << 'By any other name would smell as sweet.'
	  
	  def input = new File('D:/tmp/input.txt');
	  def output = new File('D:/tmp/output.txt');
	  
	  input.withReader{ reader ->
		  reader.transformLine(output.newWriter()) { line ->
			  line.replaceAll('\t', '-')
		  }		  
	  }
	  
	  */
		/*
		def input = new File('D:/tmp/input.txt');
		def output = new File('D:/tmp/input.txt.bak');
		output.text = input.text;
		input.text = output.text.replaceAll("##NAME##", "SIVA")
								.replaceAll("#EMAIL#", "SIVA@GMAIL.COM");
		
		*/
		/*
		def input = new File('D:/tmp/input.txt');
		def repalce = "Name : SIVA"
		def txt = '''\n
					ADDRESS: 'HYD'
					Mobile: 90000000000000000
					'''
		input.text = input.text.replaceFirst(repalce, repalce+txt);
		*/
		
		/*
		def rootDir = new File('D:/SkyDrive/Books/NewBooks')
		
		rootDir.eachFileRecurse { f ->
			println f.name
		}
		
		rootDir.eachFileRecurse(FileType.FILES) { f ->
			println f.name
		}
		
		rootDir.traverse { File f ->
			println '-->'+f.name
		}
		*/
		
		def mavenRepo = new File('D:\\Apps\\apache-maven-3.0.3\\.m2\\repository')
		def count =0
		mavenRepo.traverse(
			type: FileType.FILES,
			nameFilter : ~/.*\.jar/
			) {
			println it.name
			count ++
		}
		println "Total Jars: "+count
		
		
		
	}

}
