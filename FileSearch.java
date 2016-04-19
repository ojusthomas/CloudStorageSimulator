package thread1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
  private String fileNameToSearch;
  private List<String> result = new ArrayList<String>();
	public static String sour;
  public String getFileNameToSearch() {
	return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
	this.fileNameToSearch = fileNameToSearch;
  }

  public List<String> getResult() {
	return result;
  }

  public static void main(String args,String f) throws IOException {

	FileSearch fileSearch = new FileSearch();
	File fil=new File(args);
	fileSearch.searchDirectory(fil,f );
	int count = fileSearch.getResult().size();
	if(count ==0){
	    System.out.println("\nNo result found!");
	}
	else{
	    System.out.println("\nFound " + count + " result!\n");
	    
	    for (String matched : fileSearch.getResult()){
	    	sour=matched;
		System.out.println("Found : " + matched);
	    }
	}
  }

  public void searchDirectory(File directory, String fileNameToSearch) {
	setFileNameToSearch(fileNameToSearch);
	if (directory.isDirectory()) {
	    search(directory);
	} else {
	    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
	}
  }

  private void search(File file) {

	if (file.isDirectory()) {
            //do you have permission to read this directory?	
	    if (file.canRead()) {
		for (File temp : file.listFiles()) {
		    if (temp.isDirectory()) {
			search(temp);
		    } else {
			if (getFileNameToSearch().equals(temp.getName())) {			
			    result.add(temp.getAbsoluteFile().toString());
		    }

		}
	    }
	 } else {
		System.out.println(file.getAbsoluteFile() + "Permission Denied");
	 }
      }

  }

}