import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortedDir {
	
	File obj = null;
	
	private SortedDir(File f) {
		
		if(f.isDirectory()) {
		
			this.obj = f;
		}
	}
	
	private String[] list() {
		
		return obj.list();
		
	}
	
	private List<Object> list(String regex) {
		
		List<Object> s;
		
		List<String> allFiles = Arrays.asList(Objects.requireNonNull(obj.list()));
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
