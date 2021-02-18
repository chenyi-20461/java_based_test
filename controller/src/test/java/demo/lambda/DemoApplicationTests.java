package demo.lambda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void foreachTest() {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		for(int i = 0;i < 3;i++){
			arrayList.add(i);
		}
		Iterator iterable= arrayList.iterator();
//		while (iterable.hasNext()){
//			Integer a= (Integer) iterable.next();
//			if ((Integer) a==1){
//				return;
//			}
//		}
		System.out.println("循环");
		iterable.forEachRemaining(a-> {
			System.out.println(a);
			if ((Integer) a==1){
				return;
			}
		});

		System.out.println("循环1");
		arrayList.forEach(a-> a=a+1);
		arrayList.forEach(a-> System.out.println(a));

	}
//  接口作为参数
	DefaultTest testinterface(){
		return ()-> {System.out.println("a");};
	}



}
