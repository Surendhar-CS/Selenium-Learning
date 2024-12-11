package seleniumQA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

@Test
public class JavaStreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sura");
		names.add("Theodre");
		names.add("Thorkill");
		names.add("Caesar");
		int count=0;
		for(String name:names)
		{
			if(name.startsWith("T"))
			{
				count++;
			}
		}
		System.out.println(count);
		System.out.println(getCount(names));
		//prints the elements in arrayList
		names.stream().filter(n->(n.length()>4)).forEach(res->System.out.println(res));
	
	}
	public static Long getCount(ArrayList<String> names)
	{
		Long count=names.stream().filter(n-> n.startsWith("A")).count();
		return count;
	}
	@Test
	public  static void streamMap()
	{
		Stream.of("Don","Abhijit","Akshaya","Rama","Ravan").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("****************************************************");
		
		Stream.of("Don","Akshaya","Abhijit","Rama","Ravan").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	@Test
	public void streamConcat()
	{
		List<String> animals=List.of("Cat","Dog","Tiger","Lion","Rats");
		ArrayList<String> names = new ArrayList<String>();
		names.add("Thorfin");
		names.add("Kotaro");
		names.add("Zenitsu");
		names.add("Zoro");
		//stream concat
		Stream<String> Words = Stream.concat(names.stream(), animals.stream());
		//stream collect
		List<Integer> wordsLen=Words.filter(s->s.startsWith("Z")).map(s->s.length()).collect(Collectors.toList());
		wordsLen.stream().forEach(s->System.out.println(s));
	}
	@Test
	public void streamMis()
	{
		List<Integer> values=List.of(3,2,2,5,7,1,9,7);
		values.stream().distinct().sorted().map(n->n+2).forEach(n->System.out.println(n));
	}

}
