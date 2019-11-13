import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDir {
	
	File obj = null;
	
	public SortedDir(File f) {
		
		if(f.isDirectory()) {
		
			this.obj = f;
			
		}
	}
	
	public String[] list() {
		
		return obj.list();
		
	}
	
	public List<Object> list(String regex) {
		
		List<Object> s;
		
		List<String> allFiles = Arrays.asList(obj.list());
		s = allFiles.stream().filter(a->a.matches(regex)).collect(Collectors.toList());
		
		return s;
		
	}

	public static void main(String[] args) {
		
		SortedDir d = new SortedDir(new File("E:\\All Jar Files"));
		
		Arrays.spliterator(d.list(), 0, d.list().length);
	//	System.out.println(Arrays.asList(d.list()));
		System.out.println(d.list("[a-zA-Z0-9]*"));

	}

}
